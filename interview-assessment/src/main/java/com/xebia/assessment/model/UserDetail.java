package com.xebia.assessment.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_detail")
public class UserDetail extends CommonDetail {
	
	private static final long serialVersionUID = -1300829943552442820L;

	@Column(name = "password")
	private String password;

	@ManyToMany(mappedBy="users")
    private Set<StoreDetail> stores;
	
	@ManyToOne
    private RoleDetail role;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<StoreDetail> getStores() {
		return stores;
	}

	public void setStores(Set<StoreDetail> stores) {
		this.stores = stores;
	}

	public RoleDetail getRole() {
		return role;
	}

	public void setRole(RoleDetail role) {
		this.role = role;
	}

}
