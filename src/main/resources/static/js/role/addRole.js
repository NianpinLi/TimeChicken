layui.use(['form', 'iconPickerFa', 'tableSelect'], function () {
    var form = layui.form
        , tableSelect = layui.tableSelect
        , $ = layui.jquery;

    //上级权限菜单下拉选择模块初始化
    tableSelect.render({
        elem: '#parentRoleName',	//定义输入框input对象 必填
        checkedKey: 'roleId', //表格的唯一建值，非常重要，影响到选中状态 必填
        searchKey: 'likeRoleName',	//搜索输入框的name值 默认keyword
        searchPlaceholder: '角色名称搜索',	//搜索输入框的提示文字 默认关键词搜索
        table: {	//定义表格参数
            url:'/role/getRolePageList',
            cols: [
                [
                    { type: 'radio' },
                    {field: 'roleId', title: '角色ID'},
                    {field: 'roleName', title: '角色名称'}
                ]
            ]
        },
        done: function (elem, data) {
            //选择完后的回调，包含2个返回值 elem:返回之前input对象；data:表格返回的选中的数据 []
            //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
            var newJson = [];
            var idJson = [];

            layui.each(data.data, function (index, item) {
                newJson.push(item.roleName);
                idJson.push(item.roleId);
            });
            elem.val(newJson.join(","));
            $("#parentRoleId").val(idJson.join(","));
        }
    });

    //监听提交
    form.on('submit(submit)', function (data) {
        $.post(
            "/role/saveRole",
            data.field,
            function(obj){
                //回调函数
                responseObj(obj);
            },
            "JSON"
        );
        return false;
    });
});