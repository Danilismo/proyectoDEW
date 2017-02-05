package es.cifpcm.proyectojs.dao;

import es.cifpcm.proyectojs.interfaces.ConnectionProvider;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoFactory implements ConnectionProvider {

    private static DaoFactory instance;
    private final Logger logger = LoggerFactory.getLogger(DaoFactory.class);
    private InitialContext ctx;
    private DataSource ds;

    private DaoFactory() {
        try {
            this.ctx = new InitialContext();
            this.ds = (DataSource) ctx.lookup("jdbc/flight");
        } catch (NamingException ex) {
            logger.error("init", ex);
        }
    }
    
    public static synchronized DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException ex) {
            logger.error("getConnection", ex);
            return null;
        }
    }

    @Override
    public void closeConnection(Connection conexion) {
        try {
            conexion.close();
        } catch (SQLException ex) {
            logger.error("closeConnection", ex);
        }
    }
    
    public MySqlFlightDao getFlightDao(){
        return new MySqlFlightDao(this);
    }
    
    public MySqlInsertReservationDao getInsertReservationDao() {
        return new MySqlInsertReservationDao(this);
    }
}
