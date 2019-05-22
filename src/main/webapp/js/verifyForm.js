$.ajaxSetup({
    async: false
});

$(function () {
    $("#validatecode").blur(emailVCodeCheck);

    $("#verifyForm").submit(function () {
        return emailVCodeCheck();
    })
});

/*function verifyForm() {
    console.log(emailVCodeCheck());
    return emailVCodeCheck();
}*/

function emailVCodeCheck() {
    var code = $("#validatecode").val();
    var flag = false;
    $.post(
        "emailVCodeCheck.elect",
        "emailVCode="+code,
        function (data) {
            if(data == "false"){
                $("#errorMsg").text("验证码输入错误！请重新输入！");
                flag = false;
            }else{
                $("#errorMsg").text("正确，请点击提交！");
                flag = true;
            }
        },"text"
    )
    return flag;


}

