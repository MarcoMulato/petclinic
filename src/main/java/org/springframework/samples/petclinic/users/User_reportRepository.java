/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.users;

import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pablo
 */
public interface User_reportRepository extends Repository<User_report, Integer> {
	@Query("SELECT users_report FROM User_report users_report")
	@Transactional (readOnly= true)
	Collection<User_report> findAll();
	
	void save(User_report user_report);
}
