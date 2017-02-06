package es.cifpcm.proyectojs.pojo;

import java.io.Serializable;
import java.sql.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DateParams implements Serializable {
    private Integer nVuelo;
    private Date fecha;

    public DateParams() {
    }

    public DateParams(Integer nVuelo, Date fecha) {
        this.nVuelo = nVuelo;
        this.fecha = fecha;
    }

    public Integer getnVuelo() {
        return nVuelo;
    }

    public void setnVuelo(Integer nVuelo) {
        this.nVuelo = nVuelo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
