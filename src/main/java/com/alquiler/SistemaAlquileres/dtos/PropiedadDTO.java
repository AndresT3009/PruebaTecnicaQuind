package com.alquiler.SistemaAlquileres.dtos;

import com.alquiler.SistemaAlquileres.models.Propiedad;

public class PropiedadDTO {
    private long id;
    private String nombrePropiedad;
    private String ubicacionPropiedad;
    private boolean propiedadDisponible;
    private String urlPropiedad;
    private Integer precioPropiedad;

    public PropiedadDTO() {
    }

    public PropiedadDTO(Propiedad propiedad) {
        this.nombrePropiedad = propiedad.getNombrePropiedad();
        this.ubicacionPropiedad = propiedad.getUbicacionPropiedad();
        this.propiedadDisponible = propiedad.isPropiedadDisponible();
        this.urlPropiedad = propiedad.getUrlPropiedad();
        this.precioPropiedad = propiedad.getPrecioPropiedad();
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
                "nombrePropiedad='" + nombrePropiedad + '\'' +
                ", ubicacionPropiedad='" + ubicacionPropiedad + '\'' +
                ", propiedadDisponible=" + propiedadDisponible +
                ", urlPropiedad='" + urlPropiedad + '\'' +
                ", precioPropiedad=" + precioPropiedad +
                '}';
    }


}
