/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.medicament;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author theco
 */
public interface Medicament_reportRepository extends Repository<Medicament_report, Integer>{
    @Query("SELECT medicaments_report FROM Medicament_report medicaments_report")
	@Transactional (readOnly= true)
	Collection<Medicament_report> findAll();	
	void save(Medicament_report medicament_report);
    
}
