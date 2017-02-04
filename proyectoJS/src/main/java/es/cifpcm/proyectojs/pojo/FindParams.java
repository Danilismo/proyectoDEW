package es.cifpcm.proyectojs.pojo;

import java.util.List;

public class FindParams {
    private Integer price;
    private String departure;
    private String arrive;
    private List<String> airlines;

    public FindParams(Integer price, String departure, String arrive, List<String> airlines) {
        this.price = price;
        this.departure = departure;
        this.arrive = arrive;
        this.airlines = airlines;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public List<String> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<String> airlines) {
        this.airlines = airlines;
    }
}
