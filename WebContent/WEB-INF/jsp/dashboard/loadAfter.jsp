<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	function selectUserType(type) {
		$(".block_user").hide();
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
	selectUserType("customer");
	if($(".dataValue").text() == "undefined") {
		$(".dataValue").css("color":"red");
	}
</script>