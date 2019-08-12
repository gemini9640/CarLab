<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../common/html_head.jsp"/>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="main-container" id="main-container">
	<script type="text/javascript">
		try{ace.settings.check('main-container' , 'fixed')}catch(e){}
	</script>
	<div class="main-container-inner">
	<jsp:include page="../common/leftNav.jsp"/>
		<div class="main-content">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
				</script>
				<ul class="breadcrumb">
					<li>
						<i class="icon-home home-icon"></i>
						<a href="#">Home</a>
					</li>
					<li class="active">Catelog</li>
				</ul><!-- .breadcrumb -->
			</div>
			<div class="page-content">
				<div class="page-header">
					<h1>
						Categories
						<small>
							<i class="icon-double-angle-right"></i>
							<span class="detail_action">Detail</span>
						</small>
					</h1>
				</div><!-- /.page-header -->

				<div class="row">
					<div class="col-xs-12">
						<jsp:include page="../common/jsConfig.jsp"/>
						<jsp:include page="../common/jsUtils.jsp"/>
						<!-- start 编辑区域 -->
						<div class="tabbable">
						
							<div class="">
								<div class="">
									Description
									<hr>
									<form class="form-horizontal" role="form">
										
										<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right" for="form-field-10">Category Name</label>
						
											<div class="col-sm-9">
												<input class="col-xs-10 col-sm-5" type="text" name="categoryName" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right" for="form-field-10">Color Tag</label>
						
											<div class="col-sm-9">
												<select id="simple-colorpicker-1" class="hide">
													<option value="#ac725e">#ac725e</option>
													<option value="#d06b64">#d06b64</option>
													<option value="#f83a22">#f83a22</option>
													<option value="#fa573c">#fa573c</option>
													<option value="#ff7537">#ff7537</option>
													<option value="#ffad46" selected="">#ffad46</option>
													<option value="#42d692">#42d692</option>
													<option value="#16a765">#16a765</option>
													<option value="#7bd148">#7bd148</option>
													<option value="#b3dc6c">#b3dc6c</option>
													<option value="#fbe983">#fbe983</option>
													<option value="#fad165">#fad165</option>
													<option value="#92e1c0">#92e1c0</option>
													<option value="#9fe1e7">#9fe1e7</option>
													<option value="#9fc6e7">#9fc6e7</option>
													<option value="#4986e7">#4986e7</option>
													<option value="#9a9cff">#9a9cff</option>
													<option value="#b99aff">#b99aff</option>
													<option value="#c2c2c2">#c2c2c2</option>
													<option value="#cabdbf">#cabdbf</option>
													<option value="#cca6ac">#cca6ac</option>
													<option value="#f691b2">#f691b2</option>
													<option value="#cd74e6">#cd74e6</option>
													<option value="#a47ae2">#a47ae2</option>
													<option value="#555">#555</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-offset-3 col-md-9">
												<button class="btn btn-info" type="button">
													<i class="icon-ok bigger-110"></i>
													Save
												</button>
						
												&nbsp; &nbsp; &nbsp;
												<button class="btn" type="reset">
													<i class="icon-undo bigger-110"></i>
													Cancel
												</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
						<!-- end 编辑区域 -->
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.page-content -->
		</div><!-- /.main-content -->
	</div><!-- /.main-container-inner -->
	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
		<i class="icon-double-angle-up icon-only bigger-110"></i>
	</a>
</div><!-- /.main-container -->
<script>
	$.LeftMenuConfig.reset();
	$.LeftMenuConfig.onCatelogCategoryAdd();
	$('#simple-colorpicker-1').ace_colorpicker();
</script>
<jsp:include page="../common/html_foot.jsp"/>
</body>
</html>