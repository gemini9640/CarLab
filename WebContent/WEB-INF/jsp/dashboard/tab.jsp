<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <link rel="stylesheet" href="${ace}css/datepicker.css" /> --%>
<link rel="stylesheet" href="${ace}css/daterangepicker.css" />
<script src="${ace}js/date-time/moment.min.js"></script>
<%-- <script src="${ace}js/date-time/bootstrap-datepicker.min.js"></script> --%>
<script src="${ace}js/date-time/daterangepicker.min.js"></script>
<div class="col-sm widget-container-span">
	<div class="widget-box transparent">
		<div class="widget-header">
			<div class="widget-toolbar no-border">
				<ul class="nav nav-tabs" id="myTab2">
					<li class="active" onclick="defaultSearch();">
						<a data-toggle="tab" href="#home2">Register</a>
					</li>
					<li onclick="showSalesSummary();">
						<a data-toggle="tab" href="#profile2">Sales</a>
					</li>
					<li onclick="showBookingBrief();">
						<a data-toggle="tab" href="#info2">Booking</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<br/>

<!-- <div class="btn_search btn-group" style="float:right;"> -->
<!-- 	<button data-toggle="dropdown" class="btn btn-primary dropdown-toggle"> -->
<!-- 		This Week -->
<!-- 		<i class="icon-angle-down icon-on-right"></i> -->
<!-- 	</button> -->
<!-- 	<ul class="dropdown-menu"> -->
<!-- 		<li> -->
<!-- 			<a href="#">This Week</a> -->
<!-- 		</li> -->
<!-- 		<li> -->
<!-- 			<a href="#">Last Week</a> -->
<!-- 		</li> -->
<!-- 		<li> -->
<!-- 			<a href="#">This Month</a> -->
<!-- 		</li> -->
<!-- 		<li> -->
<!-- 			<a href="#">Last Month</a> -->
<!-- 		</li> -->
<!-- 	</ul> -->
<!-- </div> -->


<div class="btn_user_type btn-group" style="float:left;">
	<button data-toggle="dropdown" class="btn btn_user_type_select btn-warning dropdown-toggle">
		<b><span class="btn_val">Customer</span></b>
		<span class="icon-caret-down icon-on-right"></span>
	</button>

	<ul class="dropdown-menu dropdown-warning">
		<li>
			<a onclick="selectUserType('customer');" href="#">Customer</a>
		</li>
		<li>
			<a onclick="selectUserType('merchant');" href="#">Merchant</a>
		</li>
		<li>
			<a onclick="selectUserType('staff');" href="#">Staff</a>
		</li>
	</ul>
</div>
<div class="col-xs-3" style="float:left;">
	<div class="input-group">
		<span class="input-group-addon">
			<i class="icon-calendar bigger-110"></i>
		</span>
		<input class="form-control" type="text" name="date-range-picker" id="id-date-range-picker-1" />
	</div>
</div>
<button class="btn_search btn btn-primary" style="float:right;">
	<i class="align-top"></i>
	Search
</button>
<br/>
<br/>
<br/>
