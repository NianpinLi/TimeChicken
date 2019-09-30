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
            }
        }
    })
}

//初始化图标选择器 item(选择器)
function initIcon(item,iconPickerFa){
    iconPickerFa.render({
        // 选择器，推荐使用input
        elem: item,
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
            // console.log(data);
        },
        // 渲染成功后的回调
        success: function (d) {
            // console.log(d);
        }
    });
}

//获取列表复选选中Id
function getTableCheckBox(table,tableId,rowId){
    var checkData = table.checkStatus(tableId).data;
    var ids = "";
    for(var i in checkData){
        if (i > 0){
            ids+=",";
        }
        ids += checkData[i][rowId];
    }
    if (ids == ""){
        layer.alert('请选择数据', {
            icon: 2,
            skin: 'layer-ext-moon'
        })
    }
    return ids;
}