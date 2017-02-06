/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.proyectojs.services.rest;

import es.cifpcm.proyectojs.dao.DaoFactory;
import es.cifpcm.proyectojs.pojo.DateParams;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author danil
 */
@Path("consultDate")
public class ConsultDate {
    
    private final Logger logger = LoggerFactory.getLogger(FindFlight.class);
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getDate(DateParams dateParams) {
        logger.debug("GetDate");
        return DaoFactory.getInstance().getInsertReservationDao().getSeats(dateParams);
    }
    
}
