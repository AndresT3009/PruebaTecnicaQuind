package com.alquiler.SistemaAlquileres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

import org.springframework.context.annotation.Bean;



@TestConfiguration(proxyBeanMethods = false)
public class TestSistemaAlquileresApplication {

	/*@Bean
	@ServiceConnection
	PostgreSQLContainer<?> postgresContainer() {
		return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
	}

	public static void main(String[] args) {
		SpringApplication.from(SistemaAlquileresApplication::main).with(TestSistemaAlquileresApplication.class).run(args);
	}*/
}
