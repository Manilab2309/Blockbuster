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
@Table(name="status") 
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idStatus;
	
	@Column(name="status_store")
	private String statusName;

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
}
