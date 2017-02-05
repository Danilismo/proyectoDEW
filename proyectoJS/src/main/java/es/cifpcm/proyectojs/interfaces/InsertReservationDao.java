/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.proyectojs.interfaces;

import es.cifpcm.proyectojs.pojo.Reservation;

/**
 *
 * @author danil
 */
public interface InsertReservationDao {
    boolean set(Reservation reservation);
}
