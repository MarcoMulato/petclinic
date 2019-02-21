/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.security;

/**
 *
 * @author AlexPS
 */
import org.springframework.samples.petclinic.users.Users;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
 
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[] { Users.class, SecurityConfig.class };
   }
 
   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { WebMvcConfig.class };
   }
 
   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }
}