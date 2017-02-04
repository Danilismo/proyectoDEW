package es.cifpcm.proyectojs.services.rest;

import es.cifpcm.proyectojs.dao.DaoFactory;
import es.cifpcm.proyectojs.pojo.FindParams;
import es.cifpcm.proyectojs.pojo.Flight;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("find")
public class FindFlight {
    
    private final Logger logger = LoggerFactory.getLogger(FindFlight.class);
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Flight> read(FindParams findParams){
        logger.debug("Find");
        return DaoFactory.getInstance().getFlightDao().select(findParams.getPrice(), findParams.getDeparture(), findParams.getArrive(), findParams.getAirlines());
    }
}
