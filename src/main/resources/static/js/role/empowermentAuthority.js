layui.use(['tree','form'], function () {
    var $ = layui.jquery;
    var tree = layui.tree;
    var form = layui.form;


    //获取权限树
    $.post(
        "/role/getRoleAuthorityTree",
        {"roleId":$("#roleId").val()},
        function (obj) {
            // responseObj(obj);
            var data = obj['data'];
            new layuiXtree({
                elem:"tree"
                , form: form
                , data:data
                , ckall: true
            });
        },
        "JSON"
    );
});