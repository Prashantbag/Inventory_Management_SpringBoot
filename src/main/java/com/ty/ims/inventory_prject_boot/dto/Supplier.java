package com.ty.ims.inventory_prject_boot.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Supplier {
	@Id
	@GenericGenerator(name = "supplier_Id", strategy = "com.ty.ims.inventory_prject_boot.util.Sup_CustomIdGenerator")
	@GeneratedValue(generator = "supplier_Id")
	@Column(name = "supplier_Id")
	private String supplierId;

	@NotNull
	@Pattern(regexp = "^[A-Z a-z ]*$", message = "Use only Alphabets, Invalid Input")
	private String supplierName;

	@NotNull
	private long supplierPhoneNo;

	@NotNull
	@Column(unique = true)
	private String supplierEmailId;

	private Date inwardDate;

	private int inwardQuantity;

	@JsonIgnoreProperties(value = { "quantity" }, allowSetters = true)
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns = @JoinColumn, inverseJoinColumns = @JoinColumn)
	private List<Item> items;

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public long getSupplierPhoneNo() {
		return supplierPhoneNo;
	}

	public void setSupplierPhoneNo(long supplierPhoneNo) {
		this.supplierPhoneNo = supplierPhoneNo;
	}

	public String getSupplierEmailId() {
		return supplierEmailId;
	}

	public void setSupplierEmailId(String supplierEmailId) {
		this.supplierEmailId = supplierEmailId;
	}

	public Date getInwardDate() {
		return inwardDate;
	}

	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
	}

	public int getInwardQuantity() {
		return inwardQuantity;
	}

	public void setInwardQuantity(int inwardQuantity) {
		this.inwardQuantity = inwardQuantity;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
