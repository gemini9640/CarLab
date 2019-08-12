<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<a class="menu-toggler" id="menu-toggler" href="#">
	<span class="menu-text"></span>
</a>
<div class="sidebar" id="sidebar">
	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
	</script>

	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="icon-signal"></i>
			</button>

			<button class="btn btn-info">
				<i class="icon-pencil"></i>
			</button>

			<button class="btn btn-warning">
				<i class="icon-group"></i>
			</button>

			<button class="btn btn-danger">
				<i class="icon-cogs"></i>
			</button>
		</div>

		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span>

			<span class="btn btn-info"></span>

			<span class="btn btn-warning"></span>

			<span class="btn btn-danger"></span>
		</div>
	</div><!-- #sidebar-shortcuts -->

	<ul class="nav nav-list">
		<li class="left_menu left_menu_dashboard">
			<a href="${base}">
				<i class="icon-dashboard"></i>
				<span class="menu-text"> Dashboard </span>
			</a>
		</li>

		<li>
			<a href="typography.html">
				<i class="icon-text-width"></i>
				<span class="menu-text"> Order </span>
			</a>
		</li>

		<li>
			<a href="#" class="dropdown-toggle">
				<i class="icon-calendar"></i>
				<span class="menu-text"> Calendar </span>

				<b class="arrow icon-angle-down"></b>
			</a>

<!-- 			<ul class="submenu"> -->
<!-- 				<li> -->
<!-- 					<a href="elements.html"> -->
<!-- 						<i class="icon-double-angle-right"></i> -->
<!-- 						组件 -->
<!-- 					</a> -->
<!-- 				</li> -->

<!-- 				<li> -->
<!-- 					<a href="buttons.html"> -->
<!-- 						<i class="icon-double-angle-right"></i> -->
<!-- 						按钮 &amp; 图表 -->
<!-- 					</a> -->
<!-- 				</li> -->

<!-- 				<li> -->
<!-- 					<a href="treeview.html"> -->
<!-- 						<i class="icon-double-angle-right"></i> -->
<!-- 						树菜单 -->
<!-- 					</a> -->
<!-- 				</li> -->

<!-- 				<li> -->
<!-- 					<a href="jquery-ui.html"> -->
<!-- 						<i class="icon-double-angle-right"></i> -->
<!-- 						jQuery UI -->
<!-- 					</a> -->
<!-- 				</li> -->

<!-- 				<li> -->
<!-- 					<a href="nestable-list.html"> -->
<!-- 						<i class="icon-double-angle-right"></i> -->
<!-- 						可拖拽列表 -->
<!-- 					</a> -->
<!-- 				</li> -->

<!-- 				<li> -->
<!-- 					<a href="#" class="dropdown-toggle"> -->
<!-- 						<i class="icon-double-angle-right"></i> -->

<!-- 						三级菜单 -->
<!-- 						<b class="arrow icon-angle-down"></b> -->
<!-- 					</a> -->

<!-- 					<ul class="submenu"> -->
<!-- 						<li> -->
<!-- 							<a href="#"> -->
<!-- 								<i class="icon-leaf"></i> -->
<!-- 								第一级 -->
<!-- 							</a> -->
<!-- 						</li> -->

<!-- 						<li> -->
<!-- 							<a href="#" class="dropdown-toggle"> -->
<!-- 								<i class="icon-pencil"></i> -->

<!-- 								第四级 -->
<!-- 								<b class="arrow icon-angle-down"></b> -->
<!-- 							</a> -->

<!-- 							<ul class="submenu"> -->
<!-- 								<li> -->
<!-- 									<a href="#"> -->
<!-- 										<i class="icon-plus"></i> -->
<!-- 										添加产品 -->
<!-- 									</a> -->
<!-- 								</li> -->

