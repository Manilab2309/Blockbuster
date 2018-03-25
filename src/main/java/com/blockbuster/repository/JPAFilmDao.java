/**
 * 
 */
package com.blockbuster.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blockbuster.entity.Film;
import com.blockbuster.store.BlockbusterApplication;

import ch.qos.logback.classic.Level;

/**
 * @author Ramón Cigüenza
 *
 */

@Repository
@Transactional
public class JPAFilmDao implements FilmDao{

	private final Logger logger = LoggerFactory.getLogger(BlockbusterApplication.class);
	
	// Gestor de entidades JavaX persistance
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = false)
	public void addFilm(Film film) {
		// Esta sentencia hace un alta
		em.merge(film);
	}

	@Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Film> getFilms()	 {
				
		String hql= "FROM Film"; 
		logger.debug("-- Application API Blockbuster: "+JPAFilmDao.class.getName()+ " Consultando todas las películas de la base de Datos: "+hql);
		return em.createQuery(hql).getResultList(); 
		
	}

	
	public void deleteFilm(int idFilm) {
		//Find managed Entity reference
        Film film = em.find(Film.class, idFilm);
         
        //Call remove method to remove the entity
        if(film != null){
            em.remove(film);
        }
		
	}

	
	public void updateFilm(Film film) {
		em.merge(film);
	    return;
		
	}

}
