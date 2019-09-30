layui.use(['table', 'treetable','form'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var treeTable = layui.treetable;
    var form = layui.form;

    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        var result = data.field;
        //执行搜索重载
        // 渲染表格
        layer.load(2);
        treeTable.render({
            treeColIndex: 1,//树形图标显示在第几列
            treeSpid: -1,//最上级的父级id
            treeDefaultClose: false,//是否默认折叠
            treeLinkage: true,//父级展开时是否自动展开所有子级
            treeIdName: 'authorityId',//id字段的名称
            treePidName: 'parentAuthorityId',//pid字段的名称
            where:result,//查询条件
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
        layer.open({
            type: 2,
            title: '新增权限',
            shadeClose: true,
            shade: 0,
            area: ['550px', '550px'],
            content: ['/authority/addAuthorityPage','no'],
            end: function () {//无论是确认还是取消，只要层被销毁了，end都会执行，不携带任何参数。layer.open关闭事件
                window.location.reload();　　//layer.open关闭刷新
            }
        });
    });

    //监听工具条
    table.on('tool(menu-table)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;
        if (layEvent === 'del') {
            layer.confirm('确认删除当前权限吗？',{
                btn: ['确认','取消'] //按钮
            }, function(){
                //删除权限
                $.post(
                    "/authority/deleteAuthority",
                    {"equalToAuthorityId":data.id},
                    function (obj) {
                        responseObj(obj);
                        window.location.reload();
                    },
                    "JSON"
                );
            });
        } else if (layEvent === 'edit') {
            var url = '/authority/updateAuthorityPage?authorityId='+data.id;
            //新增权限弹窗
            layer.open({
                type: 2,
                title: '修改权限',
                shadeClose: true,
                shade: 0,
                area: ['550px', '550px'],
                content: [url ,'no'],
                end: function () {//无论是确认还是取消，只要层被销毁了，end都会执行，不携带任何参数。layer.open关闭事件
                    window.location.reload();　　//layer.open关闭刷新
                }
            });

        }
    });
});