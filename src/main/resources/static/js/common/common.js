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

layui.use(['laydate','form'], function () {
    var laydate = layui.laydate;
    var form = layui.form;

    //自定义验证规则
    form.verify({
        lengthEight:[
            /^[\S]{0,8}$/
            , '长度限制8'
        ]
        ,lengthFifty:[
            /^[\S]{0,50}$/
            , '长度限制50'
        ]
        ,lengthTwoHundredAndFiftyFive:[
            /^[\S]{0,255}$/
            , '长度限制255'
        ]
    });

    //监听指定开关
    form.on('switch(switchFilter)', function(data){
        if(this.checked == true){
            $(this).val(1);
        }else{
            $(this).val(0);
        }
    });
    //初始化日期 年
    lay('.layui-year').each(function(){
        laydate.render({
            elem: this
            ,type: 'year'
            ,trigger: 'click'
        });
    });
    //初始化日期 年月
    lay('.layui-month').each(function(){
        laydate.render({
            elem: this
            ,type: 'month'
            ,trigger: 'click'
        });
    });
    //初始化日期 年月日
    lay('.layui-date').each(function(){
        laydate.render({
            elem: this
            ,type: 'date'
            ,trigger: 'click'
        });
    });
    //初始化日期 时分秒
    lay('.layui-time').each(function(){
        laydate.render({
            elem: this
            ,type: 'time'
            ,trigger: 'click'
        });
    });
    //初始化日期 年月日时分秒
    lay('.layui-datetime').each(function(){
        laydate.render({
            elem: this
            ,type: 'datetime'
            ,trigger: 'click'
        });
    });
    //初始化时间段 时分秒
    lay('.layui-range-time').each(function(){
        laydate.render({
            elem: this
            ,type: 'time'
            ,range: true
            ,trigger: 'click'
        });
    });
});
//弹出页面
function openDialog(title,width,length,url,callback) {
    layer.open({
        type: 2,
        title: title,
        shadeClose: true,
        fixed: false, //不固定
        maxmin: true, //开启最大化最小化按钮
        shade: 0,
        area: [width+'px', length+'px'],
        content: [url ,'yes'],
        end: function () {//无论是确认还是取消，只要层被销毁了，end都会执行，不携带任何参数。layer.open关闭事件
            callback();　//layer.open关闭刷新
        }
    });
}
//弹出确认
function openConfirm(confirm, callback) {
    layer.confirm(confirm, {
        btn: ['确认','取消'] //按钮
    }, callback);
}
//选择开关赋值
function switchReplace(data, fields, on, close){
    var value = data.field[fields];
    if ('on' == value){
        data.field[fields] = on;
    }else{
        data.field[fields] = close;
    }
}