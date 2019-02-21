/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.users;

import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AlexPS
 */
public interface userReportsRepository extends Repository<loginReports, Integer> {
    @Query("Select loginreports from loginReports loginreports ")
    @Transactional (readOnly= true)
    Collection<loginReports> findAll();
    
    

    /**
     * Save an {@link Owner} to the data store, either inserting or updating it.
     * @param user
     */
    void save(loginReports user);
}
