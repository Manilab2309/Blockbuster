/**
 * 
 */
package com.blockbuster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blockbuster.entity.Film;

/**
 * @author Ramón Cigüenza
 *
 */


public interface FilmDao {
	
		// Alta de una película
		public void addFilm(Film film);
		
		// Consulta de todas las películas
		public List<Film> getFilms();
		
		// Eliminar una película
	    public void deleteFilm(int idFilm);
	    
	    // Actualizar ficha de una película
	    public void updateFilm(Film film);

}
