jQuery(document).ready(function() {
	//Boton Para abrir el menú de busqueda.
	$("#ButtonSearch").on("click", function() {
		$("#aside").slideToggle();
		if ($(this).css("color") == "rgb(211, 211, 211)") {
			$(this).css({
				"background-color": "lightgray",
				"color": "#6495ED"
			});
		} else {

			$(this).css({
				"background-color": "#6495ED",
				"color": "lightgray"
			});
		}
	});
	getRange();
	setHour();
	getAirlines();
	setButton();
});

function getRange() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			setRange(this.responseText);
		}
	};
	xhttp.open("GET", "http://localhost:8080/proyectoJS/webresources/find/range", true);
	xhttp.send();
}

function setRange(data) {
	var prices = data.split("_");
	prices[0] = Number(prices[0]);
	prices[1] = Number(prices[1]);
	var handle = $("#custom-handle");
	$("#slider").slider({
		value: (prices[0] + prices[1]) / 2,
		min: prices[0],
		max: prices[1],
		slide: function(event, ui) {
			$("#amount").val(ui.value + " €");
		}
	});
	$("#min").text(prices[0]);
	$("#max").text(prices[1]);
	$("#amount").val($("#slider").slider("value") + " €");
}

function setHour() {
	$('.timepicker').timepicker({
		timeFormat: 'HH:mm ',
		interval: 30,
		minTime: '0',
		maxTime: '23:30',
		defaultTime: '11',
		startTime: '0',
		dynamic: false,
		dropdown: true,
		scrollbar: true
	});
}

function getAirlines() {
	var xhttp2 = new XMLHttpRequest();
	xhttp2.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			setAirlines(this.responseText);
		}
	};
	xhttp2.open("GET", "http://localhost:8080/proyectoJS/webresources/find/airlines", true);
	xhttp2.send();
}

function setAirlines(data) {
	var airlines = data.split("_");
	for (var i = 0; i < airlines.length; i++) {
		$('#airlines').append($('<option>', {
			value: airlines[i],
			text: airlines[i]
		}))
	}
	$('option').mousedown(function(e) {
		e.preventDefault();
		$(this).prop('selected', !$(this).prop('selected'));
		return false;
	});
}

function setButton() {
	$("#startFind").submit(function() {
		event.preventDefault();
		var findParams = JSON.stringify({
			price: $("#slider").slider("value"),
			departure: ($("#departure").val() + "00").replace(/:|\s/gi, ""),
			arrive: ($("#arrive").val() + "00").replace(/:|\s/gi, ""),
			airlines: $("#airlines").val()
		});
		$.ajax({
			url: "http://localhost:8080/proyectoJS/webresources/find",
			type: "POST",
			contentType: 'application/json',
			data: findParams,
			dataType: "json"
		});
	})
}
