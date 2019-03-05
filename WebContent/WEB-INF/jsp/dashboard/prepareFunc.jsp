<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	jQuery(function($) {
		$("#id-date-range-picker-1").val(moment().format('MM/DD/YYYY') + ' to ' + moment().format('MM/DD/YYYY')); 
		$('#id-date-range-picker-1').daterangepicker({
				format: 'MM/DD/YYYY',
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
	
	DateRange = {
		start : $.trim($("#id-date-range-picker-1").val().split("to")[0])+ "00:00:00",
		end : $.trim($("#id-date-range-picker-1").val().split("to")[1])+ "00:00:00"
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
		selectUserType("customer");
		customerList(1);
	}
	
	function showBookingBrief() {
		$(".block_table").hide();
		$(".btn_user_type").hide();
		$(".block_bookingBrief").show();
		$(".btn_search").attr("onclick","bookingBrief(1);");
		generateSizeSelector("bookingBrief", 10);
		bookingBrief(1);
	}
	
	function showSalesSummary() {
		$(".block_table").hide();
		$(".btn_user_type").hide();
		$(".block_salesSummary").show();
		$(".btn_search").attr("onclick","salesSummary(1);");
		generateSizeSelector("salesSummary", 10);
		salesSummary(1);
	}
	
	function undefinedRed(selector) {
		$(selector).each(function() {
			if($(this).text() == "undefined") {
				$(this).addClass("red");
			}
		});
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
			navigation+="<li class='pageNumber "+active+"'><a href='#'>"+navigatepage[index]+"</a></li>"; 
		}
		var pageInfo = "<div class='col-sm-6'> "+
							"<div class='dataTables_info' id='sample-table-2_info'>Showing "+firstRow+" to "+lastRow+" of "+totalRow+" entries</div> "+
							"</div> "+
							"<div class='col-sm-6'> "+
								"<div class='dataTables_paginate paging_bootstrap'> "+
									"<ul class='pagination'> "+
										"<li class='prev disabled'><a href='#'><i class='icon-double-angle-left'></i></a></li> "+
										navigation +
										"<li class='next'><a href='#'><i class='icon-double-angle-right'></i></a></li> "+
									"</ul> "+
								"</div> "+
							"</div>";
		$("."+selectGroup+"_pageInfo").html(pageInfo);					
	}
</script>