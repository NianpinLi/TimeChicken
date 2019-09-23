layui.use(['form', 'iconPickerFa', 'tableSelect'], function () {
    var form = layui.form
        , iconPickerFa = layui.iconPickerFa
        , tableSelect = layui.tableSelect
        , $ = layui.jquery;

    //监听提交
    form.on('submit(submit)', function (data) {
        // var data = JSON.stringify(data.field);
        // layer.alert(, {
        //     title: '最终的提交信息'
        // });
        $.post(
            "/authority/saveAuthority",
            data.field,
            function(obj){
                //回调函数
                responeObj(obj);
            },
            "JSON"
        );
        return false;
    });

    //图标选择模块初始化
    iconPickerFa.render({
        // 选择器，推荐使用input
        elem: '#iconPicker',
        // fa 图标接口
        url: "/layui/lib/font-awesome-4.7.0/less/variables.less",
        // 是否开启搜索：true/false，默认true
        search: true,
        // 是否开启分页：true/false，默认true
        page: true,
        // 每页显示数量，默认12
        limit: 12,
        // 点击回调
        click: function (data) {
            console.log(data);
        },
        // 渲染成功后的回调
        success: function (d) {
            console.log(d);
        }
    });
    //上次权限菜单下拉选择模块初始化
    tableSelect.render({
        elem: '#parentAuthorityName',	//定义输入框input对象 必填
        checkedKey: 'authorityId', //表格的唯一建值，非常重要，影响到选中状态 必填
        searchKey: 'likeAuthorityName',	//搜索输入框的name值 默认keyword
        searchPlaceholder: '权限名称搜索',	//搜索输入框的提示文字 默认关键词搜索
        table: {	//定义表格参数
            url:'authorityPageList',
            cols: [
                [
                    { type: 'radio' },
                    {field: 'authorityId', title: '权限ID'},
                    {field: 'authorityName', title: '权限名称'}
                ]
            ]
        },
        done: function (elem, data) {
            //选择完后的回调，包含2个返回值 elem:返回之前input对象；data:表格返回的选中的数据 []
            //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
            var newJson = []
            var idJson = []

            layui.each(data.data, function (index, item) {
                newJson.push(item.authorityName)
                idJson.push(item.authorityId)
            })
            elem.val(newJson.join(","))
            $("#parentAuthorityId").val(idJson.join(","))
        }
    })

});