/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.proyectojs.pojo;

import java.math.BigInteger;
import java.sql.Date;

/**
 *
 * @author danil
 */
public class AvaliablesSeats {
    private Integer id_flight;
    private Integer id_genericFlight;
    private Date flightDate;
    private Integer avaliables_seats;
    private BigInteger seats_status;

    public AvaliablesSeats() {
    }

    public AvaliablesSeats(Integer id_genericFlight, Date flightDate, Integer avaliables_seats, BigInteger seats_status) {
        this.id_genericFlight = id_genericFlight;
        this.flightDate = flightDate;
        this.avaliables_seats = avaliables_seats;
        this.seats_status = seats_status;
    }

    public AvaliablesSeats(Integer id_flight, Integer avaliables_seats, BigInteger seats_status) {
        this.id_flight = id_flight;
        this.avaliables_seats = avaliables_seats;
        this.seats_status = seats_status;
    }

    public Integer getId_flight() {
        return id_flight;
    }

    public void setId_flight(Integer id_flight) {
        this.id_flight = id_flight;
    }

    public Integer getId_genericFlight() {
        return id_genericFlight;
    }

    public void setId_genericFlight(Integer id_genericFlight) {
        this.id_genericFlight = id_genericFlight;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Integer getAvaliables_seats() {
        return avaliables_seats;
    }

    public void setAvaliables_seats(Integer avaliables_seats) {
        this.avaliables_seats = avaliables_seats;
    }

    public BigInteger getSeats_status() {
        return seats_status;
    }

    public void setSeats_status(BigInteger seats_status) {
        this.seats_status = seats_status;
    }
}

    
