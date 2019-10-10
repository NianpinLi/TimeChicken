layui.use(['form'], function () {
    var form = layui.form
        , $ = layui.jquery;

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
});