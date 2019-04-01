<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<p>
<button onclick="showBookingBrief(2);" class="btn btn-success">
	<i class="icon-road align-top bigger-125"></i>
	On going
	100
</button>
<button onclick="showBookingBrief(0);" class="btn btn-warning">
	<i class="icon-time align-top bigger-125"></i>
	Pending
	100
</button>
<button onclick="showBookingBrief(3);" class="btn btn-info">
	<i class="icon-ok  align-top bigger-125"></i>
	Done
	100
</button>
<button onclick="showBookingBrief(-1);" class="btn">
	<i class="icon-remove  align-top bigger-125"></i>
	Cancel
	100
</button>
</p>
<script>
function clickBooking() {

	$("#booking_query").click();
}
</script>