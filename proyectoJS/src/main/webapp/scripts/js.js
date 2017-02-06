

var numero = "";
var nButacas = 0;
var precioVuelo;
var reservas=0;
var vueloactual;

function openDialog(that)
{
     vueloactual = $(that).closest(".vuelo");
     precioVuelo = vueloactual.find(".Precio").text();
     $( function() {
          $( "#dialog" ).dialog();
     } );
     $( function() {
          $( "#datepicker" ).datepicker();
          $( "#datepicker" ).datepicker( "option", "dateFormat","yy-mm-dd");
     });
}
function openModal()
{
    takeDate();
    setTimeout(print,2000);
    
}
function print()
{
    nButacas = 0;
    $("#modal").slideToggle();
    $("#dialog").dialog('close');
    $("#modal").css("display", "flex");
    var x = 15;
    var y = -50;
    var contador = 0;
    var mapaButacas = document.getElementById("aButacas");
    mapaButacas.innerHTML = "";
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
    var bigInt = creaBigInt();
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
    
function creaBigInt()
 {
      var listaUses = $("#aButacas").children("use");
      var bigInt = "";

      for(var i = 0;i < listaUses.length;i++)
      {
           if($(listaUses[i]).attr("xlink:href")== "#butaca0")
           {
                bigInt += "0";
           }
           else if ($(listaUses[i]).attr("xlink:href")== "#butaca1")
           {
                bigInt += "1";
           }
           else if($(listaUses[i]).attr("xlink:href")== "#butaca2")
           {
                bigInt += "1";
                reservas++;
           }
      }
      return bigInt;
 }
 function closeModal()
{
     $("#modal").slideToggle();
}
function takeDate() {
        var findParams = JSON.stringify({
            nVuelo: $(vueloactual).find(".formFlight").parent().text().split(" ")[1],
            fecha: $("#datepicker").val()
        });
        $.ajax({
            url: "http://localhost:8080/proyectoJS/webresources/consultDate",
            type: "POST",
            contentType: 'application/json',
            data: findParams,
            dataType: "json",
            success: function (data) {
                numero = data.toString();
                console.log(numero);
            }
        });
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
                languageSelector.fillOutputs();
            }
        });
    })
}

function aFlight(data) {
    return $("<div class='vuelo'></div>").append($("<table></table>").append($("<tr></tr>").append($("<td rowspan='2'><div class='formFlight'></div> " + data.number + "</td>")).append($("<td><div class='formOriginAirport'></div> " + data.originAirport + ", " + data.originCity + "</td>")).append($("<td><div class='formDepartureHour'></div> " + data.departure + "</td>")).append($("<td><div class ='formAirline'></div>" + data.airline + "</td>")).append($("<td rowspan='2'><input type='button' onclick='openDialog(this)' value='Comprar'></td></td>"))).append($("<tr></tr>").append($("<td><div class='formDestinationAirport'></div> " + data.destinationAirport + ", " + data.destinationCity + "</td>")).append($("<td><div class='formArrivalHour'></div> " + data.arrive + "</td>")).append($("<td><div class='formPrice'></div> " + data.price + " €</td>"))));
}