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
            url: '/admin/getAdminList',
            initSort: sort,
            cols: [
                [
                    {type: "checkbox", width: 50, fixed: "left"},
                    {field: 'adminId', width: 80, title: 'ID', sort: true},
                    {field: 'adminName', title: '用户账号'},
                    {field: 'realName', title: '用户姓名'},
                    {field: 'adminStatus', title: '用户状态', sort: true, templet:function (d) {
                        if(d.adminStatus == 1){
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
        //新增角色弹窗
        openDialog('新增用户','380','420','/admin/addAdmin',currentTable);
    });

    $('#btn-delete').click(function () {
        //获取批量选中的ID
        var ids = getTableCheckBox(table,'currentTable','adminId');
        if (ids != ""){
            //批量删除
            openConfirm("你确认要删除吗？",function(){
                //删除用户
                $.post(
                    "/admin/deleteAdmin",
                    {"inAdminId":ids},
                    function (obj) {
                        responseObj(obj);
                        currentTable();
                    },
                    "JSON"
                );
            });
        }
    });

    $('#btn-change').click(function () {
        //获取批量选中的ID
        var ids = getTableCheckBox(table,'currentTable','adminId');
        if (ids != ""){
            //批量修改用户状态
            $.post(
                "/admin/changeAdminStatus",
                {"inAdminId":ids},
                function (obj) {
                    responseObj(obj);
                    currentTable();
                },
                "JSON"
            );
        }
    });

    //监听工具条
    table.on('tool(currentTable)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;
        if (layEvent === 'del') {
            openConfirm("你确认要删除吗？",function(){
                //删除用户
                $.post(
                    "/admin/deleteAdmin",
                    {"inAdminId":data.adminId},
                    function (obj) {
                        responseObj(obj);
                        currentTable();
                    },
                    "JSON"
                );
            });
        } else if (layEvent === 'edit') {
            var url = '/admin/updateAdmin?adminId='+data.adminId;
            //修改角色弹窗
            openDialog('修改角色','380','390',url,currentTable);
        } else if(layEvent === 'empowerment'){
            var url = '/admin/empowermentRole?adminId='+data.adminId;
            //角色分配权限弹窗
            openDialog('分配角色','400','500',url,currentTable);
        }
    });
});