package com.alquiler.SistemaAlquileres.controllers;

import com.alquiler.SistemaAlquileres.models.Propiedad;
import com.alquiler.SistemaAlquileres.services.PropiedadService;
import com.alquiler.SistemaAlquileres.services.implementations.PropiedadServiceImplementation;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;


    @GetMapping("/propiedades")
    public List<Propiedad> obtenerPropiedades(){
        List<Propiedad> listaPropiedades = new ArrayList<>();
        Propiedad propiedad = new Propiedad();
        propiedad.setNombrePropiedad("Nature Rio");
        propiedad.setPrecioPropiedad(2500000);
        propiedad.setUbicacionPropiedad("Sabaneta");
        propiedad.setUrlPropiedad("xxx");
        propiedad.setPropiedadDisponible(true);

        listaPropiedades.add(propiedad);

        return listaPropiedades;
    }

    private boolean esUbicacionPermitida(String ubicacion) {
        List<String> ciudadesPermitidas = Arrays.asList("Bogotá", "Medellín", "Cali", "Cartagena");
        String ubicacionMinusculas = ubicacion.toLowerCase(); // Convertir a minúsculas
        return ciudadesPermitidas.stream()
                .anyMatch(ciudad -> ciudad.toLowerCase().equals(ubicacionMinusculas)); // Comparar ignorando el caso
    }

    @PostMapping("/Propiedades")
    public ResponseEntity<Object> guardarNuevaPropiedad(@RequestParam String nombrePropiedad,@RequestParam String ubicacionPropiedad,
                                                   @RequestParam boolean propiedadDisponible, @RequestParam String urlPropiedad,
                                                   @RequestParam int precioPropiedad){
        if(nombrePropiedad.isEmpty()){
            return new ResponseEntity<>("El nombre de la propiedad no puede estar vacío", HttpStatus.FORBIDDEN);
        }if(ubicacionPropiedad.isEmpty() || !esUbicacionPermitida(ubicacionPropiedad)){
            return new ResponseEntity<>("La ubicación de la propiedad no corresponde a las ciudades permitidas",HttpStatus.FORBIDDEN);
        }if(urlPropiedad.isEmpty()){
            return new ResponseEntity<>("url de la propiedad no puede estar vacío",HttpStatus.FORBIDDEN);
        }
        Propiedad nuevaPropiedad = new Propiedad(nombrePropiedad,ubicacionPropiedad,propiedadDisponible,urlPropiedad,precioPropiedad);
        System.out.println(nuevaPropiedad);
        propiedadService.guardarPropiedad(nuevaPropiedad);
        return new ResponseEntity<>("Propiedad Registrada",HttpStatus.CREATED);
    }
}
