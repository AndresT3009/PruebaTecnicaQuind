package com.alquiler.SistemaAlquileres.services.implementations;

import com.alquiler.SistemaAlquileres.models.Propiedad;
import com.alquiler.SistemaAlquileres.repositories.PropiedadRepository;
import com.alquiler.SistemaAlquileres.services.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PropiedadServiceImplementation implements PropiedadService {

    @Autowired
    PropiedadRepository propiedadRepository;

    @Override
    public void guardarPropiedad(Propiedad propiedad){
        propiedadRepository.save(propiedad);
    }

    @Override
    public List<Propiedad> obtenerPropiedades(){
        return propiedadRepository.findAll();
    }

    public List <Propiedad> encontrarPorPrecio(int precioMinimo, int precioMáximo){
        return propiedadRepository.encontrarPorPrecio(precioMinimo,precioMáximo);
    }

    @Override
    public Propiedad buscarPorNombre(String nombrePropiedad){
        return propiedadRepository.findByNombrePropiedad(nombrePropiedad);
    }

    public void actualizarPropiedad(Propiedad propiedad){
        propiedadRepository.save(propiedad);
    }

    public Propiedad eliminarPropiedad(String nombrePropiedad){
        return propiedadRepository.deleteByNombrePropiedad(nombrePropiedad);
    }
}
