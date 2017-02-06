package es.cifpcm.proyectojs.services.rest;

import es.cifpcm.proyectojs.dao.DaoFactory;
import es.cifpcm.proyectojs.interfaces.InsertReservationDao;
import es.cifpcm.proyectojs.pojo.Reservation;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("reserve")
public class Reserve {

    private final Logger logger = LoggerFactory.getLogger(FindFlight.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean insert(Reservation reservation) {
        logger.debug("Reserve_insert()");
        boolean answer = false;
        InsertReservationDao insertReservation = DaoFactory.getInstance().getInsertReservationDao();
        if (insertReservation.validate(reservation)) {
            answer = insertReservation.set(reservation);
        }
        return answer;
    }

}
