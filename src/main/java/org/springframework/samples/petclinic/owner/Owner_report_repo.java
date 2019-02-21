/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.owner;

import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fabricio
 */
public interface Owner_report_repo extends Repository<Owner_report, Integer> {
    @Query("SELECT ownerreport FROM Owner_report ownerreport")
	@Transactional (readOnly= true)
	Collection<Owner_report> findAll();
	
	void save(Owner_report owner_report);
}
