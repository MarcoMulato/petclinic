/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.users;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author pablo
 */
public class WebService {
	public  String crearWebService (String cp){
        String todo = null;
                    try {

            URL url = new URL("https://api-codigos-postales.herokuapp.com/v2/codigo_postal/"+cp);//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                todo = output;
            }
            conn.disconnect();
            return todo;
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }return null;
    }
}
