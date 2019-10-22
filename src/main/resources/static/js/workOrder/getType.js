layui.use(['table', 'table','form'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var form = layui.form;

    var formDate;
    var sort;

    var currentTable = function(){
        // 渲染表格
        layer.load(2);
        table.render({
            elem: '#currentTable',
            url: '/workOrder/getTypeList',
            initSort: sort,
            cols: [
                [
                    {type: "checkbox", width: 50, fixed: "left"},
                    {field: 'typeId', width: 80, title: 'ID', sort: true},
                    {field: 'typeName', title: '类型名称'},
                    {field: 'typeStatus', title: '类型状态', sort: true, templet:function (d) {
                        if(d.typeStatus == 1){
                            return '启用';
                        }else{
                            return '停用';
                        }
                    }},
                    {field: 'createName', title: '创建人'},
                    {field: 'createTime', title: '创建时间', sort: true},
                    {title: '操作', minWidth: 50, templet: '#currentTableBar', fixed: "right", align: "center"}
                ]
            ],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            where: formDate,
            response: {
                statusName: 'code' //数据状态的字段名称，默认：code
                ,statusCode: 0 //成功的状态码，默认：0
                ,msgName: 'msg' //状态信息的字段名称，默认：msg
                ,countName: 'count' //数据总数的字段名称，默认：count
                ,dataName: 'data' //数据列表的字段名称，默认：data
            },
            done: function () {
                layer.closeAll('loading');
            }
        });
    };

    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        formDate = data.field;
        //执行搜索重载
        currentTable();
        return false;
    });

    //监听表格排序问题
    table.on('sort(currentTable)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        sort = obj;
        formDate['field'] = obj.field;
        formDate['order'] = obj.type;
        currentTable();
    });

    $('#btn-add').click(function () {
        //新增工单类型弹窗
        layer.open({
            type: 2,
            title: '新增类型',
            shadeClose: true,
            shade: 0,
            area: ['675px', '500px'],
            content: ['/workOrder/addType','yes'],
            end: function () {//无论是确认还是取消，只要层被销毁了，end都会执行，不携带任何参数。layer.open关闭事件
                currentTable();　//layer.open关闭刷新
            }
        });
    });

});