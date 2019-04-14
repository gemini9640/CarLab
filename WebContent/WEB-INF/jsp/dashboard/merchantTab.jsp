<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="widget-box transparent" id="recent-box">
	<div class="widget-header" style="position: unset;">
		<h4 class="lighter smaller">
			<i class="icon-rss orange"></i>
			Recent
		</h4>

		<div class="widget-toolbar no-border">
			<ul class="nav nav-tabs" id="recent-tab">

				<li class="active">
					<a data-toggle="tab" href="#member-tab">Merchant</a>
				</li>
			</ul>
		</div>
	</div>

	<div class="widget-body">
		<div class="widget-main padding-4">
			<div class="tab-content padding-8 overflow-visible">

				<div id="member-tab" class="tab-pane active">
					<div class="quickLook clearfix">
					</div>

					<div class="center">
						<i class="icon-group icon-2x green"></i>

						&nbsp;
						<a href="#">
							查看所有会员 &nbsp;
							<i class="icon-arrow-right"></i>
						</a>
					</div>

					<div class="hr hr-double hr8"></div>
				</div><!-- member-tab -->

			</div>
		</div><!-- /widget-main -->
	</div><!-- /widget-body -->
</div>
<script>
	$.MerchantTab = {
		queryMerchantQuickLook : function() {
			$.get("${base}manage/merchant/quickLookList.do", function(json) {
				var data = json.data;
				for(var key in data) {
					$(".quickLook").append($.MerchantTab.htmlMerchantQuickLook(data[key]));
				}
			});
		},
		updateMerchantQuickLook : function(id, flag) {
			$.post("${base}manage/merchant/updateQuickLookMerchant.do", {
				id : id,
				flag : flag
			}, function(json) {
				if(json.status == 0) {
					if(flag == 1) {
						
					} else if(flag == 2) {
						
					}
					$("#merchant_quick_look_"+id).remove();
				} 
				alert(json.msg);
			});
		},
		htmlMerchantQuickLook : function(quickLook) {
			return "<div id='merchant_quick_look_"+quickLook.id+"'>" +
					"<div class='itemdiv memberdiv'>" +
							"<div class='user'>" +
							"<img alt='"+quickLook.company+" s avatar' src='${ace}avatars/user.jpg'>" +
						"</div>" +
				
						"<div class='body'>" +
							"<div class='name'>" +
								"<a href='#'>"+quickLook.company+"</a>" +
							"</div>" +
				
							"<div class='time'>" +
								"<i class='icon-time'></i>" +
								"<span class='green'>"+quickLook.createTimeShortForm+"</span>" +
							"</div>" +
				
							"<div>" +
								"<span class='label label-warning label-sm'>pending</span>" +
				
								"<div class='inline position-relative'>" +
									"<button class='btn btn-minier bigger btn-yellow btn-no-border dropdown-toggle' data-toggle='dropdown'>" +
										"<i class='icon-angle-down icon-only bigger-120'></i>" +
									"</button>" +
				
									"<ul class='dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close'>" +
										"<li>" +
											"<a onclick='$.MerchantTab.updateMerchantQuickLook(\""+quickLook.id+"\", 1);' href='###' class='tooltip-success' data-rel='tooltip' title='' data-original-title='Approve'>" +
												"<span class='green'>" +
													"<i class='icon-ok bigger-110'></i>" +
												"</span>" +
											"</a>" +
										"</li>" +
				
										"<li>" +
											"<a onclick='$.MerchantTab.updateMerchantQuickLook(\""+quickLook.id+"\", 2);' href='###' class='tooltip-warning' data-rel='tooltip' title='' data-original-title='Reject'>" +
												"<span class='orange'>" +
													"<i class='icon-remove bigger-110'></i>" +
												"</span>" +
											"</a>" +
										"</li>" +
				
										"<li>" +
											"<a href='#' class='tooltip-error' data-rel='tooltip' title='' data-original-title='Delete'>" +
												"<span class='red'>" +
													"<i class='icon-trash bigger-110'></i>" +
												"</span>" +
											"</a>" +
										"</li>" +
									"</ul>" +
								"</div>" +
							"</div>" +
						"</div>" +
					"</div>" +
				"</div>";
		}
	}
	$.MerchantTab.queryMerchantQuickLook();
</script>