layui.use(['tree','form'], function () {
    var $ = layui.jquery;
    // var tree = layui.tree;
    var form = layui.form;

    var xTree = null;

    //获取权限树
    $.get(
        "/admin/getRoleTree",
        {"admin":$("#adminId").val()},
        function (obj) {
            // responseObj(obj);
            var data = obj['data'];
            xTree = new layuiXtree({
                elem:"tree"
                , form: form
                , data:data
                , ckall: true
                , isopen: false
            });
        },
        "JSON"
    );

    //监听提交
    form.on('submit(submit)', function (data) {
        var field = data.field;
        var checkedNode = xTree.GetAllCheckBox();
        var checkedValue = "";
        for(var i in checkedNode){
            checkedValue += ","+checkedNode[i].value;
        }
        field['roleIds']=checkedValue;
        $.post(
            "/admin/saveEmpowermentRole",
            field,
            function(obj){
                //回调函数
                responseObj(obj);
            },
            "JSON"
        );
        return false;
    });
});