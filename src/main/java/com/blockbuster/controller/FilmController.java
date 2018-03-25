/**
 * 
 */
package com.blockbuster.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blockbuster.entity.Film;
import com.blockbuster.service.FilmServiceImpl;

/**
 * @author Ramón Cigüenza
 *
 */

@RestController
@RequestMapping("/blockbuster/film")
public class FilmController {

	@Autowired
	private FilmServiceImpl filmService;
	
	// Controlador invoca al servicio de ALTA PELICULAS
	@RequestMapping (method=RequestMethod.POST)
	@ResponseStatus (HttpStatus.CREATED)
	public void addFilm (@RequestBody Film film){
		filmService.addFilm(film);
	}
	
	@RequestMapping (value="/getFilms",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public @ResponseBody List<Film> getFilms(){
		return filmService.getFilms();
	}
	
	// Función auxiliar para comprobar que el controlador funciona de una forma rápida
	@RequestMapping("/saludar")
	public @ResponseBody String saludar(){
		return "Hello! I'm listening...!";
	}
	
}
