<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<title>产品修改页面</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="content-type" content="text/html;charset=utf-8">

		<script src="<c:url value='/js/jquery-1.8.3.min.js'/>" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap-theme.css'/>" />
		<script src="<c:url value='/js/bootstrap.min.js'/>" type="text/javascript" charset="utf-8"></script>
		<script src="<c:url value='/js/application.js'/>" type="text/javascript" charset="utf-8"></script>
				
			
		<script type="text/javascript">
			$(function() {
				$("#sub_ok").click(function() {
					$("form").submit();
				});
				
				$("")
			});
		</script>

		<style type="text/css">
			body {
				font-size: 10pt;
			}
			
			.img_p5 {
				padding-top: 5px;
			}
			
			.mycenter {
				margin-top: 10%;
			}
		</style>
	</head>

	<body>

		<div id="html_top" class="navbar-inverse  navbar-static-top navbar-fixed-top" role="navigation">
			<jsp:include page="/admin/admin/top.jsp"></jsp:include>
		</div>

		<div class="container mycenter">
			<div id="html_left" class="row col-lg-3">
				<jsp:include page="/admin/admin/left.jsp"></jsp:include>
			</div>
			<div id="html_content" class="row col-lg-9 col-lg-offset-0">

				<h2 class="page-header text-center text-primary">图书简介</h2>
				<div class="">
					<form id="form" action="/adminBook/AdminModifyBook.elect" method="post">
					<div class="row">
						<div class="col-lg-2 img_p5">
							<input class="" type="hidden" id="CMethod" name="method" value="" />
						</div>
						<div class="col-lg-2 img_p5">
							<input class="" type="hidden" name="id" value="${requestScope.product.id }" />
						</div>
						<div class="col-lg-2 img_p5" style="height: 180px">
							<a href=""><img src="<c:url value='/productImages/${requestScope.product.product_pic }'/>" style="width: 120px;height: 180px" /></a>
						</div>
						<div class="col-lg-3">
							<p class="nav nav-stacked">
								<div class="form-group">
									<label>书名:</label>
									<input class="form-control"  name="product_name"  value="${requestScope.product.product_name }"/>
								</div>
								<div class="form-group">
									<label>作者：</label>
									<input class="form-control" name="author" value="${requestScope.product.book.author }"/>
								</div>
							</p>
						</div>

						<div class="col-lg-3">
							<p class="nav nav-stacked">
								<div class="form-group">
									<label>单价(元)：</label>
									<input class="form-control"  name="dang_price" value="${requestScope.product.dang_price }"/>
								</div>

								<div class="form-group">
                                    <label for="InputCount">状态:</label>
                                    <input class="form-control" readonly="readonly" id="InputCount" type="text" size="3" name="count" value="" /><%--${book.del}--%>
								</div>
								
								<div class="form-group">
										<input class="form-control"  type="hidden"  name="image" value="${product.product_pic}" />
								</div>
							</p>
						</div>
						
						<div class="col-lg-3">
							<p class="nav nav-stacked">
								<div class="form-group">
									<label class="">分类：</label>
									<select name="cid" class="form-control dropdown" id="cidSelect" style="width: 185px">
										<optgroup>
											<c:forEach items="${categoryList}" var="cate">
												<option value="${cate.id }" <c:if test="${cate.id == yijibiaoti }"> selected="selected" </c:if>>${cate.name }</option>
											</c:forEach>
										</optgroup>
									</select>
									<select name="childcid" class="form-control dropdown" id="childCidSelect" style="left: 215px;top: -33px;width: 185px">
										<optgroup>
											<c:forEach items="${categoryList}" var="cate">
                                                <c:if test="${cate.id == yijibiaoti }">
                                                    <c:forEach items="${cate.categories}" var="childCate">
                                                        <option value="${childCate.id }" <c:if test="${childCate.id == erjibiaoti }"> selected="selected" </c:if>>${childCate.name }</option>
                                                    </c:forEach>
                                                </c:if>
											</c:forEach>
										</optgroup>
									</select>
									<!--<input class="form-control" value="${requestScope.book.id }" readonly="readonly" />-->
								</div>
								<label>操作</label>
								<div>
									<button type="submit" class="btn btn-danger " value="del" onclick="return setMethodDelete();">删除图书</button>
									<button class="btn btn-danger " type="submit" value="mod" onclick="return setMethodUpdate();" />修改图书</button>
								</div>
							</p>
						</div>
                    </div>
                </form>

					</div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
			function setMethodDelete(){
				if(confirm('是否真要删除该图书？')){
					alert("已经确认了");
					document.getElementById("CMethod").value = 'deleteBook';
					//$("#CMethod").text('delete');
					return true;
				}
				else{
					alert("没有确定");
					return false;
				}
			}
			
			function setMethodUpdate(){
				if(confirm('是否真要修改该图书？')){
					alert("已经确认了");
					document.getElementById("CMethod").value = 'updateBook';
					return true;
					//$("#CMethod").text('update');
				}
				else{
					alert("没有确定");
					return false;
				}
			}
			
			$(function () {
                $("#cidSelect").change(function () {
                    var cidVal = $(this).val()
                    $.get(
                        "/admin/AdminCategoryChange.elect?cid="+cidVal,
                        function (data) {
							$("#childCidSelect").find("optgroup").find("option").remove();
                            $.each(data,function (i,category) {
                                var optionEle = "<option value='"+category.id+"'>"+category.name+"</option>"
                                $("#childCidSelect").find("optgroup").append(optionEle);
                            })
                        },"json"
                    )
                })
            })


	</script>
</html>
