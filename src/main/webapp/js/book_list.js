$(function () {
    $(".buyImg").click(function () {
        var product_id = $(this).parent().find("#cartinfo_product_id").text();
        var user_id = $(this).parent().find("#cartinfo_user_id").text();
        var cartInfo = $(this).parent().find("#cartinfo");
        if(user_id == ""){
            location="/user/login_form.jsp";
        }else {
            $.post(
                "/cart/addProduct.elect",
                {"product_id": product_id, "user_id": user_id},
                function (data) {
                    if(data==true){
                        cartInfo.text("添加成功");
                    }else {
                        cartInfo.text("该商品已经添加过了");
                    }
                    setTimeout(function () {
                        cartInfo.text("");
                    },3000);
                },"json"
            )
        }
    })

    /*$("#cartinfo").bind("DOMNodeInserted",function () {
        alert(11111);
        var cartInfo = $(this);
        setTimeout(function () {
            cartInfo.text("");
        },1000);
    })*/
})