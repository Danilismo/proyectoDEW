/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.proyectojs.interfaces;

import es.cifpcm.proyectojs.pojo.AvaliablesSeats;
import java.sql.Date;

/**
 *
 * @author danil
 */
public interface AvaliablesSeatsDao {
    
    AvaliablesSeats getFlight(Integer id_vueloGenerico, Date fecha);
    boolean setFlight(AvaliablesSeats flight);
}
