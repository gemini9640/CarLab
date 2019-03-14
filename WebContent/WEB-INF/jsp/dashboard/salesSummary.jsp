<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="block_table block_salesSummary col-xs-12" style="display:none;">
	<div class="table-header">
		Results for "Latest Sales"
	</div>
	<div class="table-responsive">
		<div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
		<div class="row">
		<div class="col-sm-6">
		<div id="sample-table-2_length" class="salesSummary_sizeSelector dataTables_length">
		</div>
		</div>
			</div>
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
function salesSummary(pageNumber) {
	var dateRange = new DateRange($('#id-date-range-picker-1').val());
	$(".tabaleData_sales").html("");
	$.post("${base}manage/booking/sales.do", {
		start : dateRange.start,
		end : dateRange.end,
		pageNum : pageNumber,
		pageSize : $("#salesSummary_size_selected").val()
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
			pagination("salesSummary", pageResp.pageSize, pageResp.navigatepageNums, pageResp.pageNum, pageResp.startRow, pageResp.endRow, pageResp.total);
		}
	});
}
</script>