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
	
	// Consultas
	public List<Film> getFilms();
	public List<Film> getFilmsByDirector(String director);
	public Film getFilmById(int id);
	public List<Film> getFilmByTitle(String title);
	
	// Borrado
    public void deleteFilmById(int idFilm);
    public void deleteFilmByTitle(String title);
    	    
    // Actualizar ficha de una película
    public void updateFilm(Film film);
    
}
