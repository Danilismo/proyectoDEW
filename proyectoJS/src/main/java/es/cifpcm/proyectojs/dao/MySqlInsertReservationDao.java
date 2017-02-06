package es.cifpcm.proyectojs.dao;

import es.cifpcm.proyectojs.interfaces.ConnectionProvider;
import es.cifpcm.proyectojs.interfaces.InsertReservationDao;
import es.cifpcm.proyectojs.pojo.DateParams;
import es.cifpcm.proyectojs.pojo.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;
import org.slf4j.LoggerFactory;

public class MySqlInsertReservationDao implements InsertReservationDao {

    private final ConnectionProvider CON_PRO;
    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DaoFactory.class);

    MySqlInsertReservationDao(ConnectionProvider conPro) {
        this.CON_PRO = conPro;
    }

    @Override
    public boolean set(Reservation reservation) {
        boolean answer = false;
        Connection conexion = CON_PRO.getConnection();
        try {
            String query = "insert into reservas"
                    + "(id_vuelo, nombre, apellidos, telf, tarjeta, importe) "
                    + "values(?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, reservation.getId_flight());
            ps.setString(2, reservation.getName());
            ps.setString(3, reservation.getSurname());
            ps.setInt(4, reservation.getTelf());
            ps.setLong(5, reservation.getCard().longValue());
            ps.setFloat(6, reservation.getAmount());
            Integer affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                String query2 = "REPLACE INTO vuelo SET id_vuelo = ?, fecha = ?, plazas_libres = ?, estado_plazas = ?";
                PreparedStatement s = conexion.prepareStatement(query2);
                s.setInt(1, reservation.getId_flight());
                s.setDate(2, reservation.getDate());
                String seats = reservation.getSeats_status();
                Integer freeSeats = 0;
                for (int i = 0; i < seats.length(); i++) {
                    if (seats.charAt(i) == '0') {
                        freeSeats++;
                    }
                }
                s.setInt(3, freeSeats);
                s.setString(4, reservation.getSeats_status());
                ResultSet rs2 = s.executeQuery();
                if (rs2 != null){
                    answer = true;
                }
            }
        } catch (SQLException ex) {
            LOGGER.error("No se a podido realizar la consulta", ex);
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    LOGGER.error("No se a podido cerrar la conexión", ex);
                }
            }
        }
        return answer;
    }

    @Override
    public boolean validate(Reservation reservation) {
        boolean answer = true;

        if (reservation.getId_flight() <= 0) {
            answer = false;
        } else if (reservation.getName() == "" || reservation.getName() == null) {
            answer = false;
        } else if (reservation.getSurname() == "" || reservation.getSurname() == null) {
            answer = false;
        } else if (reservation.getTelf() == null || reservation.getTelf() <= 0 || reservation.getTelf().toString().length() != 9) {
            answer = false;
        } else if (reservation.getCard() == null || reservation.getCard().toString().length() < 13 || reservation.getCard().toString().length() > 16) {
            answer = false;
        } else if (reservation.getAmount() == null || reservation.getAmount() <= 0) {
            answer = false;
        }
        return answer;
    }

    @Override
    public String getSeats(DateParams dateParams) {
        String toReturn = "";
        try (Connection connection = CON_PRO.getConnection()) {
            String query = "SELECT estado_plazas FROM vuelo WHERE id_vueloGenerico = ? AND fecha = ?";
            PreparedStatement s = connection.prepareStatement(query);
            s.setInt(1, dateParams.getnVuelo());
            s.setDate(2, dateParams.getFecha());
            ResultSet rs = s.executeQuery();
            Integer hola = rs.getRow();
            if (rs.getRow() != 0)
            {
                if (rs.next()) {
                    toReturn = rs.getString("estado_plazas");
                }
            }
            else
            {
                Integer capacidad;
                    String query2 = "SELECT capacidad FROM vueloGenerico WHERE nVuelo = ?";
                    PreparedStatement s2 = connection.prepareStatement(query2);
                    s2.setInt(1, dateParams.getnVuelo());
                    ResultSet rs2 = s2.executeQuery();
                    if (rs2.next()) {
                        capacidad = rs2.getInt("capacidad");
                        toReturn = "";
                        for (int i = 0; i < capacidad; i++) {
                            toReturn += ThreadLocalRandom.current().nextInt(0, 1 + 1);
                        }
                    }
                
            }
            return toReturn;
        } catch (SQLException ex) {
            LOGGER.error("getDate", ex);
            return null;
        }
    }
}
