/**
 * 
 */
package com.blockbuster.entity;

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
@Table(name="genders") 
public class Gender {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idGender;
	
	@Column(name = "gender")
	private String genderName;
	
	public int getIdGender() {
		return idGender;
	}
	public void setIdGender(int idGender) {
		this.idGender = idGender;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

}
