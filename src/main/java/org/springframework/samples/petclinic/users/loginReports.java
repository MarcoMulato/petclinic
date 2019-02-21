/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.users;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.springframework.samples.petclinic.model.BaseEntity;

/**
 *
 * @author AlexPS
 */
@Entity
@Table(name = "loginreports")
public class loginReports  {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	@NotEmpty
	private String nombre;
        
	
	
	@Column(name = "fecha")
	@NotEmpty
	private String Fecha;
	
	@Column(name = "exitoso")
	private String exitoso;

   

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getExitoso() {
        return exitoso;
    }

    public void setExitoso(String exitoso) {
        this.exitoso = exitoso;
    }

    

    @Override
    public String toString() {
        return "loginReports{" + "id=" + id + ", nombre=" + nombre + ", Fecha=" + Fecha + ", exitoso=" + exitoso + '}';
    }

    
        
}
