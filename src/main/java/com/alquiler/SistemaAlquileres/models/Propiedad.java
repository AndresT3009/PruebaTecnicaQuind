package com.alquiler.SistemaAlquileres.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "propiedades")
public class Propiedad {

    @Id
    private String nombrePropiedad;
    private String ubicacionPropiedad;
    private boolean propiedadDisponible;
    private String urlPropiedad;
    private Integer precioPropiedad;

    public Propiedad() {

    }

    public Propiedad(String nombrePropiedad, String ubicacionPropiedad, boolean propiedadDisponible, String urlPropiedad, Integer precioPropiedad) {
        //this.id = id;
        this.nombrePropiedad = nombrePropiedad;
        this.ubicacionPropiedad = ubicacionPropiedad;
        this.propiedadDisponible = propiedadDisponible;
        this.urlPropiedad = urlPropiedad;
        this.precioPropiedad = precioPropiedad;
    }

    public String getNombrePropiedad() {
        return nombrePropiedad;
    }

    public void setNombrePropiedad(String nombrePropiedad) {
        this.nombrePropiedad = nombrePropiedad;
    }

    public String getUbicacionPropiedad() {
        return ubicacionPropiedad;
    }

    public void setUbicacionPropiedad(String ubicacionPropiedad) {
        this.ubicacionPropiedad = ubicacionPropiedad;
    }

    public boolean isPropiedadDisponible() {
        return propiedadDisponible;
    }

    public void setPropiedadDisponible(boolean propiedadDisponible) {
        this.propiedadDisponible = propiedadDisponible;
    }

    public String getUrlPropiedad() {
        return urlPropiedad;
    }

    public void setUrlPropiedad(String urlPropiedad) {
        this.urlPropiedad = urlPropiedad;
    }

    public Integer getPrecioPropiedad() {
        return precioPropiedad;
    }

    public void setPrecioPropiedad(Integer precioPropiedad) {
        this.precioPropiedad = precioPropiedad;
    }

    @Override
    public String toString() {
        return "{" +
                /*"id=" + id +*/
                ", nombrePropiedad='" + nombrePropiedad + '\'' +
                ", ubicacionPropiedad='" + ubicacionPropiedad + '\'' +
                ", propiedadDisponible=" + propiedadDisponible +
                ", urlPropiedad='" + urlPropiedad + '\'' +
                ", precioPropiedad=" + precioPropiedad +
                '}';
    }
}
