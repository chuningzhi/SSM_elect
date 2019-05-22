$(function () {
    $("#address").change(function () {
        var index = $(this).val();
        var receiveNameEle = $("#receiveName");
        var fullAddressEle = $("#fullAddress");
        var postalCodeEle = $("#postalCode");
        var phoneEle = $("#phone");
        var mobileEle = $("#mobile");
        var flagAddress = $("#flagAddress");
        if (index < 0) {
            receiveNameEle.val("");
            fullAddressEle.val("");
            postalCodeEle.val("");
            phoneEle.val("");
            mobileEle.val("");
            flagAddress.val("0");
        }else {
            $.post(
                "gainAddress.elect",
                "index=" + index,
                function (data) {
                    receiveNameEle.val(data.receive_name);
                    console.log(data);
                    fullAddressEle.val(data.full_address);
                    postalCodeEle.val(data.postal_code);
                    phoneEle.val(data.phone);
                    mobileEle.val(data.mobile);
                    flagAddress.val("1");
                },
                "json"
            )
        }
    })

    
    $("#receiveName").blur(receiveNameCheck)
    
    $("#receiveName").focus(function () {
        $("#nameValidMsg").html("<p>请填写有效的收件人姓名</p>");
    })

    $("#fullAddress").blur(receiveAddressCheck)

    $("#fullAddress").focus(function () {
        $("#addressValidMsg").html("<p>请填写有效的收件人的详细地址</p>");
    })

    $("#postalCode").blur(receiveCodeCheck)

    $("#postalCode").focus(function () {
        $("#codeValidMsg").html("<p>请填写有效的收件人的邮政编码</p>");
    })

    $("#phone").blur(receivePhoneCheck)

    $("#phone").focus(function () {
        $("#phoneValidMsg").html("<p>请填写有效的收件人的电话</p>");
    })

    $("#mobile").blur(receiveMobileCheck)

    $("#mobile").focus(function () {
        $("#mobileValidMsg").html("<p>请填写有效的收件人的电话</p>");
    })

    $("#f").submit(function () {
        return receiveNameCheck()&&receiveAddressCheck()&&receiveCodeCheck()&&receivePhoneCheck()&&receiveMobileCheck();
    })

})



function receiveNameCheck() {
    var receiveNameVal = $("#receiveName").val();
    if(receiveNameVal == "" || receiveNameVal == null){
        $("#nameValidMsg").html("<font style='color: red'>收件人姓名不能为空！</font>");
        return false;
    }
    return true;
}

function receiveAddressCheck() {
    var receiveNameVal = $("#fullAddress").val();
    if(receiveNameVal == "" || receiveNameVal == null){
        $("#addressValidMsg").html("<font style='color: red'>地址不能为空</font>");
        return false;
    }
    return true;
}

function receiveCodeCheck() {
    var receiveNameVal = $("#postalCode").val();
    if(receiveNameVal == "" || receiveNameVal == null){
        $("#codeValidMsg").html("<font style='color: red'>邮政编码不能为空</font>");
        return false;
    }
    return true;
}

function receivePhoneCheck() {
    var receiveNameVal = $("#phone").val();
    if(receiveNameVal == "" || receiveNameVal == null){
        $("#phoneValidMsg").html("<font style='color: red'>电话不能为空</font>");
        return false;
    }
    return true;
}

function receiveMobileCheck() {
    var receiveNameVal = $("#mobile").val();
    if(receiveNameVal == "" || receiveNameVal == null){
        $("#mobileValidMsg").html("<font style='color: red'>手机号码不能为空</font>");
        return false;
    }else if(receiveNameVal.length != 11){
        $("#mobileValidMsg").html("<font style='color: red'>请填写正确的手机号码</font>");
        return false;
    }
    return true;
}