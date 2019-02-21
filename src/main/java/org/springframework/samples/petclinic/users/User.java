/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.springframework.samples.petclinic.model.BaseEntity;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "users")
public class User extends BaseEntity {
	
	@Column(name = "nombre")
	@NotEmpty
	private String nombre;
	
	@Column(name = "correo")
	@NotEmpty
	private String correo;
	
	@Column(name = "password")
	@NotEmpty
	private String password;
	
	@Column(name = "activo")
	@NotEmpty
	private String activo;
	
	@Column(name = "cp")
	@NotEmpty
	private String cp;
	
	@Column(name = "municipio")
	@NotEmpty
	private String municipio;
        
        
         @Column(name = "rol")
	private byte rol;

    public byte getRol() {
        return rol;
    }

    public void setRol(byte rol) {
        this.rol = rol;
    }

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}


	@Override
	public String toString() {
		return "User{" + ", nombre=" + nombre + ", correo=" + correo + ", password=" + password + ", activo=" + activo + ", codigoPostal=" + cp + '}';
	}

}
