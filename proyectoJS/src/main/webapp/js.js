$(document).ready(function() {
	$("form").submit(subir);
});

function subir() {
	event.preventDefault();
	var findParams = JSON.stringify({
		price: $("[name='price']").val(),
		departure: $("[name='departure']").val(),
		arrive: $("[name='arrive']").val(),
		airlines: $("[name='airlines']").val()
	});

	$.ajax({
		url: "webresources/find",
		type: "POST",
		contentType: 'application/json',
		data: findParams,
		dataType: "json"
	});

}
