<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="block_table block_user_merchant col-xs-12" style="display:none;">
	<div class="table-header">
		Results for "Latest Registered merchant"
	</div>

	<div class="table-responsive">
		<div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
			<div class="row">
				<div class="col-sm-6">
					<div id="sample-table-2_length" class="merchant_sizeSelector dataTables_length">
						</div></div>
						<div class="col-sm-6">
							<div class="dataTables_filter" id="sample-table-2_filter">
							</div>
						</div>
					</div>
		<table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
			<thead>
				<tr role="row">
					<th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Domain: activate to sort column ascending" style="width: 162px;">Username</th>
					<th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Price: activate to sort column ascending" style="width: 123px;">Full Name</th>
					<th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Price: activate to sort column ascending" style="width: 123px;">Company</th>
					<th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Price: activate to sort column ascending" style="width: 123px;">Email</th>
					<th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 138px;">Phone Number</th>
					<th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Price: activate to sort column ascending" style="width: 123px;">Refferer</th>
					<th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Update: activate to sort column ascending" style="width: 194px;">
						<i class="icon-time bigger-110 hidden-480"></i>
						Date
					</th>
					<th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 160px;">Commission Rate</th>
					<th role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 191px;">Flag</th>
					<th role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 191px;">More</th>
				</tr>
			</thead>

			
		<tbody class="tabaleData_merchant" role="alert" aria-live="polite" aria-relevant="all">
			
				</tbody></table>
				<div class="row merchant_pageInfo"></div>
	</div>
</div>
</div>
<script>
function merchantList(pageNumber) {
	$(".tabaleData_merchant").html("");
	$.post("${base}manage/merchant/list.do", {
		pageNum : pageNumber,
		pageSize : $("#merchant_size_selected").val()
	},function(result) {
		if(result.status == 0) {
			$(".block_table").hide();
			$(".block_user_merchant").show();
			var pageResp = result.data;
			var data = pageResp.list;
			var tr = "";
			for(var key in data) {
				var merchant = data[key];
				tr += "<tr class='odd'>" +
							"<td class='dataValue'>"+merchant.username+"</td>"+
							"<td class='dataValue'>"+merchant.fullName+"</td>"+
							"<td class='dataValue'>"+merchant.company+"</td>"+
							"<td class='dataValue'>"+merchant.email+"</td>" +
							"<td class='dataValue hidden-480 '>"+merchant.phone+"</td>" +
							"<td class='dataValue'>"+merchant.referer+"</td>" +
							"<td class='dataValue'>"+fmtDateTime("MM/DD/YYYY HH:mm:ss", merchant.createTime)+"</td>" +
							"<td class='dataValue'>"+merchant.commissionRate+"</td>" +
							"<td class='dataValue'>"+merchant.flag+"</td>" +
							"<td class=''>" +
								"<a class='blue' href='#'>" +
									"<i class='icon-zoom-in bigger-130'></i>" +
								"</a>" +
							"</td>" +
						"</tr>";
			}
			$(".tabaleData_merchant").html(tr);
			undefinedRed(".dataValue");
			pagination("merchant", pageResp.pageSize, pageResp.navigatepageNums, pageResp.pageNum, pageResp.startRow, pageResp.endRow, pageResp.total);
		}
		
	});
}
</script>