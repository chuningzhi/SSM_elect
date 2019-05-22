<%@ page import="java.util.Date" %>
<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(function () {
			$("#buyImg").click(function () {
				var user_id = $("#user_id").text();
				console.log(user_id)
				var cartInfo = $("#cartinfo");
                console.log(cartInfo)
				var product_id = $("#product_id").text();
				console.log(product_id)
				if(user_id == ""){
					location="user/login_form.jsp";
				}else {
                    $.post(
                        "addProduct",
                        {"product_id": product_id, "user_id": user_id},
                        function (data) {
                            console.log(data);
                            cartInfo.text(data);
                            setTimeout(function () {
                                cartInfo.text("");
                            },3000);
                        },"text"
                    )
				}
			})
		})

	</script>
	</head>
	
	<body>
		&nbsp;
		<span style="display: none" id="user_id">${user.id}</span>
		<span style="display: none" id="product_id">${book.id}</span>
		<!-- 头部开始 -->
		<%@include file="/common/head.jsp"%>
		<!-- 头部结束 -->
		<div style="width: 962px; margin: auto;">
			<a href='${pageContext.request.contextPath}/main/mainAction.main' ><img
					src="${pageContext.request.contextPath}/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">

			</div>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书信息-->
				<div class="second_c_border1" id="recommend">
				<h2>
					图书信息
				</h2>
				<div id="__bianjituijian/danpin">
					<div class="second_c_02">
						<div class="second_c_02_b1">
							<div class="second_c_02_b1_3">
								<img src="${pageContext.request.contextPath}/productImages/${product.product_pic}" width=200 border=1 />
							</div>
							<div class="second_c_02_b1_4" style="margin-left: 42%;margin-top: -50%">
								丛书名称：${product.product_name}
								<div class="line_xx"></div>
							<table cellpadding="4px" cellspacing="4px" width="100%">
								<tr><td>作者：${product.book.author}</td></tr>
								<tr><td>出版社：${product.book.publishing}</td></tr>
								<tr><td>所属类别：${style}</td></tr>
								<tr><td>上架时间：<s:formatDate value="${Date(product.add_time)}" type="date" pattern="yyyy-MM-dd" /></td></tr>
							</table>
							<h6>
								<span class="del">￥${product.fixed_price}</span>
								<span class="red">￥${product.dang_price}</span>
								节省：￥${product.fixed_price-book.product.dang_price}
							</h6>
							<span class="list_r_list_button"> </span>
							<a href="#" >
							<img src='${pageContext.request.contextPath}/images/buttom_goumai.gif' id="buyImg"/> </a>
							<span style="color:red;" id='cartinfo'></span>
							</div>
						</div>
					</div>
				</div>
				</div>

				<!--图书信息-->

				<!--详细信息-->
				<div class="book_c_border2" id="hot">
				<h2>
					详细信息
				</h2>
				<div class="book_c_04">
					<table class="t_xxxx">
						<caption>丛书名称：${product.product_name}</caption>
						<tr><td width="50%">作者：${product.book.author}</td><td>出版社:${product.book.publishing}</td></tr>
						<tr>
							<td>出版时间：<s:formatDate value="${Date(product.book.publish_time)}" type="date" pattern="yyyy-MM-dd" /></td>
							<td>印刷时间：<s:formatDate value="${Date(product.book.print_time)}" type="date" pattern="yyyy-MM-dd" /></td></tr>
						<tr><td>版次：${product.book.which_edtion}</td><td>印次：${product.book.print_number}</td></tr>
						<tr><td>字数：${product.book.word_number}</td><td>页数：${product.book.total_page}</td></tr>
						<tr>
							<td>ISBN：${product.book.isbn}</td>
							<td>上架时间：<s:formatDate value="${Date(product.add_time)}" type="date" pattern="yyyy-MM-dd" /></td></tr>
						<tr></tr>
					</table>
				</div>
				<div class="clear"></div>
				</div>
				<!--详细信息-->

				<!--书籍简介-->
				<div class="book_c_border2" id="new">
					<h2>
						书籍简介
					</h2>
					<table class="t_xxxx">
						<tr>
							<td>
								书籍简介：<p>${product.description}</p>
							</td>
						</tr>
						<tr>
							<td>
								作者简介：<p>${product.book.author_summary}</p>
							</td>
						</tr>
						<tr>
							<td>
								书籍目录：<p>${product.book.catalogue}</p>
							</td>
						</tr>
					</table>
				</div>
				<!--书籍简介-->

				<div class="clear">
				</div>
			</div>
			<!--中栏结束-->



			<!--右栏开始-->
			<div class="book_right">
				<div class="book_r_border2" id="__XinShuReMai">
					<div class="book_r_b2_1x" id="new_bang">
						<h2 class="t_xsrm">
							新书热卖榜
						</h2>
						<div id="NewProduct_1_o_t" onmouseover="">
							<h3 class="second">
								<span class="dot_r"> </span><a href='${pageContext.request.contextPath}/main/mainAction.main' >更多&gt;&gt;</a>
							</h3>
						</div>
					</div>
				</div>
			</div>
			<!--右栏结束-->
			<div class="clear"></div>
		</div>
		<!--页尾开始 -->
		<%@include file="/common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
