$(function () {
    $(".parentCategory").toggle(function () {
        var trEle = $(this).parent();
        var id = $(this).parent().find("#cid").val();
        $.ajax({
            type:'get',
            url:'findCategoryById.elect?id='+id,
            dateType:'json',
            success:function (data) {
                var list =$.parseJSON(data);
                $.each(list,function (index,subCat) {
                    var cEle = "<tr bordercolor=\"rgb(78,78,78)\"  class=\"parentCategory"+id+"\">" +
                        "<td class=\"text-center parentCategory\" style='background-color: #f5e79e'>" +
                        "<a href=\"javascript:;\" >"+subCat.name+" </a>" +
                        "</td>" +
                        "<input type=\"hidden\" id=\"cid\" value=\""+subCat.id+"\"/>" +
                        "<div id=\"light\" class=\"white_content\">" +
                        "</div>" +
                        "<td><a class=\"btn btn-group-lg btn-warning\"" +
                        "href=\"/admin/AdminEditCategory.elect?cid="+subCat.id+"\">修改</a>" +
                        "<a class=\"btn  btn-group-lg btn-danger\"" +
                        "href=\"/admin/AdminDeleteCategory.elect?cid="+subCat.id+ "\">删除</a>" +
                        "</td>" +
                        "</tr>";
                    trEle.after(cEle);
                })
            },

        });
    },
    function () {
        var id = $(this).parent().find("#cid").val();
        $(".parentCategory"+id).hide();
    })

})