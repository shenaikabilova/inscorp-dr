$(function() {
	$( "#datepicker1" ).datepicker({
		dateFormat: "yy-mm-dd",
		onSelect: function(datetext){
			$(this).val(datetext); }
	});
});

$(function() {
	$( "#datepicker2" ).datepicker({
		dateFormat: "yy-mm-dd",
		onSelect: function(datetext){
			$(this).val(datetext); }
	});
});