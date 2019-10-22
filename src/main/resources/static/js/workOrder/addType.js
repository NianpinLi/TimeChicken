layui.use(['form','tableSelect'], function () {
    var $ = layui.jquery;
    var form = layui.form
        , tableSelect = layui.tableSelect;

    var i = 0;

    //监听提交
    form.on('submit(submit)', function (data) {
        $.post(
            "/admin/saveAdmin",
            data.field,
            function(obj){
                //回调函数
                responseObj(obj);
            },
            "JSON"
        );
        return false;
    });

    //初始化
    var initRole = function(){
        tableSelect.render({
            elem: '[name="roleId"]',	//定义输入框input对象 必填
            checkedKey: 'authorityId', //表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'likeRoleName',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '权限名称搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数
                url:'/authority/getAuthorityPageList',
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
                var newJson = [];
                var idJson = [];

                layui.each(data.data, function (index, item) {
                    newJson.push(item.authorityName);
                    idJson.push(item.authorityId);
                });
                elem.val(newJson.join(","));
                $("#parentAuthorityId").val(idJson.join(","));
            }
        });
    };
    initRole();
    // 监听添加流程
    $("#addProcedure").on("click",function () {
        var html = $("#procedure").html();
        console.log(html);
        $("#content").append('<div class="layui-form-item">'+html+'</div>');
        initRole();
        return false;
    });

});

