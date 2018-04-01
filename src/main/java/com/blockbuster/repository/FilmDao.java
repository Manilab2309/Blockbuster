/**
 * 
 */
package com.blockbuster.repository;

import java.util.List;

import com.blockbuster.entity.Film;

/**
 * @author Ramón Cigüenza
 *
 */


public interface FilmDao {
	
		// Alta de una película
		public void addFilm(Film film);
		
		// Consultas
		public List<Film> getFilms();
		public List<Film> getDirectorFilms(String director);
		public Film getFilmById(int id);
		public List<Film> getFilmByTitle(String title);
		
		// Eliminar una película
	    public void deleteFilmById(int idFilm);
	    public void deleteFilmByTitle(String title);
	    	    
	    // Actualizar ficha de una película
	    public void updateFilm(Film film);

}
