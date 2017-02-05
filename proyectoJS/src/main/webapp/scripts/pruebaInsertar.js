/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function subir() {
	event.preventDefault();
	var reserva = JSON.stringify({
		id_flight: $("#idVuelo").val(),
		name: $("#nombre").val(),
		surname: $("#apellidos").val(),
		telf: $("#telefono").val(),
                card: $("#card").val(),
                amount: $("#precio").val()
	});

	$.ajax({
		url: "webresources/reserve",
		type: "POST",
		contentType: 'application/json',
		data: reserva,
		dataType: "json"
	});

}