package com.blockbuster.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Importante que especifiques esto si usas SpringBoot en lugar de servidor externo, para que localice el paquete donde están todas tus clases, si no al arrancar peta el server
// @ComponentScan({ "com.blockbuster.controller","com.blockbuster.config", "com.blockbuster.service", "com.blockbuster.repository", "com.blockbuster.entity" })
@ComponentScan("com.blockbuster.controller")
@ComponentScan("com.blockbuster.service")
@ComponentScan("com.blockbuster.entity")
@ComponentScan("com.blockbuster.repository")
@SpringBootApplication
public class BlockbusterApplication {

	public static void main(String[] args) {

		// La ejecución comienza aquí
		SpringApplication.run(BlockbusterApplication.class, args);

	}
}
