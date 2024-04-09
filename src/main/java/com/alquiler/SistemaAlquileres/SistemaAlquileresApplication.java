package com.alquiler.SistemaAlquileres;

import com.alquiler.SistemaAlquileres.repositories.Pool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class SistemaAlquileresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaAlquileresApplication.class, args);

	}
}
