

var numero = "011010101010111101010000011001100001";
var nButacas = 0;
var precioVuelo;

function openModal(that)
{
    nButacas = 0;
    precioVuelo = $(that).closest(".vuelo").find(".Precio").text();
    $("#modal").slideToggle();
    $("#modal").css("display", "flex");
    var x = 15;
    var y = -50;
    var contador = 0;
    var mapaButacas = document.getElementById("aButacas");
    for (var i = 0; i < numero.length; i++, contador++)
    {
        if (contador == 2)
        {
            contador = -3;
            i--;
        } else
        {
            mapaButacas.innerHTML += " <use xlink:href='#butaca" + numero[i] + "' class='butaca' x='" + x + "' y='" + y + "' width='30px' height='30px' />";
        }
        x = x + 35;
        if (x > 160)
        {
            y = y + 35;
            x = 15;
        }
    }
    $("use").on("click", color);
    function color()
    {
        if ($(this).attr("xlink:href") == "#butaca0")
        {
            $(this).attr("xlink:href", "#butaca2");
            nButacas++;
        } else if ($(this).attr("xlink:href") == "#butaca2")
        {
            $(this).attr("xlink:href", "#butaca0");
            nButacas--;
        }
        $("#nButacas").text(nButacas);
        $("#pTotal").text(parseInt(precioVuelo) * nButacas + "€")
    }
}

jQuery(document).ready(function () {
    //Boton Para abrir el menú de busqueda.
    $("#ButtonSearch").on("click", function () {
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
    xhttp.onreadystatechange = function () {
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
        slide: function (event, ui) {
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
    xhttp2.onreadystatechange = function () {
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
    $('option').mousedown(function (e) {
        e.preventDefault();
        $(this).prop('selected', !$(this).prop('selected'));
        return false;
    });
}

function setButton() {
    $("#startFind").submit(function () {
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
            dataType: "json",
            success: function (data) {
                $("#section").empty();
                for (var i = 0; i < data.length; i++) {
                    $("#section").append(new aFlight(data[i]));
                }
            }
        });
    })
}

function aFlight(data) {
    return $("<div class='vuelo'></div>").append($("<table></table>").append($("<tr></tr>").append($("<td rowspan='2'><div id='formFlight'></div> " + data.number + "</td>")).append($("<td><div id='formOriginAirport'></div> " + data.originAirport + ", " + data.originCity + "</td>")).append($("<td><div id='formDepartureHour'></div> " + data.departure + "</td>")).append($("<td>" + data.airline + "</td>"))).append($("<tr></tr>").append($("<td><div id='formDestinationAirport'></div> " + data.destinationAirport + ", " + data.destinationCity + "</td>")).append($("<td><div id='formArrivalHour'></div> " + data.arrive + "</td>")).append($("<td><div id='formPrice'></div> " + data.price + " €</td>"))));
}