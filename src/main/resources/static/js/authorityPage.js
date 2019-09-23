layui.use(['table', 'treetable'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var treeTable = layui.treetable;

    // 渲染表格
    layer.load(2);
    treeTable.render({
        treeColIndex: 1,
        treeSpid: -1,
        treeIdName: 'authorityId',
        treePidName: 'parentAuthorityId',
        elem: '#menu-table',
        url: '/authority/authorityList',
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

    $('#btn-expand').click(function () {
        treeTable.expandAll('#menu-table');
    });

    $('#btn-fold').click(function () {
        treeTable.foldAll('#menu-table');
    });
    $('#btn-add').click(function () {
        //新增权限弹窗
        layer.open({
            type: 2,
            title: '新增权限',
            shadeClose: true,
            shade: 0,
            area: ['550px', '550px'],
            content: ['/authority/addAuthorityPage','no']
        });
    });

    //监听工具条
    table.on('tool(menu-table)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'del') {
            layer.msg('删除' + data.id);
        } else if (layEvent === 'edit') {
            layer.msg('修改' + data.id);
        }
    });
});