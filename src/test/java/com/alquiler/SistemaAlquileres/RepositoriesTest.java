package com.alquiler.SistemaAlquileres;

import com.alquiler.SistemaAlquileres.controllers.PropiedadController;
import com.alquiler.SistemaAlquileres.models.Propiedad;
import com.alquiler.SistemaAlquileres.services.PropiedadService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class RepositoriesTest {
    @Mock
    private PropiedadService propiedadService;

    @InjectMocks
    private PropiedadController propiedadController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void obtenerPropiedad_DebeRetornarListaDePropiedades() {

        List<Propiedad> propiedadesEsperadas = Arrays.asList(new Propiedad(), new Propiedad());
        when(propiedadService.obtenerPropiedades()).thenReturn(propiedadesEsperadas);

        List<Propiedad> propiedadesObtenidas = propiedadController.obtenerPropiedad();

        assertEquals(propiedadesEsperadas, propiedadesObtenidas);
    }

    @Test
    void guardarNuevaPropiedad_DebeRetornarHttpStatusBadRequest_CuandoElNombreDePropiedadYaExiste() {
        when(propiedadService.buscarPorNombre(anyString())).thenReturn(new Propiedad());

        ResponseEntity<Object> responseEntity = propiedadController.guardarNuevaPropiedad("Aqua", "Sabaneta", true, "URL", 100000);

        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    void actualizarPropiedad_DebeRetornarHttpStatusForbidden_CuandoLaUbicacionNoEsPermitida() {
        Propiedad propiedad = new Propiedad();
        propiedad.setUbicacionPropiedad("Sabaneta");

        ResponseEntity<Object> responseEntity = propiedadController.actualizarPropiedad(propiedad);

        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

}
