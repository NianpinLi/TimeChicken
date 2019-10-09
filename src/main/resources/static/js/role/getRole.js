layui.use(['table', 'table','form'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var form = layui.form;

    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        var result = data.field;
        //执行搜索重载
        // 渲染表格
        layer.load(2);
        table.render({
            elem: '#currentTable',
            url: '/role/getRoleList',
            cols: [
                [
                {type: "checkbox", width: 50, fixed: "left"},
                {field: 'roleId', width: 80, title: 'ID', sort: true},
                {field: 'roleName', title: '角色名称'},
                {field: 'roleDescribe', title: '角色描述'},
                {field: 'roleStatus', title: '角色状态', sort: true, templet:function (d) {
                    if(d.roleStatus == 1){
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
            where: result,
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
        return false;
    });

    //监听表格排序问题
    table.on('sort(currentTable)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        console.log(obj.field); //当前排序的字段名
        console.log(obj.type); //当前排序类型：desc（降序）、asc（升序）、null（空对象，默认排序）
        console.log(this); //当前排序的 th 对象
        var result = {"field":obj.field,"order":obj.type};

        var params = $("#searchForm").serializeArray();
        $(params).each(function(){
            if(result[this.name]){
                result[this.name]+=';'+this.value;
            }else{
                result[this.name]=this.value;
            }
        });
        //尽管我们的 table 自带排序功能，但并没有请求服务端。
        //有些时候，你可能需要根据当前排序的字段，重新向服务端发送请求，从而实现服务端排序，如：
        table.reload('currentTable', { //testTable是表格容器id
            initSort: obj //记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
            ,where: result
        });
    });

    $('#btn-add').click(function () {
        //新增角色弹窗
        layer.open({
            type: 2,
            title: '新增角色',
            shadeClose: true,
            shade: 0,
            area: ['380px', '390px'],
            content: ['/role/addRole','no'],
            end: function () {//无论是确认还是取消，只要层被销毁了，end都会执行，不携带任何参数。layer.open关闭事件
                table.reload("currentTable");　　//layer.open关闭刷新
            }
        });
    });

    $('#btn-delete').click(function () {
        //获取批量选中的ID
        var ids = getTableCheckBox(table,'currentTable','roleId');
        if (ids != ""){
            //批量删除
            layer.confirm('您确认要删除这些角色吗？', {
                btn: ['确认','取消'] //按钮
            }, function(){
                //删除角色
                $.post(
                    "/role/deleteRole",
                    {"inRoleId":ids},
                    function (obj) {
                        responseObj(obj);
                        table.reload("currentTable");
                    },
                    "JSON"
                );
            });
        }
    });

    //监听工具条
    table.on('tool(currentTable)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;
        if (layEvent === 'del') {
            layer.confirm('确认删除当前角色吗？',{
                btn: ['确认','取消'] //按钮
            }, function(){
                //删除角色
                $.post(
                    "/role/deleteRole",
                    {"inRoleId":data.roleId},
                    function (obj) {
                        responseObj(obj);
                        table.reload("currentTable");
                    },
                    "JSON"
                );
            });
        } else if (layEvent === 'edit') {
            var url = '/role/updateRole?roleId='+data.roleId;
            //修改角色弹窗
            layer.open({
                type: 2,
                title: '修改角色',
                shadeClose: true,
                shade: 0,
                area: ['380px', '390px'],
                content: [url ,'no'],
                end: function () {//无论是确认还是取消，只要层被销毁了，end都会执行，不携带任何参数。layer.open关闭事件
                    table.reload("currentTable");　　//layer.open关闭刷新
                }
            });

        } else if(layEvent === 'empowerment'){
            var url = '/role/empowermentAuthority?roleId='+data.roleId;
            //角色分配权限弹窗
            layer.open({
                type: 2,
                title: '分配权限',
                shadeClose: true,
                shade: 0,
                area: ['400px', '650px'],
                content: [url ,'no'],
                end: function () {//无论是确认还是取消，只要层被销毁了，end都会执行，不携带任何参数。layer.open关闭事件
                    table.reload("currentTable");//layer.open关闭刷新
                }
            });
        }
    });
});