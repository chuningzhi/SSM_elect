<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">
	<c:forEach items="${newProducts}" var="product" >
		<!--最新图书A开始-->
		<div class="second_d_wai">
			<div class="img">
				<a href="goBookDetail.elect?book_id=${product.book.id}" target='_blank'><img
						src="../productImages/${product.product_pic}" border=0 /> </a>
			</div>
			<div class="shuming">
				<a href="goBookDetail.elect?book_id=${product.book.id}" target="_blank">${product.product_name}</a><a href="#" target="_blank"></a>
			</div>
			<div class="price">
				定价：￥${product.fixed_price}
			</div>
			<div class="price">
				当当价：￥${product.dang_price}
			</div>
		</div>
		<div class="book_c_xy_long"></div>
		<!--最新图书A开始-->
	</c:forEach>

</div>
<div class="clear"></div>