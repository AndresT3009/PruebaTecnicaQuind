package com.alquiler.SistemaAlquileres.services.implementations;

import com.alquiler.SistemaAlquileres.models.Propiedad;
import com.alquiler.SistemaAlquileres.repositories.PropiedadRepository;
import com.alquiler.SistemaAlquileres.services.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropiedadServiceImplementation implements PropiedadService {

    @Autowired
    PropiedadRepository propiedadRepository;

    @Override
    public void guardarPropiedad(Propiedad propiedad){
        propiedadRepository.save(propiedad);

    }

}
