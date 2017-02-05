/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.proyectojs.dao;

import es.cifpcm.proyectojs.interfaces.ConnectionProvider;
import es.cifpcm.proyectojs.interfaces.InsertReservationDao;
import es.cifpcm.proyectojs.pojo.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.LoggerFactory;

/**
 *
 * @author danil
 */
public class MySqlInsertReservationDao implements InsertReservationDao{
    
    private final ConnectionProvider CON_PRO;
    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DaoFactory.class);

    MySqlInsertReservationDao(ConnectionProvider conPro) {
        this.CON_PRO = conPro;
    }

    @Override
    public boolean set(Reservation reservation) {
        
        boolean answer = false;
        Connection conexion = CON_PRO.getConnection();
        try 
        {
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
            answer = (affectedRows > 0);
        }
        catch (SQLException ex) 
        {
            LOGGER.error("No se a podido realizar la consulta", ex);
        }
        finally
        {
            if (conexion != null) 
            {
                try 
                {
                    conexion.close();
                } 
                catch (SQLException ex) 
                {
                    LOGGER.error("No se a podido cerrar la conexión", ex);
                }
            }
        }
        return answer;
    }  
    
    @Override
    public boolean validate(Reservation reservation)
    {
        boolean answer = true;
        
        if (reservation.getId_flight() <= 0)
        {
            answer = false;
        }
        else if (reservation.getName() == "" || reservation.getName() == null)
        {
            answer = false;
        }
        else if (reservation.getSurname() == "" || reservation.getSurname() == null)
        {
            answer = false;
        }
        else if (reservation.getTelf() == null || reservation.getTelf() <= 0 || reservation.getTelf().toString().length() != 9)
        {
            answer = false;
        }
        else if (reservation.getCard() == null || reservation.getCard().toString().length() < 13 || reservation.getCard().toString().length() > 16)
        {
            answer = false;
        }
        else if (reservation.getAmount() == null || reservation.getAmount() <= 0)
        {
            answer = false;
        }
        return answer;
    }
}
