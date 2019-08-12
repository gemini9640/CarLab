<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String base = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("base",base);
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1    
response.setHeader("Pragma","no-cache"); //HTTP 1.0    
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

request.setAttribute("ace", base+"static/ace/assets/");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="common/html_head.jsp"/>
</head>
	<body>
		<jsp:include page="common/header.jsp"/>
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				
			<jsp:include page="common/leftNav.jsp"/>

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
							<li class="active">Dashboard</li>
						</ul><!-- .breadcrumb -->

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- #nav-search -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								Dashboard
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

<!-- 								<div class="alert alert-block alert-success"> -->
<!-- 									<button type="button" class="close" data-dismiss="alert"> -->
<!-- 										<i class="icon-remove"></i> -->
<!-- 									</button> -->

<!-- 									<i class="icon-ok green"></i> -->

<!-- 									欢迎使用 -->
<!-- 									<strong class="green"> -->
<!-- 										Ace后台管理系统 -->
<!-- 										<small>(v1.2)</small> -->
<!-- 									</strong> -->
<!-- 									,轻量级好用的后台管理系统模版.	 -->
<!-- 								</div> -->

								<jsp:include page="common/jsConfig.jsp"/>
								<jsp:include page="common/jsUtils.jsp"/>
								<jsp:include page="dashboard.jsp"/>
								<!-- PAGE CONTENT ENDS -->
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
	$.LeftMenuConfig.onDashboard();
</script>
<jsp:include page="common/html_foot.jsp"/>
</body>
</html>

