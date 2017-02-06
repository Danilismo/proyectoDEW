/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.proyectojs.services.rest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author danil
 */
@Path("language")
public class JsonFileSelector {

    private final Logger logger = LoggerFactory.getLogger(FindFlight.class);

    @javax.ws.rs.core.Context
    ServletContext context;

    @GET
    @Path("{language}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLanguage(@PathParam("language") String language) throws FileNotFoundException, IOException {
        logger.info("JsonFileSelector_getLanguage()");
        
        logger.debug("context != null {}", context != null);
        
        String webAppPath = context.getRealPath("/");
        logger.debug(webAppPath + "/languages/messages_" + language + ".json");
        
        
        FileInputStream file = new FileInputStream(webAppPath + "/languages/messages_" + language + ".json");
        InputStreamReader isr = new InputStreamReader(file, "utf-8");
        String fileString = "";
        BufferedReader b = new BufferedReader(isr);
        String cadena;
        while((cadena = b.readLine())!=null) {
            fileString += cadena;
        }
        b.close();
  
        logger.debug(fileString);
        return fileString;
    }
}
