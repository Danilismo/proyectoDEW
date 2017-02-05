/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.proyectojs.pojo;

/**
 *
 * @author danil
 */
public class Reservation {
    
    private Integer id_reservation;
    private Integer id_flight;
    private String name;
    private String surname;
    private Integer telf;
    private Integer card;
    private Float amount;

    public Reservation() {
    }

    public Reservation(Integer id_flight, String name, String surname, Integer telf, Integer card, Float amount) {
        this.id_flight = id_flight;
        this.name = name;
        this.surname = surname;
        this.telf = telf;
        this.card = card;
        this.amount = amount;
    }

    public Integer getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Integer id_reservation) {
        this.id_reservation = id_reservation;
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

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
