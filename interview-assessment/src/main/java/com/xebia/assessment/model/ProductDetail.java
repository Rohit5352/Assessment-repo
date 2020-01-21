package com.xebia.assessment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product_detail")
public class ProductDetail extends CommonDetail {

	private static final long serialVersionUID = 8588134305089467699L;

	@Column(name = "category")
	private String category;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate", nullable = false)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifiedDate", nullable = false)
	private Date modifiedDate;
	
	@ManyToOne
    private StoreDetail store;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public StoreDetail getStore() {
		return store;
	}

	public void setStore(StoreDetail store) {
		this.store = store;
	}

}
