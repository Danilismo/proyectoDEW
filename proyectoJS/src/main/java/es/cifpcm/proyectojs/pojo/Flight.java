package es.cifpcm.proyectojs.pojo;

import java.sql.Time;

public class Flight {
    
    private Integer number;
    private String originAirport;
    private String originCity;
    private String originCountry;
    private Time departure;
    private String destinationAirport;
    private String destinationCity;
    private String destinationCountry;
    private Time arrive;
    private Float price;
    private Integer capacity;
    private String airline;

    public Flight() {
    }

    public Flight(Integer number, String originAirport, String originCity, String originCountry, Time departure, String destinationAirport, String destinationCity, String destinationCountry, Time arrive, Float price, Integer capacity, String airline) {
        this.number = number;
        this.originAirport = originAirport;
        this.originCity = originCity;
        this.originCountry = originCountry;
        this.departure = departure;
        this.destinationAirport = destinationAirport;
        this.destinationCity = destinationCity;
        this.destinationCountry = destinationCountry;
        this.arrive = arrive;
        this.price = price;
        this.capacity = capacity;
        this.airline = airline;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public Time getDeparture() {
        return departure;
    }

    public void setDeparture(Time departure) {
        this.departure = departure;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public Time getArrive() {
        return arrive;
    }

    public void setArrive(Time arrive) {
        this.arrive = arrive;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
