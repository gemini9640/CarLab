<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${ace}css/datepicker.css" />
<script src="${ace}js/date-time/bootstrap-datepicker.min.js"></script>
<div class="col-sm widget-container-span">
	<div class="widget-box transparent">
		<div class="widget-header">
			<div class="widget-toolbar no-border">
				<ul class="nav nav-tabs" id="myTab2">
					<li class="active" onclick="selectUserType('customer');">
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

<div class="btn-group" style="float:right;">
	<button data-toggle="dropdown" class="btn btn-primary dropdown-toggle">
		This Week
		<i class="icon-angle-down icon-on-right"></i>
	</button>
	<ul class="dropdown-menu">
		<li>
			<a href="#">This Week</a>
		</li>
		<li>
			<a href="#">Last Week</a>
		</li>
		<li>
			<a href="#">This Month</a>
		</li>
		<li>
			<a href="#">Last Month</a>
		</li>
	</ul>
</div>
	<div class="col-xs-3" style="float:right;">
		<label>Date Picker</label>
		<div class="input-group">
			<input class="form-control date-picker" id="id-date-picker-1" type="text" data-date-format="dd-mm-yyyy" />
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
<script>
jQuery(function($) {
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
});
</script>
<div class="btn_user_type btn-group">
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