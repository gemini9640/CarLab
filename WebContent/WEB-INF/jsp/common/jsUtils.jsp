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
</script>