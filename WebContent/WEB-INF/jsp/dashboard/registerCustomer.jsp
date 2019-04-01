<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="block_table block_user_customer col-xs-12" style="display:none;">
	<div class="table-header">
		Results for "Latest Registered customer"
	</div>
	<div class="table-responsive">
		<div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
			<div class="row">
				<div class="col-sm-6">
					<div id="sample-table-2_length" class="customer_sizeSelector dataTables_length">
					</div>
				</div>
				<div class="col-sm-6">
					<div class="dataTables_filter" id="sample-table-2_filter">
					</div>
				</div>
			</div>
			<table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
				<thead>
					<tr role="row">
						<th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Domain: activate to sort column ascending" style="width: 162px;">Username</th>
						<th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Price: activate to sort column ascending" style="width: 123px;">Email</th>
						<th class="hidden-480" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Clicks: activate to sort column ascending" style="width: 138px;">Phone Number</th>
						<th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Update: activate to sort column ascending" style="width: 194px;">
							<i class="icon-time bigger-110 hidden-480"></i>
							Date
						</th>
						<th class="hidden-480" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending" style="width: 160px;">Total Spent</th>
						<th role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 191px;">More</th>
					</tr>
				</thead>
				<tbody class="tabaleData_customer" role="alert" aria-live="polite" aria-relevant="all">
				</tbody>
			</table>
			<div class="row customer_pageInfo">
			</div>
		</div>
	</div>
</div>
<script>
function customerList(pageNumber) {
	$(".tabaleData_customer").html("");
	$.post("${base}manage/customer/list.do", {
		pageNum : pageNumber,
		pageSize : $("#customer_size_selected").val()
	},function(result) {
// 		if(result.status == 0) {
			$(".block_table").hide();
			$(".block_user_customer").show();
// 			var pageResp = result.data;
// 			var data = pageResp.list;
			var pageResp = result;
			var data = pageResp;
			var tr = "";
			for(var key in data) {
				var customer = data[key];
				tr += "<tr class='odd'>" +
						"<td class='dataValue'>"+customer.username+"</td>"+
						"<td class='dataValue'>"+customer.email+"</td>" +
						"<td class='dataValue hidden-480 '>"+customer.phone+"</td>" +
						"<td class='dataValue'>"+fmtDateTime("MM/DD/YYYY HH:mm:ss", customer.createTime)+"</td>" +
						"<td class='dataValue hidden-480 '>"+customer.totalSpent+"</td>" +
						"<td class=''>" +
							"<a class='blue' href='#'>" +
								"<i class='icon-zoom-in bigger-130'></i>" +
							"</a>" +
						"</td>" +
					"</tr>";
			}
			$(".tabaleData_customer").html(tr);
			undefinedRed(".dataValue");
			pagination("customer", pageResp.pageSize, pageResp.navigatepageNums, pageResp.pageNum, pageResp.startRow, pageResp.endRow, pageResp.total);
// 		}
	});
}
</script>