<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="block_table block_salesSummary col-xs-12" style="display:none;">
	<div class="table-header">
		Results for "Latest Registered users"
	</div>

	<div class="table-responsive">
		<div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid"><div class="row"><div class="col-sm-6"><div id="sample-table-2_length" class="dataTables_length"><label>Display <select size="1" name="sample-table-2_length" aria-controls="sample-table-2"><option value="10" selected="selected">10</option><option value="25">25</option><option value="50">50</option><option value="100">100</option></select> records</label></div></div><div class="col-sm-6"><div class="dataTables_filter" id="sample-table-2_filter"><label>Search: <input type="text" aria-controls="sample-table-2"></label></div></div></div>
			<table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
				<thead>
					<tr role="row">
						<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 162px;">Category</th>
						<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;">
							Sales
						</th>
						<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;">
							<i class="icon-time bigger-110 hidden-480"></i>
							Date
						</th>
					</tr>
				</thead>
				<tbody class="tabaleData_sales" role="alert" aria-live="polite" aria-relevant="all">
				</tbody>
			</table>
			<div class="row salesSummary_pageInfo">
			</div>
		</div>
	</div>
</div>
<script>
function salesSummary() {
	$(".tabaleData_sales").html("");
	$.post("${base}manage/booking/sales.do", {
		start : "2019-02-01 00:00:00",
		end : "2020-03-01 00:00:00",
		pageNum : "1",
		pageSize : "50"
	},function(result) {
		if(result.status == 0) {
			var pageResp = result.data;
			var data = pageResp.list;
			var tr = "";
			for(var key in data) {
				var sales = data[key];
				tr += "<tr class='odd'>"+
							"<td class='dataValue'>"+
							"<a href='#'>"+sales.category+"</a>"+
						"</td>"+
						"<td class='dataValue'>$"+sales.sales+"</td>"+
						"<td class='dataValue'>"+sales.date+"</td>"+
					"</tr>";
			}
			$(".tabaleData_sales").html(tr);
			undefinedRed(".dataValue");
			pagination(".customer_pageInfo", pageResp.navigatepageNums, pageResp.pageNum, pageResp.startRow, pageResp.endRow, pageResp.total);
		}
	});
}
</script>