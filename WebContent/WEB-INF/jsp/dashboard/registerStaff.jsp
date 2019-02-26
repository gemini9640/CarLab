<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="btn-group">
	<button data-toggle="dropdown" class="btn btn-warning dropdown-toggle">
		Customer
		<span class="icon-caret-down icon-on-right"></span>
	</button>

	<ul class="dropdown-menu dropdown-warning">
		<li>
			<a href="#">Customer</a>
		</li>
		<li>
			<a href="#">Merchant</a>
		</li>
		<li>
			<a href="#">Staff</a>
		</li>
	</ul>
</div>
<div class="col-xs-12">
	<div class="table-header">
		Results for "Latest Registered users"
	</div>

	<div class="table-responsive">
		<div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
			<div class="row">
				<div class="col-sm-6">
					<div id="sample-table-2_length" class="dataTables_length">
						<label>Display 
							<select size="1" name="sample-table-2_length" aria-controls="sample-table-2">
								<option value="10" selected="selected">10</option>
								<option value="25">25</option>
								<option value="50">50</option>
								<option value="100">100</option>
							</select> 
						records</label>
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

			
		<tbody class="tabaleData" role="alert" aria-live="polite" aria-relevant="all">
			
				</tbody></table><div class="row"><div class="col-sm-6"><div class="dataTables_info" id="sample-table-2_info">Showing 1 to 10 of 23 entries</div></div><div class="col-sm-6"><div class="dataTables_paginate paging_bootstrap"><ul class="pagination"><li class="prev disabled"><a href="#"><i class="icon-double-angle-left"></i></a></li><li class="active"><a href="#">1</a></li><li><a href="#">2</a></li><li><a href="#">3</a></li><li class="next"><a href="#"><i class="icon-double-angle-right"></i></a></li></ul></div></div></div></div>
	</div>
</div>
<script>
$.post("${base}manage/customer/list.do", {
	pageNum : "1",
	pageSize : "50"
},function(result) {
	if(result.status == 0) {
		var page = result.data;
		var data = page.list;
		var tr = "";
		for(var key in data) {
			var customer = data[key];
			tr += "<tr class='odd'>" +
						"<td class=' '>"+customer.username+"</td>"+
						"<td class=' '>"+customer.email+"</td>" +
						"<td class='hidden-480 '>"+customer.phone+"</td>" +
						"<td class=' '>"+customer.createTime+"</td>" +
						"<td class='hidden-480 '>"+customer.totalSpent+"</td>" +
						"<td class=' '>" +
							"<a class='blue' href='#'>" +
								"<i class='icon-zoom-in bigger-130'></i>" +
							"</a>" +
						"</td>" +
					"</tr>";
		}
		
		$(".tabaleData").html(tr);
	}
	
})

</script>