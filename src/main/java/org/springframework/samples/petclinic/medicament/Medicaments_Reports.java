/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.medicament;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author theco
 */
    @XmlRootElement
    public class Medicaments_Reports {
        private List<Medicament_report> users;

        @XmlElement
        public List<Medicament_report> getMedicamentList() {
                if (this.users == null) {
                        this.users = new ArrayList<>();
                    }
                    return this.users;
                }
    }
