/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.users;

/**
 *
 * @author pablo
 */
public class CodigoPostal {
	String codigo_postal;
	String municipio;
	public CodigoPostal(){

	}

	public String getCodigo_postal() {
	    return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
	    this.codigo_postal = codigo_postal;
	}

	public String getMunicipio() {
	    return municipio;
	}

	public void setMunicipio(String municipio) {
	    this.municipio = municipio;
	}

}
