/**
 * 
 */
package com.blockbuster.repository;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blockbuster.entity.Film;

/**
 * @author Ramón Cigüenza
 *
 */

@Repository
public class JPAFilmDao implements FilmDao{

	// Gestor de entidades JavaX persistance
	//EntityManagerFactory emf = Persistence.createEntityManagerFactory("jcg-JPA");
	
	//@PersistenceContext(unitName="data")
	private EntityManager em;
	
	@Transactional(readOnly = false)
	public void addFilm(Film film) {
		// Esta sentencia hace un alta
	//	em.merge(film);
	}

	@Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Film> getFilms()
	 {
		System.out.println("[RAMON] - Ejecutando capa JPA...");
		
		
		List<Film> peliculas = new ArrayList<Film>();
//		Film f1 = new Film();
//		f1.setTitle("PELI PRUEBA");
//		f1.setDirector("Sebastian");
//		f1.setDuration(100);
//		f1.setGender("TERROR");
//		f1.setStatus("DISPONIBLE");
//		f1.setIdFilm(00001);
//		
//		Film f2 = new Film();
//		f2.setTitle("PELI PRUEBA 2");
//		f2.setDirector("Gonzalo");
//		f2.setDuration(112);
//		f2.setGender("COMEDIA");
//		f2.setStatus("ALQUILADA");
//		f2.setIdFilm(00002);
//		
//		System.out.println("[RAMON] - Asignando peliculas...");
//		peliculas.add(f1);
//		peliculas.add(f2);
//		
//		System.out.println("[RAMON] - Devolviendo lista...");
		return peliculas;
		//if (em == null){
		 }

	
	public void deleteFilm(int idFilm) {
		//Find managed Entity reference
        Film film = em.find(Film.class, idFilm);
         
        //Call remove method to remove the entity
        if(film != null){
            em.remove(film);
        }
		
	}

	@Override
	public void updateFilm(Film film) {
		// TODO Auto-generated method stub
		
	}

}
