/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.users;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pablo
 */
@Repository("UserRepository")
public interface UserRepository extends JpaRepository<Users, Serializable> {
    
    public abstract Users findByNombre(String nombre);
    
    @Override
    public abstract List<Users> findAll();

    
}