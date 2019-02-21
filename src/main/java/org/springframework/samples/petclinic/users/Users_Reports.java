/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.users;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pablo
 */
@XmlRootElement
public class Users_Reports {
	private List<User_report> users;
	
	@XmlElement
	public List<User_report> getUserList() {
		if (this.users == null) {
			this.users = new ArrayList<>();
		    }
		    return this.users;
		}
}