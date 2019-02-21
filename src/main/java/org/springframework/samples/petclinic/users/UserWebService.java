/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.users;

import com.google.gson.Gson;

/**
 *
 * @author pablo
 */
public class UserWebService {
	WebService webService = new WebService();
	String resultado = null;
	public void setWebService(String cp){
		this.resultado = webService.crearWebService(cp);
		System.out.println("Res; " + resultado);
	}

	public CodigoPostal getCodigoPostal(){
		Gson gson = new Gson();
		this.resultado = obtenerAcentos(this.resultado);
		CodigoPostal cp = gson.fromJson(this.resultado,CodigoPostal.class);
		System.out.println("Municipio: " + cp.getMunicipio());
		return cp;
	}
	
	private String obtenerAcentos(String entero){
		String resultado = "";
		char[] c = new char[entero.length()];
		int[] a = new int[entero.length()];
		
		for (int i = 0; i < entero.length(); i++) {
			switch(entero.charAt(i)){
				case '¡':
					resultado = resultado + "á";
				break;   
				case '©':
					resultado = resultado + "é";
				break;
				case '­':
					resultado = resultado +  "í";
				break;
				case '³':
					resultado += "ó";
				break;	
				case 'Ã':
				break;
				default:
					resultado = resultado + entero.charAt(i);
						
			      }
			
		}
		
		 return resultado;
	}
}
