/**
 * 
 */
package com.blockbuster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blockbuster.service.FilmService;

/**
 * @author Ramón Cigüenza
 *
 */

@RestController
@RequestMapping("/blockbuster/film")
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	
	

}
