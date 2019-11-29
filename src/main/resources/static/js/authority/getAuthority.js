layui.use(['table', 'treetable','form'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var treeTable = layui.treetable;
    var form = layui.form;

    var formData;

    var currentTable = function(){
        // 渲染表格
        layer.load(2);
        treeTable.render({
            treeColIndex: 1,//树形图标显示在第几列
            treeSpid: -1,//最上级的父级id
            treeDefaultClose: true,//是否默认折叠
            treeLinkage: false,//父级展开时是否自动展开所有子级
            treeIdName: 'authorityId',//id字段的名称
            treePidName: 'parentAuthorityId',//pid字段的名称
            where:formData,//查询条件
            elem: '#menu-table',
            url: '/authority/getAuthorityList',
            page: false,
            cols: [
                [
                    {field: 'authorityId', title: '权限ID'},
                    {field: 'authorityName', minWidth: 200, title: '权限名称'},
                    {field: 'authorityIdentifier', title: '权限标识'},
                    {field: 'authorityIcon', title: '权限图标'},
                    {field: 'authorityUrl', title: '菜单url'},
                    {
                        field: 'parentAuthorityId', width: 80, align: 'center', templet: function (date) {
                        if (date.authorityType == 2) {
                            return '<span class="layui-badge layui-bg-gray">按钮</span>';
                        }
                        if (date.parentAuthorityId == -1) {
                            return '<span class="layui-badge layui-bg-blue">目录</span>';
                        } else {
                            return '<span class="layui-badge-rim">菜单</span>';
                        }
                    }, title: '类型'
                    },
                    {templet: '#auth-state', width: 120, align: 'center', title: '操作'}
                ]
            ],

            done: function () {
                layer.closeAll('loading');
            }
        });
    };

    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        formData = data.field;
        //执行搜索重载
        currentTable(formData);
        return false;
    });

    $('#btn-expand').click(function () {
        treeTable.expandAll('#menu-table');
    });

    $('#btn-fold').click(function () {
        treeTable.foldAll('#menu-table');
    });
    $('#btn-add').click(function () {
        //新增权限弹窗
        openDialog('新增权限','550','550','/authority/addAuthority',currentTable);
    });

    //监听工具条
    table.on('tool(menu-table)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;
        if (layEvent === 'del') {
            openConfirm("你确认要删除吗？",function(){
                //删除用户
                $.post(
                    "/authority/deleteAuthority",
                    {"equalToAuthorityId":data.id},
                    function (obj) {
                        responseObj(obj);
                        currentTable();
                    },
                    "JSON"
                );
            });
        } else if (layEvent === 'edit') {
            var url = '/authority/updateAuthority?authorityId='+data.id;
            //修改权限弹窗
            openDialog('修改权限','550','500',url,currentTable);

        }
    });
});