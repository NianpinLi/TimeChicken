//切换注册
$(".register-link").on("click",function(){
    $("#loginBox").hide("slow");
    $("#registerBox").show("slow");
});
//切换登录
$(".login-link").on("click",function(){
    $("#registerBox").hide("slow");
    $("#loginBox").show("slow");

});
//切换忘记密码
$(".forgot-link").on("click",function(){
    $("#submitButton").text("找回");
    $("#loginTitleBox").text("找回密码");
    $("#passwordBox").hide();
    $("#showLoginButton").show();
    $("#login").action("/admin/forgetPassword");
});
//返回登录
$(".login-back-link").on("click",function(){
    $("#submitButton").text("登录");
    $("#loginTitleBox").text("登录");
    $("#passwordBox").show();
    $("#showLoginButton").hide();
    $("#login").action("/admin/login");
});

