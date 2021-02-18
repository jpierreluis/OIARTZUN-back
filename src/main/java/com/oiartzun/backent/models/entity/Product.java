package com.oiartzun.backent.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="products")
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "amount")
	private Double amount;
	@Column(name = "inventary_code")
	private String inventaryCode;
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	@Column(name = "update_at")
	@Temporal(TemporalType.DATE)
	private Date updateAt;
	
	@PrePersist
	public void prePersist() {
		updateAt=new Date();
		createAt=new Date();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getInventaryCode() {
		return inventaryCode;
	}
	public void setInventaryCode(String inventaryCode) {
		this.inventaryCode = inventaryCode;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", amount=" + amount + ", inventaryCode=" + inventaryCode
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
	
	
}
