<%@ page import="java.util.Date" %>
<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="../js/book_list.js" ></script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='goMain.elect'>当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong>${category1.name}</strong> </font>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
                                        <c:if test="${cate_id == category1.id}"><strong></c:if>
                                            <a href="goCategory.elect?id=${category1.id}&parent_id=${category1.parent_id}&page=1">&middot;全部&nbsp(${category1.categoryProducts.size()})</a>
                                        <c:if test="${cate_id == category1.id}"></strong></c:if>
									</div>
								</div>
							</li>
							<div class="clear"></div>
							<c:forEach items="${category1.categories}" var="category2">
								<!--2级分类开始-->
								<li>
									<div>
										<c:if test="${cate_id == category2.id}"><strong></c:if>
										<div class=second_fenlei>
											&middot;
										</div>
										<div class=second_fenlei>
											    <a href="goCategory.elect?id=${category2.id}&parent_id=${category2.parent_id}&page=1">${category2.name}&nbsp;(${category2.categoryProducts.size()})</a>
										</div>
										<c:if test="${cate_id == category2.id}"></strong></c:if>
									</div>
								</li>
								<div class="clear"></div>
							</c:forEach>

							<div class="clear"></div>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<c:if test="${page != 1}">
                                <div class='list_r_title_text3a'>
                                    <a name=link_page_next
                                        href="goCategory.elect?id=${cate_id}&parent_id=${parent_id}&page=${page-1}">
                                    <img src='../images/page_up.gif' /> </a>
                                </div>
                            </c:if>
	                        
                            <c:if test="${page == 1 || page < 1}">
                                <div class='list_r_title_text3a' id="">
                                    <img src='../images/page_up_gray.gif' />
                                </div>
                            </c:if>
				
							<div class='list_r_title_text3b' id="buttons_list_r">
								第${page}页/共${totalPage} 页
							</div>

                            <c:if test="${page != totalPage}">
                                <div class='list_r_title_text3a'>
                                    <a name=link_page_next
                                        href="goCategory.elect?id=${cate_id}&parent_id=${parent_id}&page=${page+1}">
                                        <img src='../images/page_down.gif' /> </a>
                                </div>
                            </c:if>

                            <c:if test="${page == totalPage || page >totalPage}">
							    <div class='list_r_title_text3a'>
							    	<img src='../images/page_down_gray.gif' />
							    </div>
                            </c:if>

							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
					<c:forEach items="${products}" var="product">
						<div class="list_r_line"></div>
						<div class="clear"></div>

						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='goBookDetail.elect?book_id=${product.book.id}'>
								<img src="../productImages/${product.product_pic}" /> </a> </span>
							<h2>
								<a name="link_prd_name" href='goBookDetail.elect?book_id=${product.book.id}'>${product.product_name}</a>
							</h2>
							<h3>
								顾客评分：${product.book.total_page}
							</h3>
							<h4 class="list_r_list_h4">
								作 者:
								<a href='#' name='作者'>${product.book.author}</a>
							</h4>
							<h4>
								出版社：
								<a href='#' name='出版社'>${product.book.publishing}</a>
							</h4>
							<h4>
								出版时间：
								<fmt:formatDate value="${Date(product.book.publish_time)}" pattern="yyyy年MM月dd日"></fmt:formatDate>
							</h4>
							<h5>
									${product.book.catalogue}
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥${product.fixed_price}</span>
								<span class="red">￥${product.dang_price}</span>
								节省：￥${product.fixed_price - product.dang_price}
							</h6>
							<span class="list_r_list_button"> 
								<img src='../images/buttom_goumai.gif' class="buyImg"/>
								<span id="cartinfo" style="color: red"></span>
								<span id="cartinfo_product_id" style="display: none">${product.id}</span>
								<span id="cartinfo_user_id" style="display: none">${user.id}</span>
							</span>
						</div>
						<div class="clear"></div>
					</c:forEach>
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
