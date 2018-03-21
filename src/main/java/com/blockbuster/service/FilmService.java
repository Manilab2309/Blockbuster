/**
 * 
 */
package com.blockbuster.service;

import java.util.List;

import com.blockbuster.entity.Film;

/**
 * @author Ramón Cigüenza
 *
 */
public class FilmService implements FilmManager{

	
	public void addFilm(Film film) {
		System.out.println("Alta de una película");
	}
	
	public List<Film> getFilms() {
		System.out.println("Consulta de películas");
		return null;
	}

	public void deleteFilm(int idFilm) {
		System.out.println("Borrado de películas");
	}

	public void updateFilm(Film film) {
		System.out.println("Actualización de películas");
	}

}
