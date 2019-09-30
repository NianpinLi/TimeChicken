layui.use(['form', 'iconPickerFa', 'tableSelect'], function () {
    var form = layui.form
        , $ = layui.jquery;

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