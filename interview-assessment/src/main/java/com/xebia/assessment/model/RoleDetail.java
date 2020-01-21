package com.xebia.assessment.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role_detail")
public class RoleDetail extends CommonDetail {

	private static final long serialVersionUID = 758713773693060916L;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="role_id")
    private Set<UserDetail> usersDetails;
	
	public Set<UserDetail> getUsersDetails() {
		return usersDetails;
	}

	public void setUsersDetails(Set<UserDetail> usersDetails) {
		this.usersDetails = usersDetails;
	}
	
}