<!-- 								<li> -->
<!-- 									<a href="#"> -->
<!-- 										<i class="icon-eye-open"></i> -->
<!-- 										查看商品 -->
<!-- 									</a> -->
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
<!-- 			</ul> -->
		</li>

		<li class="left_menu left_menu_catelog">
			<a href="#" class="dropdown-toggle">
				<i class="icon-list"></i>
				<span class="menu-text"> Cetalog </span>

				<b class="arrow icon-angle-down"></b>
			</a>

			<ul class="submenu">
				<li class="submenu_catelog submenu_catelog_product_add">
					<a href="${base}home/catelog/product_add.htm">
						<i class="icon-double-angle-right"></i>
						Add Product
					</a>
				</li>
				<li class="submenu_catelog submenu_catelog_product">
					<a href="${base}home/catelog/product_list.htm">
						<i class="icon-double-angle-right"></i>
						Products
					</a>
				</li>
				<li class="submenu_catelog submenu_catelog_category_add">
					<a href="${base}home/catelog/category_add.htm">
						<i class="icon-double-angle-right"></i>
						Add Categories
					</a>
				</li>
				<li class="submenu_catelog submenu_catelog_category">
					<a href="${base}home/catelog/category_list.htm">
						<i class="icon-double-angle-right"></i>
						Categories
					</a>
				</li>
			</ul>
		</li>

		<li>
			<a href="#" class="dropdown-toggle">
				<i class="icon-group"></i>
				<span class="menu-text"> Customers </span>

				<b class="arrow icon-angle-down"></b>
			</a>

<!-- 			<ul class="submenu"> -->
<!-- 				<li> -->
<!-- 					<a href="form-elements.html"> -->
<!-- 						<i class="icon-double-angle-right"></i> -->
<!-- 						表单组件 -->
<!-- 					</a> -->
<!-- 				</li> -->

<!-- 				<li> -->
<!-- 					<a href="form-wizard.html"> -->
<!-- 						<i class="icon-double-angle-right"></i> -->
<!-- 						向导提示 &amp; 验证 -->
<!-- 					</a> -->
<!-- 				</li> -->

<!-- 				<li> -->
<!-- 					<a href="wysiwyg.html"> -->
<!-- 						<i class="icon-double-angle-right"></i> -->
<!-- 						编辑器 -->
<!-- 					</a> -->
<!-- 				</li> -->

<!-- 				<li> -->
<!-- 					<a href="dropzone.html"> -->
<!-- 						<i class="icon-double-angle-right"></i> -->
<!-- 						文件上传 -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 			</ul> -->
		</li>

		<li class="left_menu left_menu_user">
			<a href="#" class="dropdown-toggle">
				<i class="icon-user"></i>
				<span class="menu-text"> User </span>
				
				<b class="arrow icon-angle-down"></b>
			</a>
			
			<ul class="submenu">
				<li class="submenu_user submenu_user_staff">
					<a href="${base}home/user/staff_list.htm">
						<i class="icon-double-angle-right"></i>
						Staff
					</a>
				</li>

				<li class="submenu_user submenu_user_merchant">
					<a href="${base}home/user/merchant_list.htm">
						<i class="icon-double-angle-right"></i>
						Merchant
					</a>
				</li>

				<li class="submenu_user submenu_user_sales_staff">
					<a href="${base}home/user/sales_staff_list.htm">
						<i class="icon-double-angle-right"></i>
						Sales Staff
					</a>
				</li>

				<li class="submenu_user submenu_user_privilege">
					<a href="dropzone.html">
						<i class="icon-double-angle-right"></i>
						Privilege
					</a>
				</li>
			</ul>
		</li>

		<li>
			<a href="calendar.html">
				<i class="icon-calendar"></i>

				<span class="menu-text">
					Design
				</span>
			</a>
		</li>

		<li>
			<a href="gallery.html">
				<i class="icon-picture"></i>
				<span class="menu-text"> Report </span>
			</a>
		</li>

		
	</ul>
	<!-- /.nav-list -->

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
	</div>

	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
	</script>
</div>