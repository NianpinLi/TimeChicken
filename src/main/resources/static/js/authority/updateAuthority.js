layui.use(['form', 'iconPickerFa', 'tableSelect'], function () {
    var form = layui.form
        , iconPickerFa = layui.iconPickerFa
        , $ = layui.jquery;

    //监听提交
    form.on('submit(submit)', function (data) {
        $.post(
            "/authority/saveAuthority",
            data.field,
            function(obj){
                //回调函数
                responseObj(obj);
            },
            "JSON"
        );
        return false;
    });

    //图标初始化
    initIcon('#iconPicker',iconPickerFa);


});