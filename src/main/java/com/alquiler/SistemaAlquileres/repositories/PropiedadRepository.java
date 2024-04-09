package com.alquiler.SistemaAlquileres.repositories;

import com.alquiler.SistemaAlquileres.models.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropiedadRepository extends JpaRepository<Propiedad,Long> {



}
