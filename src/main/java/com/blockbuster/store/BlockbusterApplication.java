package com.blockbuster.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.blockbuster.config.SwaggerConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

// Importante que especifiques esto si usas SpringBoot en lugar de servidor externo, para que localice el paquete donde están todas tus clases, si no al arrancar peta el server
// @ComponentScan({ "com.blockbuster.controller","com.blockbuster.config", "com.blockbuster.service", "com.blockbuster.repository", "com.blockbuster.entity" })
@ComponentScan("com.blockbuster.controller")
@ComponentScan("com.blockbuster.service")
@ComponentScan("com.blockbuster.entity")
@ComponentScan("com.blockbuster.repository")

// Muy importante para evitar los errores de mapping hql, aqui va a leer Hibernate tus entidades
@EntityScan(basePackages = "com.blockbuster.entity")

@SpringBootApplication
@EnableSwagger2

//Esto permite cargar tu clase personalizada de configuración Swagger, así el engine la encuentra y ejecuta
@Import(SwaggerConfiguration.class) 
public class BlockbusterApplication {

	private static final Logger logger = LoggerFactory.getLogger(BlockbusterApplication.class);
	
	public static void main(String[] args) {

		// La ejecución comienza aquí
		SpringApplication.run(BlockbusterApplication.class, args);

		logger.debug("-- Application API Blockbuster Started --");
	}
}
