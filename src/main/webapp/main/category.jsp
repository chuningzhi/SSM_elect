<%@page contentType="text/html;charset=utf-8"%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>

		<%--一级标题--%>
		<c:forEach items="${category.categories}" var="category1">
		<!--1级分类开始-->
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='goCategory.elect?id=${category1.id}&parent_id=${category1.parent_id}&page=1'>${category1.name}</a>]
				</h3>
				<ul class="ul_left_list">
				<c:forEach items="${category1.categories}" var="category2">
						<!--2级分类开始-->
						<li>
							<a href='goCategory.elect?id=${category2.id}&parent_id=${category2.parent_id}&page=1'>${category2.name}</a>
						</li>
						<%--2级分类结束--%>
				</c:forEach>
				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
		</c:forEach>
			<!--1级分类结束-->



		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
