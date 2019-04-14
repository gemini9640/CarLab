<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="block_table block_bookingBrief col-xs-12" style="display:none;">
	<div class="table-header">
		Results for "Latest Bookings"
	</div>

	<div class="table-responsive">
		<div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid"><div class="row"><div class="col-sm-6">
		<div id="sample-table-2_length" class="bookingBrief_sizeSelector dataTables_length">
		</div>
		</div>
		</div>
		<table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
			<thead>
				<tr role="row">
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 162px;">Booking No.</th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 162px;">Category</th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;">Username</th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;">Email</th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;">Phone Number</th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;">
						<i class="icon-time bigger-110 hidden-480"></i>
						Date
					</th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;">Status</th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;">Merchant</th>
					<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 194px;">More</th>
				</tr>
			</thead>
			<tbody class="tabaleData_booking" role="alert" aria-live="polite" aria-relevant="all">
			</tbody>
		</table>
		<div class="row bookingBrief_pageInfo">
		</div>
	</div>
</div>
</div>
<script>
var BOOKING_STATUS = 99;
function bookingBrief(pageNumber, status) {
	BOOKING_STATUS = status;
	var dateRange = new DateRange($('#id-date-range-picker-1').val());
	$(".tabaleData_booking").html("");
	$.post("${base}manage/booking/brief.do", {
		start : dateRange.start,
		end : dateRange.end,
		status : status,
		pageNum : pageNumber,
		pageSize : $("#bookingBrief_size_selected").val()
	},function(result) {
		if(result.status == 0) {
			var pageResp = result.data;
			var data = pageResp.list;
			var tr = "";
			for(var key in data) {
				var booking = data[key];
				tr += "<tr class='odd'>"+
						"<td class='dataValue'>"+booking.bookingNo+"</td>"+
						"<td class='dataValue'>"+booking.category+"</td>"+
						"<td class='dataValue'>"+booking.username+"</td>"+
						"<td class='dataValue'>"+booking.email+"</td>"+
						"<td class='dataValue'>"+booking.phoneNo+"</td>"+
						"<td class='dataValue'>"+booking.createTime+"</td>"+
						"<td class='dataValue'>"+booking.status+"</td>"+
						"<td class='dataValue'>"+booking.merchant+"</td>"+
						"<td class='dataValue'>" +
							"<a class='blue' href='#'>" +
								"<i class='icon-zoom-in bigger-130'></i>" +
							"</a>" +
						"</td>" +
					"</tr>";
			}
			$(".tabaleData_booking").html(tr);
			$.JsUtil.undefinedRed(".dataValue");		
			pagination("bookingBrief", pageResp.pageSize, pageResp.navigatepageNums, pageResp.pageNum, pageResp.startRow, pageResp.endRow, pageResp.total);
		}
	});
}
</script>