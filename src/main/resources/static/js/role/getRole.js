layui.use(['table', 'table','form', 'treetable'], function () {
    var $ = layui.jquery;
    var treeTable = layui.treetable;
    var table = layui.table;
    var form = layui.form;

    var formDate;
    var currentTable = function(){
        // 渲染表格
        layer.load(2);
        treeTable.render({
            treeColIndex: 1,//树形图标显示在第几列
            treeSpid: -1,//最上级的父级id
            treeDefaultClose: false,//是否默认折叠
            treeLinkage: true,//父级展开时是否自动展开所有子级
            treeIdName: 'roleId',//id字段的名称
            treePidName: 'parentRoleId',//pid字段的名称
            where: formDate,
            elem: '#currentTable',
            url: '/role/getRoleList',
            cols: [
                [
                    {field: 'roleId', title: 'ID'},
                    {field: 'roleName', title: '角色名称'},
                    {field: 'roleDescribe', title: '角色描述'},
                    {field: 'createName', title: '创建人'},
                    {field: 'createTime', title: '创建时间'},
                    {title: '操作', minWidth: 50, templet: '#currentTableBar', fixed: "right", align: "center"}
                ]
            ],
            done: function () {
                layer.closeAll('loading');
            }
        });
    };

    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        formDate = data.field;
        //执行搜索重载
        currentTable(formDate);
        return false;
    });

    $('#btn-add').click(function () {
        //新增角色弹窗
        layer.open({
            type: 2,
            title: '新增角色',
            shadeClose: true,
            shade: 0,
            area: ['550px', '420px'],
            content: ['/role/addRole','no'],
            end: function () {//无论是确认还是取消，只要层被销毁了，end都会执行，不携带任何参数。layer.open关闭事件
                currentTable();　//layer.open关闭刷新
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
                        currentTable();
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
                        currentTable();
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
                area: ['380px', '420px'],
                content: [url ,'no'],
                end: function () {//无论是确认还是取消，只要层被销毁了，end都会执行，不携带任何参数。layer.open关闭事件
                    currentTable();　//layer.open关闭刷新
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
                area: ['500px', '75%'],
                content: [url ,'yes'],
                end: function () {//无论是确认还是取消，只要层被销毁了，end都会执行，不携带任何参数。layer.open关闭事件
                    currentTable();//layer.open关闭刷新
                }
            });
        }
    });
});