/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.medicament;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.springframework.samples.petclinic.model.BaseEntity;

/**
 *
 * @author theco
 */

@Entity
@Table(name = "medicaments_report")
public class Medicament_report extends BaseEntity{
    @Column(name = "nombre")
    @NotEmpty
    private String nombre;
 
    @Column(name = "accion")
    @NotEmpty
    private String accion;
  
    @Column(name = "fecha")
    @NotEmpty
    private String fecha;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
