package es.cifpcm.proyectojs.interfaces;

import es.cifpcm.proyectojs.pojo.DateParams;
import es.cifpcm.proyectojs.pojo.Reservation;

public interface InsertReservationDao {
    String getSeats(DateParams dateParams);
    boolean set(Reservation reservation);
    boolean validate(Reservation reservation);
}
