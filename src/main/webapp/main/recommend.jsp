<%@ page import="java.util.Date" %>
<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<c:forEach items="${recommendProducts}" var="product" >
			<div class=second_c_02_b1>
				<div class=second_c_02_b1_1>
					<a href='goBookDetail.elect?book_id=${product.book.id}' target='_blank'><img src="../productImages/${product.product_pic}" width=70 border=0 /> </a>
				</div>
				<div class=second_c_02_b1_2>
					<h3>
						<a href='goBookDetail.elect?book_id=${product.book.id}' target='_blank'>${product.product_name}</a>
					</h3>
					<h4>
						作者：${product.book.author} 著
						<br />
						出版社：${product.book.publishing}&nbsp;&nbsp;&nbsp;&nbsp;出版时间：
						<fmt:formatDate value="${Date(product.book.publish_time)}" pattern="yyyy年MM月dd日"></fmt:formatDate>
					</h4>
					<h5>
						${product.book.author_summary}
					</h5>
					<h6>
						定价：￥${product.fixed_price}&nbsp;&nbsp;当当价：￥${product.dang_price}
					</h6>
					<div class=line_xx></div>
				</div>
			</div>
		</c:forEach>

	</div>
</div>
