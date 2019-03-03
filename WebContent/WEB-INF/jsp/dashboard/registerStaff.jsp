<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="block_table block_user_staff col-xs-12" style="display:none;">
	<div class="table-header">
		Results for "Latest Registered staff"
	</div>

	<div class="table-responsive">
		<div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
			<div class="row">
				<div class="col-sm-6">
					<div id="sample-table-2_length" class="staff_sizeSelector dataTables_length">
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
					<th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Price: activate to sort column ascending" style="width: 123px;">Role</th>
					<th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Price: activate to sort column ascending" style="width: 123px;">Email</th>
					<th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Update: activate to sort column ascending" style="width: 194px;">
						<i class="icon-time bigger-110 hidden-480"></i>
						Date
					</th>
					<th role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 191px;">Flag</th>
					<th role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 191px;">More</th>
				</tr>
			</thead>

			
		<tbody class="tabaleData_staff" role="alert" aria-live="polite" aria-relevant="all">
			
				</tbody></table>
				<div class="row staff_pageInfo"></div>
	</div>
</div>
</div>
<script>
function staffList(pageNumber) {
	$(".tabaleData_staff").html("");
	$.post("${base}manage/staff/list.do", {
		pageNum : pageNumber,
		pageSize : $("#staff_size_selected").val()
	},function(result) {
		if(result.status == 0) {
			$(".block_table").hide();
			$(".block_user_staff").show();
			var pageResp = result.data;
			var data = pageResp.list;
			var tr = "";
			for(var key in data) {
				var staff = data[key];
				tr += "<tr class='odd'>" +
							"<td class='dataValue'>"+staff.username+"</td>"+
							"<td class='dataValue'>"+staff.fullName+"</td>"+
							"<td class='dataValue'>"+staff.role+"</td>"+
							"<td class='dataValue'>"+staff.email+"</td>" +
							"<td class='dataValue'>"+staff.createTime+"</td>" +
							"<td class='dataValue'>"+staff.flag+"</td>" +
							"<td class=''>" +
								"<a class='blue' href='#'>" +
									"<i class='icon-zoom-in bigger-130'></i>" +
								"</a>" +
							"</td>" +
						"</tr>";
			}
			$(".tabaleData_staff").html(tr);
			undefinedRed(".dataValue");
			pagination("staff", pageResp.pageSize, pageResp.navigatepageNums, pageResp.pageNum, pageResp.startRow, pageResp.endRow, pageResp.total);
		}
	});
}
</script>