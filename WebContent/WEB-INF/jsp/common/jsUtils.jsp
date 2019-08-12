<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
$.JsUtil = {
	fmtDateTime : function (format, val) {
		if (val != null) {
		    var date = new Date(val);
		    var month = (date.getMonth() + 1);
		    var day = date.getDate();
		    var year = date.getFullYear();
		    var hour = date.getHours();
		    var min = date.getMinutes();
		    var sec = date.getSeconds();
		    
		    var formator = format.toLowerCase();
			if(formator == "mm/dd/yyyy hh:mm:ss") {
			    return month + '/' + day + "/" + year + " " + hour + ":" + min + ":" + sec;
		    } else if(formator == "mm/dd/yyyy") {
		    	return month + '/' + day + "/" + year;
		    } else {
		    	return "";
		    }
		}
	},
	undefinedRed : function (selector) {
		$(selector).each(function() {
			if($(this).text() == "undefined") {
				$(this).addClass("red");
			}
		});
	}
}

jQuery(function($) {
	resetDateTimePicker($('#id-date-range-picker-1')); 
	$('#id-date-range-picker-1').daterangepicker({
			format: 'MM/DD/YYYY',
			separator : " to ",
   	        ranges: {
   	            'Today': [moment(),moment()],
   	            'Yestoday': [moment().subtract(1, 'days'),moment().subtract(1, 'days')],
   	            'Last 7 days': [moment().subtract(6, 'days'), moment()],
   	            'This month': [moment().startOf('month'), moment().endOf('month')],
   	            'Last month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
   	        },
   	        locale: {
   	            applyLabel: "Apply",
   	            cancelLabel: "Cancel",
   	            fromLabel: "start date",
   	            toLabel: "end date",
   	            customRangeLabel: "Custom",
   	            daysOfWeek: ["SUN","MON","TUE","WED","THU","FRI","STA"],
   	            monthNames: ["JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SET","OCT","NOV","DEC"]
   	        }
	   	}).prev().on(ace.click_event, function(){
		 	$(this).next().focus();
	 });
});

function resetDateTimePicker(picker) {
	picker.val(moment().subtract(6, 'days').format('MM/DD/YYYY') + ' to ' + moment().format('MM/DD/YYYY'));
}

function DateRange(rangePicker) {
	this.start = $.trim(rangePicker.split("to")[0])+ " 00:00:00";
	this.end = $.trim(rangePicker.split("to")[1])+ " 23:59:59";
} 
</script>