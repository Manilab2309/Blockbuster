/**
 * 
 */
package com.blockbuster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockbuster.entity.Film;
import com.blockbuster.repository.FilmDao;

/**
 * @author Ramón Cigüenza
 *
 */

@Service(value="filmService")
public class FilmServiceImpl implements FilmService{

	private static final long serialVersionUID = 1L;
	
	@Autowired
    private FilmDao filmRepositoryDao;
	
	// Implementación del servicio de ALTA
	public void addFilm(Film film) {
		filmRepositoryDao.addFilm(film);
	}
	
	// Implementación del servicio de CONSULTA de todas las peliculas
	public List<Film> getFilms() {
		return filmRepositoryDao.getFilms(); 
	}

	public void deleteFilm(int idFilm) {
		System.out.println("Borrado de películas");
	}

	public void updateFilm(Film film) {
		System.out.println("Actualización de películas");
	}

}
