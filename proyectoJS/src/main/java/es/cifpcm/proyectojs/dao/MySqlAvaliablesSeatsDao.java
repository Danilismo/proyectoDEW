/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.proyectojs.dao;

import es.cifpcm.proyectojs.interfaces.AvaliablesSeatsDao;
import es.cifpcm.proyectojs.interfaces.ConnectionProvider;
import es.cifpcm.proyectojs.pojo.AvaliablesSeats;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.LoggerFactory;

/**
 *
 * @author danil
 */
public class MySqlAvaliablesSeatsDao implements AvaliablesSeatsDao{
    
    private final ConnectionProvider CON_PRO;
    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DaoFactory.class);

    MySqlAvaliablesSeatsDao(ConnectionProvider conPro) {
        this.CON_PRO = conPro;
    }

    @Override
    public AvaliablesSeats getFlight(Integer id_genericFlight, Date flightDate) {
        
        AvaliablesSeats answer = new AvaliablesSeats();
        try (Connection conexion = CON_PRO.getConnection())
        {
            String query = "select (id_vuelo, plazas_libres, estado_plazas)"
                + "from vuelo where id_vueloGenerico = ? and fecha = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id_genericFlight);
            ps.setDate(2, flightDate);
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                answer.setId_flight(rs.getInt("id_vuelo"));
                answer.setAvaliables_seats(rs.getInt("plazas_libres")); 
                answer.setSeats_status(BigInteger.valueOf(rs.getLong("estado_plazas")));
            }
        }
        catch (SQLException ex) 
        {
            LOGGER.error("No se a podido realizar la consulta", ex);
        }
        return answer;
    }

    @Override
    public boolean setFlight(AvaliablesSeats flight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
