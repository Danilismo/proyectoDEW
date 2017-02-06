package es.cifpcm.proyectojs.pojo;

import java.math.BigInteger;
import java.sql.Date;

public class Reservation {
    
    private Integer id_flight;
    private String name;
    private String surname;
    private Integer telf;
    private BigInteger card;
    private Float amount;
    private String seats_status;
    private Date date;

    public Reservation() {
    }

    public Reservation(Integer id_flight, String name, String surname, Integer telf, BigInteger card, Float amount, String seats_status, Date date) {
        this.id_flight = id_flight;
        this.name = name;
        this.surname = surname;
        this.telf = telf;
        this.card = card;
        this.amount = amount;
        this.seats_status = seats_status;
        this.date = date;
    }

    public Integer getId_flight() {
        return id_flight;
    }

    public void setId_flight(Integer id_flight) {
        this.id_flight = id_flight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getTelf() {
        return telf;
    }

    public void setTelf(Integer telf) {
        this.telf = telf;
    }

    public BigInteger getCard() {
        return card;
    }

    public void setCard(BigInteger card) {
        this.card = card;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getSeats_status() {
        return seats_status;
    }

    public void setSeats_status(String seats_status) {
        this.seats_status = seats_status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
