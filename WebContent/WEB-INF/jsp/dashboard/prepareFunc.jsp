<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	function selectUserType(type) {
		$(".block_table").hide();
		$(".btn_user_type").show();
		if(type=="customer") {
			$(".block_user_customer").show();
			$(".btn_user_type_select .btn_val").html("Customer");
			customerList();
		} else if(type=="merchant") {
			$(".block_user_merchant").show();
			$(".btn_user_type_select .btn_val").html("Merchant");
			merchantList();
		} else if(type=="staff") {
			$(".block_user_staff").show();
			$(".btn_user_type_select .btn_val").html("Staff");
			staffList();
		}
		
	}
	
	function showRegister() {
		$(".block_table").hide();
		$(".btn_user_type").show();
		$(".block_user_customer").show();
	}
	
	function showBookingBrief() {
		$(".block_table").hide();
		$(".btn_user_type").hide();
		$(".block_bookingBrief").show();
		bookingBrief();
	}
	
	function showSalesSummary() {
		$(".block_table").hide();
		$(".btn_user_type").hide();
		$(".block_salesSummary").show();
		salesSummary();
	}
	
	function undefinedRed(selector) {
		$(selector).each(function() {
			if($(this).text() == "undefined") {
				$(this).addClass("red");
			}
		});
	}
	
	function pagination(selector, navigatepage, nowPage, firstRow, lastRow, totalRow) {
		console.log(navigatepage);
		var navigation = "";
		for(var index in navigatepage) {
			var active = "";
			if(navigatepage[index] == nowPage) {
				active = "active";
			}
			navigation+="<li class='"+active+"'><a href='#'>"+navigatepage[index]+"</a></li>"; 
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
		$(selector).html(pageInfo);					
	}
</script>