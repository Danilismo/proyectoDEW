package es.cifpcm.proyectojs.services.rest;

import es.cifpcm.proyectojs.dao.DaoFactory;
import es.cifpcm.proyectojs.pojo.Flight;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("find")
public class FindFlight {
    
    private final Logger logger = LoggerFactory.getLogger(FindFlight.class);
    
    @GET
    @Path("/{price}/{departure}/{arrive}/{airlines}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Flight> read(@PathParam("price") Integer price,
            @PathParam("departure") String departure,
            @PathParam("arrive") String arrive,
            @PathParam("airlines") List<String> airlines){
        logger.info("FindFlight_read()");
        return DaoFactory.getInstance().getFlightDao().select(price, departure, arrive, airlines);
    }
}
