package es.cifpcm.proyectojs.interfaces;

import es.cifpcm.proyectojs.pojo.Flight;
import java.util.List;

public interface FlightDao {
    List<Flight> select(Integer price, String departure, String arrive, List<String> airlines);
    
}
