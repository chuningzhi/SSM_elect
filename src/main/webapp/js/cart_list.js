$(function () {
    $(".changeNum").click(function () {
        var inputVal =  $(this).prev().val();
        if(inputVal != ""){
            var numTd = $(this).parent().prev().find("span").text(inputVal);
            var cart_id = $(this).parent().parent().find("#cart_id").text();
            $.post(
                "changeNum.elect",
                {"cart_id":cart_id,"inputNum":inputVal},
                function (data) {
                    $("#total_economy").text(data.economyPrice);
                    $("#total_account").text(data.totalPrice);
                },
                "json"
            )
        }
    })


    var flag = $(".lengthFlag");
    if(flag.length == 0){
        $("#balance").hide();
    }
})