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
					<li class="active">User</li>
				</ul><!-- .breadcrumb -->
			</div>
			<div class="page-content">
				<div class="page-header">
					<h1>
						Staff
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
							<ul class="nav nav-tabs" id="myTab">
								<li class="active">
									<a data-toggle="tab" href="#merchant_basic_info">
										<i class="green icon-home bigger-110"></i>
										Basic info
									</a>
								</li>
						
								<li>
									<a data-toggle="tab" href="#merchant_password">
										Password
									</a>
								</li>
							</ul>
						
							<div class="tab-content">
								<div id="merchant_basic_info" class="tab-pane in active">
									<form id="merchant_add_form" class="form-horizontal" role="form" action="${base}manage/merchant/add.do" method="post">
										General
										<hr>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Username </label>
						
												<div class="col-sm-9">
													<input type="text" id="username" name="username" class="col-xs-10 col-sm-5" />
												</div>
											</div>
						
											<div class="space-4"></div>
						
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> Name </label>
												<div class="col-sm-9">
													<input type="text" id="name" name="fullName" class="col-xs-10 col-sm-5" />
												</div>
											</div>
						
											<div class="space-4"></div>
						
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-select-3">Role</label>
													<div class="col-sm-3">
													<select class="width-80 chosen-select" id="form-field-select-3" data-placeholder="Choose a Country..." style="display: none;">
														<option value="AL">Alabama</option>
														<option value="AK">Alaska</option>
														<option value="AZ">Arizona</option>
													</select>
												</div>
											</div>
															
										Contact
										<hr>
										<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right" for="form-field-9">Email</label>
						
											<div class="col-sm-9">
												<input class="col-xs-10 col-sm-5" type="text" name="email" id="email" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right" for="form-field-10">Phone Number</label>
						
											<div class="col-sm-9">
												<input class="col-xs-10 col-sm-5" type="text" name="phone" id="phone" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-offset-3 col-md-9">
												<button class="btn btn-info" type="submit">
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
						
								<div id="merchant_password" class="tab-pane">
									<form class="form-horizontal" role="form">
										<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right" for="form-field-9">New Password</label>
						
											<div class="col-sm-9">
												<input class="col-xs-10 col-sm-5" type="password" id="newpassword" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right" for="form-field-10">Confirm Password</label>
						
											<div class="col-sm-9">
												<input class="col-xs-10 col-sm-5" type="password" id="confirmPassword" />
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
	$.LeftMenuConfig.onUserStaff();
	$.DropDownListConfig.init();
</script>
<jsp:include page="../common/html_foot.jsp"/>
</body>
</html>