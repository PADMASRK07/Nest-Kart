package com.nestkart.backend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;
@Entity
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int pro_id;
	
	@NotBlank(message="product_name cannot blank")
	@Size(min=3,message="Name sholud have 3 characters")
	@Column(unique=true,nullable=false)
	String pro_name;
	
	@NotBlank(message="product_description cannot blank")
	@Size(min=10,max=500,message="Name sholud have 10 characters")	
	@Column(nullable=false)
	String pro_desc;
	
	
	@Column(nullable=false)
	int pro_quantity;
	
	
	@Column(nullable=false)
	float pro_price;
	
	@ManyToOne
	SubCategory subcat;

	@Transient
	MultipartFile pimage;
	
	
	
	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPro_desc() {
		return pro_desc;
	}

	public void setPro_desc(String pro_desc) {
		this.pro_desc = pro_desc;
	}

	public int getPro_quantity() {
		return pro_quantity;
	}

	public void setPro_quantity(int pro_quantity) {
		this.pro_quantity = pro_quantity;
	}

	public float getPro_price() {
		return pro_price;
	}

	public void setPro_price(float pro_price) {
		this.pro_price = pro_price;
	}

	public SubCategory getSubcat() {
		return subcat;
	}

	public void setSubcat(SubCategory subcat) {
		this.subcat = subcat;
	}

}