package es.cifpcm.proyectojs.interfaces;

public interface ConnectionProvider {
    
    java.sql.Connection getConnection();
    void closeConnection(java.sql.Connection conexion);
}
