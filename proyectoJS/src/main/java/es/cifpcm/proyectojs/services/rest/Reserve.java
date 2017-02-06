package es.cifpcm.proyectojs.services.rest;

import es.cifpcm.proyectojs.dao.DaoFactory;
import es.cifpcm.proyectojs.interfaces.InsertReservationDao;
import es.cifpcm.proyectojs.pojo.DateParams;
import es.cifpcm.proyectojs.pojo.Reservation;
import java.math.BigInteger;
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

    //Recibiendo un nVuelo y una fecha por parte del cliente, devuelve el estado de los asientos (en el caso de que no exista ese nVuelo+Fecha, los devuelve aleatoriamente)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getDate(DateParams dateParams) {
        logger.debug("GetDate");
        return DaoFactory.getInstance().getInsertReservationDao().getSeats(dateParams);
    }

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
