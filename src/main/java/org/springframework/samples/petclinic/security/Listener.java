/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.security;

import java.util.Collection;
import java.util.Date;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.users.loginReports;
import org.springframework.samples.petclinic.users.userReportsRepository;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationFailureDisabledEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author AlexPS
 */
@Component
public class Listener implements ApplicationListener{
    private userReportsRepository user; 
    
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        
        if (event instanceof AuthenticationFailureBadCredentialsEvent   ) {
            AuthenticationFailureBadCredentialsEvent ev = (AuthenticationFailureBadCredentialsEvent) event;
            Object name = ev.getAuthentication().getPrincipal();
            String nombre = (String)ev.getAuthentication().getPrincipal().toString();
            String cadena [] = nombre.split(" ");
            loginReports user = new loginReports();
             for (int i = 0; i < cadena.length; i++) {
                System.out.println(cadena[i]);
            }
            user.setExitoso("Sesion fallida");
            user.setNombre((String) name);
            Date fecha = new Date();
            user.setFecha(fecha.toString());
            
            System.out.println("inicio fallido"+ user.toString());
            
            this.user.save(user);
        }
        else if (event instanceof AuthenticationSuccessEvent){
            AuthenticationSuccessEvent ev = (AuthenticationSuccessEvent) event;
            String nombre = (String)ev.getAuthentication().getPrincipal().toString();
            String cadena [] = nombre.split(" ");
            for (int i = 0; i < cadena.length; i++) {
                System.out.println(cadena[i]);
            }
            loginReports user = new loginReports();
            user.setExitoso("Sesion exitosa");
            user.setNombre(cadena[2]);
            Date fecha = new Date();
            user.setFecha(fecha.toString());
            System.out.println("inicio exitoso "+user.toString());

             this.user.save(user);
            
        }
        if (event instanceof AuthenticationFailureDisabledEvent) {
            AuthenticationFailureDisabledEvent ev = (AuthenticationFailureDisabledEvent) event;
            Object name = ev.getAuthentication().getPrincipal();
            String nombre = (String)ev.getAuthentication().getPrincipal().toString();
            String cadena [] = nombre.split(" ");
            loginReports user = new loginReports();
             for (int i = 0; i < cadena.length; i++) {
                System.out.println(cadena[i]);
            }
            user.setExitoso("Sesion fallida");
            user.setNombre((String) name);
            Date fecha = new Date();
            user.setFecha(fecha.toString());
            
            System.out.println("inicio fallido"+ user.toString());
            
            this.user.save(user);
        }
        
    }

    public Listener(userReportsRepository user) {
        this.user = user;
    }
}
