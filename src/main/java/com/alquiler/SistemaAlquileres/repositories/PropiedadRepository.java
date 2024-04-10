package com.alquiler.SistemaAlquileres.repositories;

import com.alquiler.SistemaAlquileres.models.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropiedadRepository extends JpaRepository<Propiedad,Long> {
    @Query("SELECT p FROM Propiedad p WHERE p.precioPropiedad >= :precioMinimo AND p.precioPropiedad <= :precioMaximo")
    List<Propiedad> encontrarPorPrecio(int precioMinimo, int precioMaximo);

    Propiedad findByNombrePropiedad(String nombrePropiedad);

}
