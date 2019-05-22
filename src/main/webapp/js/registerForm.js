$(function () {
    $("#txtEmail").blur(function () {
        emailCheck();
    });

    $("#txtEmail").focus(function () {
        $("#email_info").text("");
    });

    $("#txtNickName").blur(nickNameCheck);

    $("#txtNickName").focus(function () {
        $("#name_info").text("");
    });

    $("#txtPassword").blur(passwordCheck);

    $("#txtPassword").focus(function () {
        $("#password_info").text("");
    });

    $("#txtRepeatPass").blur(rePasswordCheck);

    $("#txtPassword").focus(function () {
        $("#password1_info").text("");
    });

    $("#txtVerifyCode").blur(function () {
        var flag = codeCheck();
        console.log(flag);
    });

    $("#txtVerifyCode").focus(function () {
        $("#number_info").text("");
    });

    $.ajaxSetup({
        async: false
    });
});

function checkSubmit() {
    return nickNameCheck()&&passwordCheck()&&rePasswordCheck()&&codeCheck()&&emailCheck();
}


function codeCheck() {
    var code = $("#txtVerifyCode").val();
    if(code == "" || code == null){
        $("#number_info").text("验证码不能为空！");
        return false;
    }
    if (code.length != 4){
        $("#number_info").text("请输入正确的验证码！");
        return false;
    }
    var flag = false;
    $.post(
        "/user/CodeCheck.elect",
        "code="+code,
        function (data) {
            var str = data;
            if (str == "true"){
                $("#number_info").html("<font style='color: green' >你输入的验证码正确</font>");
                flag = true;
            }else {
                $("#number_info").text("请输入正确的验证码！");
                flag = false;
            }
        },"text"
    )
    return flag;
}

function rePasswordCheck() {
    var rePassword = $("#txtRepeatPass").val();
    var password = $("#txtPassword").val();
    if(rePassword == password){
        $("#password1_info").html("<font style='color: green' >两次密码输入相同</font>");
        return true;
    }
    $("#password1_info").text("两次密码输入不相同");
    return false;
}

function passwordCheck(){
    var password = $("#txtPassword").val();
    if(password == "" || password ==null){
        $("#password_info").text("密码必须填写！");
        return false;
    }
    var pattern = new RegExp("[a-zA-Z0-9\u4e00-\u9fa5]+");
    if(!pattern.test(password)){
        $("#password_info").text("昵称只可以由小写英文字母、数字组成！");
        return false;
    }
    if(password.length < 4 || password.length > 20){
        $("#password_info").text("密码长度必须在6－20个字符");
        return false;
    }
    $("#password_info").html("<font style='color: green' >你输入的密码符合规则</font>");
    return true;
}


function nickNameCheck() {
    var nickName = $("#txtNickName").val();
    var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？%+_]");
    if(nickName == "" || nickName ==null){
        $("#name_info").text("昵称必须填写！");
        return false;
    }
    if(pattern.test(nickName)){
        $("#name_info").text("昵称只可以由小写英文字母、中文、数字组成！");
        return false;
    }
    if(nickName.length < 4 || nickName.length > 20){
        $("#name_info").text("昵称长度必须在4－20个字符，一个汉字为两个字符！");
        return false;
    }
    $("#name_info").html("<font style='color: green' >你输入的昵称符合规则</font>");
    return true;
}

function emailCheck() {

    var email = $("#txtEmail").val().trim();
    if(email==""||email==null){
        $("#email_info").text("邮箱不能为空！");
        return false;
    }
    var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    if(!reg.test(email)) {
        $("#email_info").text("邮箱的格式不正确，请检查后再输入！");
        return false;
    }
    var flag = false;
    $.post(
        "/user/emailCheck.elect",
        "email="+email,
        function (data) {
            if(data == "true"){
                $("#email_info").text("邮箱已经存在，请跳转至登陆界面登录");
                flag = false;
            }else {
                $("#email_info").html("<font style='color: green'>你输入的邮箱可以使用</font>");
                flag = true;
            }
        },
        "text"
    );
    return flag;
}