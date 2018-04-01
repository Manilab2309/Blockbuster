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

@Service(value = "filmService")
public class FilmServiceImpl implements FilmService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private FilmDao filmRepositoryDao;

	
	public void addFilm(Film film) {
		filmRepositoryDao.addFilm(film);
	}

	public List<Film> getFilms() {
		return filmRepositoryDao.getFilms();
	}

	public List<Film> getFilmsByDirector(String director) {
		return filmRepositoryDao.getDirectorFilms(director);
	}

	public Film getFilmById(int id) {
		return filmRepositoryDao.getFilmById(id);
	}

	public List<Film> getFilmByTitle(String title) {
		return filmRepositoryDao.getFilmByTitle(title);
	}

	public void deleteFilmById(int idFilm) {
		filmRepositoryDao.deleteFilmById(idFilm);
	}

	public void deleteFilmByTitle(String title) {
		filmRepositoryDao.deleteFilmByTitle(title);
	}

	public void updateFilm(Film film) {
		filmRepositoryDao.updateFilm(film);
	}

}
