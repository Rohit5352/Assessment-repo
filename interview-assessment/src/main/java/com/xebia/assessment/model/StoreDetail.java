package com.xebia.assessment.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "store_detail")
public class StoreDetail extends CommonDetail {
	
	private static final long serialVersionUID = -5901045467101438540L;

	@Column(name = "location")
	private String location;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="store_user_details", joinColumns={@JoinColumn(referencedColumnName="Id")}
                                        , inverseJoinColumns={@JoinColumn(referencedColumnName="Id")})  
    private Set<UserDetail> users;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="store_id")
    private Set<ProductDetail> products;

	public Set<UserDetail> getUsers() {
		return users;
	}

	public void setUsers(Set<UserDetail> users) {
		this.users = users;
	}

	public Set<ProductDetail> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDetail> products) {
		this.products = products;
	}

}
