<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-xs-3" style="float:left;">
	<div class="input-group">
		<span class="input-group-addon">
			<i class="icon-calendar bigger-110"></i>
		</span>
		<input class="form-control" type="text" name="date-range-picker" id="id-date-range-picker-1" />
	</div>
</div>
<button class="btn_search btn btn-primary" style="float:right;">
	<i class="align-top"></i>
	Search
</button>
<div class="block_table col-xs-12">
	<div class="table-header">
		Results for "Merchant List"
	</div>
	
	<div class="table-responsive">
		<div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid"><div class="row"><div class="col-sm-6">
		<div id="sample-table-2_length" class="merchant_sizeSelector dataTables_length">
		</div>
		</div>
		</div>
		<table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
			<thead>
				<tr role="row">
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 162px;"><input class="merchant_id_main_ck" type="checkbox" /></th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 162px;">ID</th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;">Username</th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;">Company</th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;">Email</th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;">Commission</th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;">
						<i class="icon-time bigger-110 hidden-480"></i>
						Date
					</th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;"></th>
				</tr>
			</thead>
			<tbody class="tabaleData_merchant" role="alert" aria-live="polite" aria-relevant="all">
			</tbody>
		</table>
		<div class="row merchant_pageInfo">
		</div>
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
			var pageResp = result.data;
			var data = pageResp.list;
			var tr = "";
			for(var key in data) {
				var merchant = data[key];
				tr += "<tr class='odd'>" +
							"<td class='dataValue'><input class='merchant_id_ck merchant_id_"+merchant.id+"' type='checkbox' />&nbsp&nbsp&nbsp"+merchant.id+"</td>"+
							"<td class='dataValue'>"+merchant.username+"</td>"+
							"<td class='dataValue'>"+merchant.fullName+"</td>"+
							"<td class='dataValue'>"+merchant.company+"</td>"+
							"<td class='dataValue'>"+merchant.email+"</td>" +
							"<td class='dataValue'>"+merchant.commissionRate * 100 +"%</td>" +
							"<td class='dataValue'>"+$.JsUtil.fmtDateTime("MM/DD/YYYY HH:mm:ss", merchant.createTime)+"</td>" +
							"<td class=''>" +
								"<a class='blue' href='#'>" +
									"<i class='icon-zoom-in bigger-130'></i>" +
								"</a>" +
							"</td>" +
						"</tr>";
			}
			$(".tabaleData_merchant").html(tr);
			$.JsUtil.undefinedRed(".dataValue");
			$.TableDataConfig.pagination("merchant", pageResp.pageSize, pageResp.navigatepageNums, pageResp.pageNum, pageResp.startRow, pageResp.endRow, pageResp.total);
			$(".pagination_info").before("<div class='ui-pg-div'><span class='ui-icon icon-plus-sign purple'></span><span class='ui-icon icon-trash red'></span></div>");
		}
	});
}

$.DateTimeConfig.init();
$.TableDataConfig.generateSizeSelector("merchant", 10);
merchantList(1);
</script>