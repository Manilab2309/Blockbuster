/**
 * 
 */
package com.blockbuster.service;

import java.io.Serializable;
import java.util.List;

import com.blockbuster.entity.Film;

/**
 * @author Ramón Cigüenza
 *
 */
public interface FilmService extends Serializable{
	
	// Alta de una película
	public void addFilm(Film film);
	
	// Consulta de todas las películas
	public List<Film> getFilms();
	
	// Eliminar una película
    public void deleteFilm(int idFilm);
    
    // Actualizar ficha de una película
    public void updateFilm(Film film);

}
