/**
 * 
 */
package com.blockbuster.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blockbuster.entity.Film;
import com.blockbuster.entity.Gender;
import com.blockbuster.entity.State;
import com.blockbuster.store.BlockbusterApplication;

/**
 * @author Ramón Cigüenza
 *
 */

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class JPAFilmDao implements FilmDao {

	private final Logger logger = LoggerFactory.getLogger(BlockbusterApplication.class);

	// Gestor de entidades JavaX persistance
	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = false)
	public void addFilm(Film film) {

		int genderAdapted = -1;
		int statusAdapted = -1;

		logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
				+ " Se procede a obtener los códigos de género y estado de película: ");

		String hql = "FROM Gender";
		List<Gender> genderList = em.createQuery(hql).getResultList();
		logger.debug(
				"-- Application API Blockbuster: " + JPAFilmDao.class.getName() + " Obtenida lista de géneros: " + hql);

		hql = "FROM State";
		List<State> stateList = em.createQuery(hql).getResultList();
		logger.debug(
				"-- Application API Blockbuster: " + JPAFilmDao.class.getName() + " Obtenida lista de estados: " + hql);

		for (int i = 0; i < genderList.size(); i++) {
			if (genderList.get(i).getGenderName().equalsIgnoreCase(film.getGender())) {
				genderAdapted = genderList.get(i).getIdGender();
			}
		}

		for (int i = 0; i < stateList.size(); i++) {
			if (stateList.get(i).getStatusName().equalsIgnoreCase(film.getStatus())) {
				statusAdapted = stateList.get(i).getIdStatus();
			}
		}

		if (genderAdapted == -1 || statusAdapted == -1) {
			logger.error("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
					+ " No se ha podido traducir el geénero o estado de la película: " + genderAdapted + " - "
					+ statusAdapted);
		} else {

			logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
					+ " Traducción de genero y estado correctos: " + genderAdapted + " - " + statusAdapted);
			
//			hql = "INSERT INTO films (idFilm, title, status_film, gender_film, duration, director, price_rent, price_sell, last_updated) VALUES ("
//					+ film.getIdFilm() + ",'" + film.getTitle() + "'," + statusAdapted + "," + genderAdapted + ","
//					+ film.getDuration() + ",'" + film.getDirector() + "'," + film.getPriceRent() + ","
//					+ film.getPriceSell() + ",CURRENT_TIMESTAMP())";
			
			hql = "INSERT INTO films (idFilm, title, status_film, gender_film, duration, director, price_rent, price_sell, last_updated) VALUES (?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP())";
					
			logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
					+ " Ejecutando query: " + hql);
			
			Query query = em.createNativeQuery(hql);
			query.setParameter(1, film.getIdFilm());
			query.setParameter(2, film.getTitle());
			query.setParameter(3, statusAdapted);
			query.setParameter(4, genderAdapted);
			query.setParameter(5, film.getDuration());
			query.setParameter(6, film.getDirector());
			query.setParameter(7, film.getPriceRent());
			query.setParameter(8, film.getPriceSell());
			query.executeUpdate();

			logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
					+ " Query de inserción ejecutada: " + hql);
		}

		// em.merge(film); Esto haría el alta si no requiriera de transformación
		// de datos de entrada, pero en nuestro caso no vale ya que estado y
		// genero son numeros
		// y en la presentación se piden cadenas. Se requiere adaptar.
	}

	@Transactional(readOnly = true)
	public List<Film> getFilms() {

		String hql = "FROM Film";
		logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
				+ " Consultando todas las películas en la Base de Datos: " + hql);
		return em.createQuery(hql).getResultList();

	}

	@Transactional(readOnly = true)
	public List<Film> getDirectorFilms(String director) {

		String hql = "FROM Film WHERE director =" + "'"+director+"'";
		logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
				+ " Consultando las películas del director: " + director + " en la Base de Datos: " + hql);
		List<Film> resultsFilmsByDirector = em.createQuery(hql).getResultList();
		
		logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
				+ " Número de películas encontradas del director: " + director + " en la Base de Datos: " + resultsFilmsByDirector.size());
		
		return resultsFilmsByDirector;
	}

	@Transactional(readOnly = true)
	public Film getFilmById(int id) {

		String hql = "FROM Film WHERE idFilm =" + String.valueOf(id);
		logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
				+ " Consulta la pelícupa que tenga el id: " + id + " en la Base de Datos: " + hql);
		List<Film> resultQuery = em.createQuery(hql).getResultList();
		
		if (resultQuery.size() != 0){
			return resultQuery.get(0);
		}else{
			// TODO: Propagar codigo 201 de no content
			return null;
		}
	}

	@Transactional(readOnly = true)
	public List<Film> getFilmByTitle(String title) {
		String hql = "FROM Film WHERE title =" + "'"+title+"'";
		logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
				+ " Consultando las películas con titulo: " + title + " en la Base de Datos: " + hql);
		List<Film> resultsFilmsByTitle = em.createQuery(hql).getResultList();
		
		logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
				+ " Películas encontradas con título: " + title + " en la Base de Datos: " + resultsFilmsByTitle.size());
		
		return resultsFilmsByTitle;
		
	}

	@Transactional(readOnly = false)
	public void deleteFilmById(int idFilm) {
		
		logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
				+ " Ejecutando borrado de pelicula con Id: " + idFilm);
		
		// Find managed Entity reference
		Film film = em.find(Film.class, idFilm); // find vale sólo cuando buscas por Primary Key

		// Call remove method to remove the entity
		if (film != null) {
			em.remove(film);
			logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
					+ " pelicula eliminada");
		}
	}

	@Transactional(readOnly = false)
	public void deleteFilmByTitle(String title) {

		String hql = "DELETE FROM films WHERE title = ?";

		logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
				+ " Eliminando película con título: " + title);
		logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
				+ " Ejecutando query: " + hql);
		
		Query query = em.createNativeQuery(hql);
		query.setParameter(1, title);
		
		int responseSQLDel = query.executeUpdate();
		
		if (responseSQLDel == 0){
			
			logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
					+ " Pelicula con título: "+ title + " no encontrada");
			
			// TODO: Aqui hay que propagar error al Controller para que devuelva un 204
			
		}else{
			
			logger.debug("-- Application API Blockbuster: " + JPAFilmDao.class.getName()
					+ " Pelicula eliminada ");
		}
		
		
	}

	@Transactional(readOnly = false)
	public void updateFilm(Film film) {
		em.merge(film);
		return;

	}

}
