$(function() {
	$( "#datepicker" ).datepicker({
		dateFormat: "yy-mm-dd",
		onSelect: function(datetext){
			$(this).val(datetext); }
	});
});