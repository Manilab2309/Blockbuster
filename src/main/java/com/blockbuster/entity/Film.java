/**
 * 
 */
package com.blockbuster.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ramón Cigüenza
 *
 */
@Entity
@Table(name="films") 
public class Film implements Serializable {
	
	/**
	 * Default serializable object ID 
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos de películas, importante especificar en @Column el nombre de la columna en base de datos
	@Id
    @Column(name = "idFilm")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idFilm;
	
	// No requieren @Column porque en BBDD se llaman igual las columnas
	private String title;
	private int duration;
	private String director;
	
	@Column(name = "gender_film")
	private String gender;
	
	@Column(name = "price_rent")
	private float priceRent;
	
	@Column(name = "price_sell")
	private float priceSell;
	
	@Column(name = "status_film")
	private String status;
	
	// Getters and setters
	public int getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getPriceRent() {
		return priceRent;
	}
	public void setPriceRent(float priceRent) {
		this.priceRent = priceRent;
	}
	public float getPriceSell() {
		return priceSell;
	}
	public void setPriceSell(float priceSell) {
		this.priceSell = priceSell;
	}
	
}
