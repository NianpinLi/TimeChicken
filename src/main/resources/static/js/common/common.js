//请求返回
function responseObj(obj){
    //返回码
    var code = obj.code;
    //提示信息
    var msg = obj.msg;
    //是否关闭页面
    var close = obj.close;

    var icon = 1;
    if(code != 0){
        icon = 2;
    }

    if (msg == ''){
        switch (code){
            case 0 : msg = '操作成功';break;
            case 1 : msg = '操作失败';break;
            case 2 : msg = '参数异常';break;
            case 3 : msg = '系统异常';break;
            case 4 : msg = '权限异常';break;
        }
    }
    layer.alert(msg, {
        icon: icon,
        shade: [0],
        time: 1000,
        skin: 'layer-ext-moon',
        end: function () {
            if (close){
                //关闭
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }else{
                //刷新
                location.reload();
            }
        }
    })
}