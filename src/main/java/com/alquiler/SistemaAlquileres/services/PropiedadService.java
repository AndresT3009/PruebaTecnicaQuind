package com.alquiler.SistemaAlquileres.services;

import com.alquiler.SistemaAlquileres.models.Propiedad;
import java.util.List;

public interface PropiedadService {

    void guardarPropiedad(Propiedad propiedad);

    List<Propiedad> obtenerPropiedades();

    List<Propiedad> encontrarPorPrecio(int precioMinimo, int precioMaximo);
    Propiedad buscarPorNombre(String nombrePropiedad);

    void actualizarPropiedad(Propiedad propiedad);

    Propiedad eliminarPropiedad(String nombrePropiedad);
}
