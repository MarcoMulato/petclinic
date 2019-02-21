/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.users;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pablo
 */
public interface UserReposiroty extends Repository<User, Integer> {
    @Query("SELECT users FROM User users")
    @Transactional (readOnly= true)
    Collection<User> findAll();
    
    
    @Query("SELECT users FROM User users WHERE users.id =:id")
    @Transactional(readOnly = true)
    User findById(@Param("id") Integer id);
    
    @Query("SELECT DISTINCT users FROM User users WHERE users.nombre LIKE :nombre%")
    @Transactional(readOnly = true)
    Collection<User> findByName(@Param("nombre") String nombre);
    
    void save(User user);
    
    void delete(User user);
    
}
