package es.cifpcm.proyectojs.dao;

import es.cifpcm.proyectojs.interfaces.ConnectionProvider;
import es.cifpcm.proyectojs.interfaces.FlightDao;
import es.cifpcm.proyectojs.pojo.Flight;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;

public class MySqlFlightDao implements FlightDao {

    private final ConnectionProvider CON_PRO;
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(DaoFactory.class);

    MySqlFlightDao(ConnectionProvider conPro) {
        this.CON_PRO = conPro;
    }

    @Override
    public List<Flight> select(Integer price, String departure, String arrive, List<String> airlines) {
        try (Connection connection = CON_PRO.getConnection()) {
            PreparedStatement s;
            String query;
            if (airlines == null) {
                query = "SELECT * FROM buscarVuelos WHERE precio <= ? AND horaSalida <= ? AND horaLlegada <= ?";
                s = connection.prepareCall(query);
                s.setInt(1, price);
                s.setString(2, departure);
                s.setString(3, arrive);
            } else {
                query = "SELECT * FROM buscarVuelos WHERE precio <= ? AND horaSalida <= ? AND horaLlegada <= ? AND Aerolínea IN (?)";
                s = connection.prepareCall(query);
                //MYSQL no admite Array, toca arreglarlo con bucles
                Array array = connection.createArrayOf("VARCHAR", airlines.toArray());
                s.setInt(1, price);
                s.setString(2, departure);
                s.setString(3, arrive);
                s.setArray(4, array);
            }
            ResultSet rs = s.executeQuery(query);
            List<Flight> list = new ArrayList<>();
            while (rs.next()){
                Flight thisOne = new Flight(rs.getInt("nVuelo"), rs.getString("Aeropuerto de Origen"), rs.getString("Ciudad de Origen"), rs.getString("País de Origen"), rs.getTimestamp("horaSalida"), rs.getString("Aeropuerto de Destino"), rs.getString("Ciudad de Destino"), rs.getString("País de Destino"), rs.getTimestamp("horaDestino"), rs.getFloat("precio"), rs.getInt("capacidad"), rs.getString("Aerolínea"));
                list.add(thisOne);
            }
            return list;
        } catch (SQLException ex) {
            logger.error("select", ex);
            return null;
        }
    }

}
