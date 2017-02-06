function languageSelection(idioma)
{
	this.connection;
	this.messages;
        this.language = idioma;
}

languageSelection.prototype = {

    setLanguage : function(language)
    {
        this.language = language;
    },
    
    getLanguage : function()
    {
        return this.language;
    },
    
    makeConnection : function()
    {
	this.connection = new XMLHttpRequest();
        console.log(this.language);
	var that = this;
  	this.connection.onreadystatechange = 
        function() 
        { 
            that.checkConnection(that.connection); 
        };
  	this.connection.open("GET", "webresources/language/" + this.language , true);
  	this.connection.send();
    },

    checkConnection : function(connection)
    {
	if(connection.readyState == 4)
	{             
            this.messages = JSON.parse(connection.responseText);
	}
    },
    
    fillOutputs : function()
    {
        $(".formFlight").text(this.messages["formFlight"]);
        $(".formOriginAirport").text(this.messages["formOriginAirport"]);
        $(".formDepartureHour").text(this.messages["formDepartureHour"]);
        $(".formAirline").text(this.messages["formAirline"]);
        $(".formDestinationAirport").text(this.messages["formDestinationAirport"]);
        $(".formArrivalHour").text(this.messages["formArrivalHour"]);
        $(".formPrice").text(this.messages["formPrice"]);
    }
};

$(document).ready(function() {
    
    var navigatorLanguage = window.navigator.language.substring(0,2);
    if (navigatorLanguage != "es" && navigatorLanguage != "fr" && navigatorLanguage != "en")
    {
        navigatorLanguage = "en";
    }
    
    languageSelector = new languageSelection(navigatorLanguage);
    languageSelector.makeConnection();
});