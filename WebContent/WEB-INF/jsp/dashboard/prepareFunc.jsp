<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	jQuery(function($) {
		resetDateTimePicker($('#id-date-range-picker-1')); 
		$('#id-date-range-picker-1').daterangepicker({
				format: 'MM/DD/YYYY',
				separator : " to ",
	   	        ranges: {
	   	            'Today': [moment(),moment()],
	   	            'Yestoday': [moment().subtract(1, 'days'),moment().subtract(1, 'days')],
	   	            'Last 7 days': [moment().subtract(6, 'days'), moment()],
	   	            'This month': [moment().startOf('month'), moment().endOf('month')],
	   	            'Last month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
	   	        },
	   	        locale: {
	   	            applyLabel: "Apply",
	   	            cancelLabel: "Cancel",
	   	            fromLabel: "start date",
	   	            toLabel: "end date",
	   	            customRangeLabel: "Custom",
	   	            daysOfWeek: ["SUN","MON","TUE","WED","THU","FRI","STA"],
	   	            monthNames: ["JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SET","OCT","NOV","DEC"]
	   	        }
		   	}).prev().on(ace.click_event, function(){
			 	$(this).next().focus();
		 });
	});
	
	function resetDateTimePicker(picker) {
		picker.val(moment().subtract(6, 'days').format('MM/DD/YYYY') + ' to ' + moment().format('MM/DD/YYYY'));
	}
	
	function DateRange(rangePicker) {
		this.start = $.trim(rangePicker.split("to")[0])+ " 00:00:00";
		this.end = $.trim(rangePicker.split("to")[1])+ " 23:59:59";
	} 

	function selectUserType(type) {
		$(".btn_user_type").show();
		if(type=="customer") {
			$(".btn_user_type_select .btn_val").html("Customer");
			$(".btn_search").attr("onclick","customerList(1);");
			generateSizeSelector("customer", 10);
		} else if(type=="merchant") {
			$(".btn_user_type_select .btn_val").html("Merchant");
			$(".btn_search").attr("onclick","merchantList(1);");
			generateSizeSelector("merchant", 10);
		} else if(type=="staff") {
			$(".btn_user_type_select .btn_val").html("Staff");
			$(".btn_search").attr("onclick","staffList(1);");
			generateSizeSelector("staff", 10);
		}
	}
	function defaultSearch() {
		resetDateTimePicker($('#id-date-range-picker-1'));
		selectUserType("customer");
		customerList(1);
	}
	
	function showBookingBrief_sub() {
		resetDateTimePicker($('#id-date-range-picker-1'));
		$(".block_table").hide();
		$(".btn_user_type").hide();
		$(".block_bookingBrief").show();
		$(".btn_search").attr("onclick","bookingBrief(1);");
		generateSizeSelector("bookingBrief", 10);
	}
	
	function showBookingBriefByDefaultDate(status) {
		showBookingBrief_sub();
		bookingBrief(1, status);
	}
	
	function showBookingBriefByStatus(status) {
		showBookingBrief_sub();
		$(".mainTap").removeClass("active");
		$(".mainTap_booking").addClass("active");
		bookingBriefByStatus(1, status);
	}
	
	function showSalesSummary() {
		resetDateTimePicker($('#id-date-range-picker-1'));
		$(".block_table").hide();
		$(".btn_user_type").hide();
		$(".block_salesSummary").show();
		$(".btn_search").attr("onclick","salesSummary(1);");
		generateSizeSelector("salesSummary", 10);
		salesSummary(1);
	}
	
	
	
	function htmlSizeSelector(selectGroup, defaultSize) {
		return "<label>Display" + 
					"<select onchange='' id='"+selectGroup+"_size_selected' size='1' name='sample-table-2_length' aria-controls='sample-table-2'>" +
						"<option class='sizeOption' value='10' "+(defaultSize==10?"selected='selected'":"")+">10</option>" +
						"<option class='sizeOption' value='25' "+(defaultSize==25?"selected='selected'":"")+">25</option>" +
						"<option class='sizeOption' value='50' "+(defaultSize==50?"selected='selected'":"")+">50</option>" +
						"<option class='sizeOption' value='100' "+(defaultSize==100?"selected='selected'":"")+">100</option>" +
					"</select> " +
				"records</label>";
	}

	function generateQueryFunc(type, pageNumber) {
		var func = "onclick=";
		if(type == "customer") {
			func += "'customerList("+pageNumber+")'";
		} else if(type == "merchant") {
			func += "'merchantList("+pageNumber+")'";
		} else if(type == "staff") {
			func += "'staffList("+pageNumber+")'";
		} else if(type == "salesSummary") {
			func += "'salesSummary("+pageNumber+")'";
		} else if(type == "bookingBrief") {
			func += "'bookingBrief("+pageNumber+", "+BOOKING_STATUS+")'";
		} else {
			func = "";
		}
		return func;
	}
	
	function generateSizeSelector(selectGroup, pageSize) {
		var sizeSelector = htmlSizeSelector(selectGroup, pageSize);
		$("."+selectGroup+"_sizeSelector").html(sizeSelector);
	}
	
	function pagination(selectGroup, pageSize, navigatepage, nowPage, firstRow, lastRow, totalRow) {
		generateSizeSelector(selectGroup, pageSize);
		var navigation = "";
		for(var index in navigatepage) {
			var active = "";
			if(navigatepage[index] == nowPage) {
				active = "active";
			}
			navigation+="<li class='pageNumber "+active+"'><a href='###' "+generateQueryFunc(selectGroup, navigatepage[index])+">"+navigatepage[index]+"</a></li>"; 
		}
		var prevPage = "";
		var nextPage = "";
		if(nowPage-1>0) {
			prevPage = "<li class='prev'><a href='###' "+generateQueryFunc(selectGroup, nowPage-1)+"><i class='icon-double-angle-left'></i></a></li> ";
		} 
		if(nowPage<navigatepage.length) {
			nextPage = "<li class='next'><a href='###' "+generateQueryFunc(selectGroup, nowPage+1)+"><i class='icon-double-angle-right'></i></a></li> ";
		}
		var pageInfo = "<div class='col-sm-6'> "+
							"<div class='dataTables_info' id='sample-table-2_info'>Showing "+firstRow+" to "+lastRow+" of "+totalRow+" entries</div> "+
							"</div> "+
							"<div class='col-sm-6'> "+
								"<div class='dataTables_paginate paging_bootstrap'> "+
									"<ul class='pagination'> "+
										prevPage +
										navigation +
										nextPage +
									"</ul> "+
								"</div> "+
							"</div>";
		$("."+selectGroup+"_pageInfo").html(pageInfo);					
	}
</script>