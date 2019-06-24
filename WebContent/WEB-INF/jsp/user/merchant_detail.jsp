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
						Merchant
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
												<label class="col-sm-3 control-label no-padding-right" for="form-field-3"> Company </label>
						
												<div class="col-sm-9">
													<input type="text" name="company" class="col-xs-10 col-sm-5" id="company" />
												</div>
											</div>
						
											<div class="space-4"></div>
						
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-4">Company Reg.</label>
						
												<div class="col-sm-9">
													<input class="col-xs-10 col-sm-5" type="text" name="regNo" id="companyReg" />
												</div>
											</div>
						
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-5">I/C</label>
						
												<div class="col-sm-9">
													<input class="col-xs-10 col-sm-5" type="text" name="ic" id="ic" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-6">Gender</label>
												<div class="radio">
													&nbsp&nbsp
													<label>
														<input type="radio" name="gender" value="male" class="ace" />
														<span class="lbl"> male</span>
													</label>
													&nbsp&nbsp
													<label>
														<input type="radio" name="gender" value="female" class="ace" />
														<span class="lbl"> female</span>
													</label>
												</div>
											</div>
						
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-7">Commission(%)</label>
						
												<div class="col-sm-9">
													<input class="col-xs-10 col-sm-5" type="text" name="commissionRate" id="commission" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-8">Bank Account</label>
						
												<div class="col-sm-9">
													<input class="col-xs-10 col-sm-5" type="text"  id="bankaccount" />
						<!-- 							name="bankaccount" -->
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
										Document
										<hr>
										<div class="form-group">
											<div class="col-sm-4">
													<div class="widget-main">
														<input multiple="" type="file" id="id-input-file-1" />
														<label>
															<input type="checkbox"  id="id-file-format" class="ace" />
														</label>
													</div>
											</div>
											<div class="col-sm-4">
													<div class="widget-main">
														<input multiple="" type="file" id="id-input-file-2" />
														<label>
															<input type="checkbox"  id="id-file-format" class="ace" />
														</label>
													</div>
											</div>
											<div class="col-sm-4">
													<div class="widget-main">
														<input multiple="" type="file" id="id-input-file-3" />
														<label>
															<input type="checkbox"  id="id-file-format" class="ace" />
														</label>
													</div>
											</div>
										
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
						<script>
						$('#id-input-file-1,#id-input-file-2,#id-input-file-3').ace_file_input({
							style:'well',
							btn_choose:'Drop files here or click to choose',
							btn_change:null,
							no_icon:'icon-cloud-upload',
							droppable:true,
							thumbnail:'small'//large | fit
							//,icon_remove:null//set null, to hide remove/reset button
							/**,before_change:function(files, dropped) {
								//Check an example below
								//or examples/file-upload.html
								return true;
							}*/
							/**,before_remove : function() {
								return true;
							}*/
							,
							preview_error : function(filename, error_code) {
								//name of the file that failed
								//error_code values
								//1 = 'FILE_LOAD_FAILED',
								//2 = 'IMAGE_LOAD_FAILED',
								//3 = 'THUMBNAIL_FAILED'
								//alert(error_code);
							}
						
						}).on('change', function(){
							//console.log($(this).data('ace_input_files'));
							//console.log($(this).data('ace_input_method'));
						});
						
						
						//dynamically change allowed formats by changing before_change callback function
						$('#id-file-format').removeAttr('checked').on('change', function() {
							var before_change
							var btn_choose
							var no_icon
							if(this.checked) {
								btn_choose = "Drop images here or click to choose";
								no_icon = "icon-picture";
								before_change = function(files, dropped) {
									var allowed_files = [];
									for(var i = 0 ; i < files.length; i++) {
										var file = files[i];
										if(typeof file === "string") {
											//IE8 and browsers that don't support File Object
											if(! (/\.(jpe?g|png|gif|bmp)$/i).test(file) ) return false;
										}
										else {
											var type = $.trim(file.type);
											if( ( type.length > 0 && ! (/^image\/(jpe?g|png|gif|bmp)$/i).test(type) )
													|| ( type.length == 0 && ! (/\.(jpe?g|png|gif|bmp)$/i).test(file.name) )//for android's default browser which gives an empty string for file.type
												) continue;//not an image so don't keep this file
										}
										
										allowed_files.push(file);
									}
									if(allowed_files.length == 0) return false;
						
									return allowed_files;
								}
							}
							else {
								btn_choose = "Drop files here or click to choose";
								no_icon = "icon-cloud-upload";
								before_change = function(files, dropped) {
									return files;
								}
							}
							var file_input = $('#id-input-file-1,#id-input-file-2,#id-input-file-3');
							file_input.ace_file_input('update_settings', {'before_change':before_change, 'btn_choose': btn_choose, 'no_icon':no_icon})
							file_input.ace_file_input('reset_input');
						});
						</script>
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
	$.LeftMenuConfig.onUserMerchant();
</script>
<jsp:include page="../common/html_foot.jsp"/>
</body>
</html>