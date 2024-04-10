package com.alquiler.SistemaAlquileres.controllers;

import com.alquiler.SistemaAlquileres.models.Propiedad;
import com.alquiler.SistemaAlquileres.services.PropiedadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;

    private static final Logger logger = LoggerFactory.getLogger(PropiedadController.class);


    private boolean esUbicacionPermitida(String ubicacion) {
        List<String> ciudadesPermitidas = Arrays.asList("Bogota", "Medellin", "Cali", "Cartagena");
        String ubicacionMinusculas = ubicacion.toLowerCase(); // Convertir a minúsculas
        return ciudadesPermitidas.stream()
                .anyMatch(ciudad -> ciudad.toLowerCase().equals(ubicacionMinusculas)); // Comparar ignorando el caso
    }

    @RequestMapping("/propiedades")
    public List<Propiedad>obtenerPropiedad(){
        return propiedadService.obtenerPropiedades();
    }

    @PostMapping("/propiedades")
    public ResponseEntity<Object> guardarNuevaPropiedad(@RequestParam String nombrePropiedad,@RequestParam String ubicacionPropiedad,
                                                   @RequestParam boolean propiedadDisponible, @RequestParam String urlPropiedad,
                                                   @RequestParam int precioPropiedad) {
        try {
            if (nombrePropiedad.isEmpty()) {
                return new ResponseEntity<>("El nombre de la propiedad no puede estar vacío", HttpStatus.FORBIDDEN);
            }
            if (ubicacionPropiedad.isEmpty() || !esUbicacionPermitida(ubicacionPropiedad)) {
                return new ResponseEntity<>("La ubicación de la propiedad no corresponde a las ciudades permitidas", HttpStatus.FORBIDDEN);
            }
            if (urlPropiedad.isEmpty()) {
                return new ResponseEntity<>("url de la propiedad no puede estar vacío", HttpStatus.FORBIDDEN);
            }

            Propiedad propiedadExistente = propiedadService.buscarPorNombre(nombrePropiedad);
            if (propiedadExistente != null) {
                return new ResponseEntity<>("La propiedad ya está registrada", HttpStatus.BAD_REQUEST);
            }
            Propiedad nuevaPropiedad = new Propiedad(nombrePropiedad, ubicacionPropiedad, propiedadDisponible, urlPropiedad, precioPropiedad);
            propiedadService.guardarPropiedad(nuevaPropiedad);
            return new ResponseEntity<>("Propiedad Registrada", HttpStatus.CREATED);
        }catch (Exception exception){
            throw new RuntimeException();
        }
    }

    @PutMapping("/propiedades")
    public ResponseEntity<Object> actualizarPropiedad(@RequestBody Propiedad propiedad){
        if(esUbicacionPermitida(propiedad.getUbicacionPropiedad())) {
            propiedadService.actualizarPropiedad(propiedad);
            return ResponseEntity.ok("Propiedad actualizada exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No se puede cambiar a la ciudad deseada");
        }
    }

    @DeleteMapping("/propiedades/{nombrePropiedad}")
    public ResponseEntity<String> eliminarPropiedadPorNombre(@PathVariable String nombrePropiedad) {
        try {
            Propiedad propiedad = propiedadService.buscarPorNombre(nombrePropiedad);
            if (propiedad == null) {
                return new ResponseEntity<>("La propiedad no existe", HttpStatus.NOT_FOUND);
            }
            propiedadService.eliminarPropiedad(propiedad.getNombrePropiedad());
            return new ResponseEntity<>("Propiedad eliminada correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la propiedad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
