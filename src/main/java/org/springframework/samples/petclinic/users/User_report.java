/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.springframework.samples.petclinic.model.BaseEntity;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "users_report")
public class User_report extends BaseEntity {
	@Column(name = "nombre_usuario")
	@NotEmpty
	private String nombre_usuario;
	
	@Column(name = "accion")
	@NotEmpty
	private String accion;
	
	@Column(name = "fecha")
	@NotEmpty
	private String fecha;

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}


	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

}
