layui.use(['form','tableSelect'], function () {
    var $ = layui.jquery;
    var form = layui.form
        , tableSelect = layui.tableSelect;

    var i = 0;

    //监听提交
    form.on('submit(submit)', function (data) {
        console.log(data.field);
        $.post(
            "/workOrder/saveType",
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
        var j = i;
        tableSelect.render({
            elem: '#name_'+i,	//定义输入框input对象 必填
            checkedKey: 'roleId', //表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'likeRoleName',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '权限名称搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数
                url:'/role/getRolePageList',
                cols: [
                    [
                        { type: 'checkbox' },
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
                $("#id_"+j).val(idJson.join(","));
            }
        });
        i++;
    };

    initRole();

    // 监听添加流程
    $("#addProcedure").on("click",function () {
        var html = $("#procedure").html();
        $("#content").append('<div class="layui-form-item">'+html+'</div>');
        $("[name='procedureRole']").last().attr("id","name_"+i);
        $("[name='procedureRoleId']").last().attr("id","id_"+i);
        initRole();
        return false;
    });

    // 监听删除流程
    $("#deleteProcedure").on("click",function () {
        if(i > 1){
            $(".content").last().remove();
            i--;
        }
        return false;
    });

});

