/**
 * 
 */
package com.blockbuster.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;

/**
 * @author Ramón Cigüenza
 *
 */

@Configuration
@EnableWebMvc
@EnableSwagger
@ComponentScan("com.blockbuster.controller")
public class SwaggerSpringMVCConfig {
	
	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;
	
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig){
		this.setSpringSwaggerConfig(springSwaggerConfig);
	}
	
	@Bean
	public SwaggerSpringMvcPlugin customImplementation(){
		// Aqui especificamos el nombre del patron de las URLs llamada para el API, debe coincidir con el RequestMapping del Controller
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*blockbuster/*.*");
		
	}
	
	// Declaramos la Documentación de presentación del API
	private ApiInfo apiInfo(){
		ApiInfo apiInfo = new ApiInfo(
				"API Blockbuster",
				"API Gestion Videoclub Blockbuster",
				"@Copyright Ramón Cigüenza Fuster 2018",
				"apiblockbuster@gmail.com",
				"Software Licence Swagger",
				"elmundo.com"		
		);
		
		return apiInfo;
	}

}
