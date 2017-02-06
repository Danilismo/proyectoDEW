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
            console.log(JSON.parse(connection.responseText));
            this.messages = JSON.parse(connection.responseText);
            this.fillOutputs();
	}
    },
    
    fillOutputs : function()
    {
        $("#indexWelcome").text(this.messages["indexWelcome"]);
        $("#indexSubWelcome").text(this.messages["indexSubWelcome"]);
        $("#menuTitle").text(this.messages["menuTitle"]);
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