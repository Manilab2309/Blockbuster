/**
 * 
 */
package com.blockbuster.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blockbuster.entity.Film;
import com.blockbuster.service.FilmServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Ramón Cigüenza
 *
 */

@Controller
@RestController
@RequestMapping("/blockbuster/film")
@Api(value="FilmControllerAPI",consumes=MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
public class FilmController {

	@Autowired
	private FilmServiceImpl filmService;
	
	// Controlador invoca al servicio de ALTA PELICULAS
	@RequestMapping (value="/addFilm",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ApiOperation("Add a film to videoclub store")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK - Blockbuster Film Added"),
			@ApiResponse(code = 601, message = "Film field exists"),
			@ApiResponse(code = 606, message = "Invalid Input")
	})
	public @ResponseBody void addFilm (@RequestBody Film film){
		filmService.addFilm(film);
	}
	
	@RequestMapping (value="/getFilms",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ApiOperation("Gets films from videoclub store")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="OK",response=Film.class),
			@ApiResponse(code=204, message="OK - Films not found")
	})
	public @ResponseBody List<Film> getFilms(){
		return filmService.getFilms();
	}
	
	@RequestMapping (value="/getFilmsByDirector/{nameDirector}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ApiOperation("Gets films from videoclub store by director")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="OK",response=Film.class),
			@ApiResponse(code=204, message="OK - Films not found")
	})
	public @ResponseBody List<Film> getFilmsByDirector(@PathVariable String nameDirector){
		return filmService.getFilmsByDirector(nameDirector);
	}
	
	@RequestMapping (value="/getFilmById/{idFilm}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ApiOperation("Gets film from videoclub store with specified Id")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="OK",response=Film.class),
			@ApiResponse(code=204, message="OK - Blockbuster ID not found")
	})
	public @ResponseBody Film getFilmById(@PathVariable int idFilm){
		return filmService.getFilmById(idFilm);
	}
	
	@RequestMapping (value="/getFilms/{title}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ApiOperation("Gets films from videoclub store with specified title")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="OK",response=Film.class),
			@ApiResponse(code=204, message="OK - Blockbuster titles not found")
	})
	public @ResponseBody List<Film> getFilmByTitle(@PathVariable String title){
		return filmService.getFilmByTitle(title);
	}
	
	@RequestMapping(value="/deleteFilmById/{idFilm}",method=RequestMethod.DELETE)
	@ApiOperation("Delete film from videoclub store with specified ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK - Blockbuster Film Deleted"),
			@ApiResponse(code = 600, message = "Incorrect ID"),
			@ApiResponse(code = 204, message = "OK - Blockbuster ID not found"),
			@ApiResponse(code = 606, message = "Invalid Input")
	})
	public @ResponseBody void deleteFilmById(@PathVariable int idFilm){
		filmService.deleteFilmById(idFilm);
	}
	
	@RequestMapping(value="/deleteFilmByTitle/{title}",method=RequestMethod.DELETE)
	@ApiOperation(value = "Gets films from videoclub store with specified title")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK - Blockbuster Film Deleted"),
			@ApiResponse(code = 600, message = "Incorrect ID"),
			@ApiResponse(code = 204, message = "OK - Blockbuster film title not found"),
			@ApiResponse(code = 606, message = "Invalid Input")
	})
    public @ResponseBody void deleteFilmByTitle(@PathVariable String title){
		filmService.deleteFilmByTitle(title);
    }
		
	@RequestMapping(value="/updateFilm",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Gets films from videoclub store with specified title", notes= "Update database record film")
	@ApiResponses(value = {
			@ApiResponse(code = 600, message = "Blockbuster Film Incorrect ID"),
			@ApiResponse(code = 601, message = "Blockbuster Film ID not found"),
			@ApiResponse(code = 606, message = "Blockbuster Film Invalid Input")
	})
	public @ResponseBody void updateFilm(Film film) {
	    filmService.updateFilm(film);
	}
		
	// TODO: Crear los servicios alquilar y desalquilar
	
	
}
