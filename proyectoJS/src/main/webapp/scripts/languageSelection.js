function languageSelection(idioma)
{
	var connection;
	var messages;
        var language = idioma;
}



languageSelection.prototype = {

    makeConnection : function()
    {
	this.connection = new XMLHttpRequest();
	var that = this;
  	this.connection.onreadystatechange = 
        function() 
        { 
            that.checkConnection(that.connection); 
        };
        console.log("languages/messages_" + that.language + ".json");
  	this.connection.open("GET", "webresources/language", true);
        
  	this.connection.send();
    },

    checkConnection : function(connection)
    {
	if(connection.readyState == 4)
	{             
            console.log(connection.responseText);
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
}

$(document).ready(function() {

    languageSelector = new languageSelection(window.navigator.language);
    languageSelector.makeConnection();
});