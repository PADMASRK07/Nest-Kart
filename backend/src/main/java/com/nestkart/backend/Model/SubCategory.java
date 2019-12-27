 package com.nestkart.backend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class SubCategory 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int sub_cat_id;
	
	@ManyToOne
	Category cat;
	
	@Column(nullable = false,unique = true)
	@NotBlank(message="SubCategory_name cannot blank")
	@Size(min=3,message="Name sholud have 3 characters")
	String sub_cat_name;
	
	
	
	public String getSub_cat_name() {
		return sub_cat_name;
	}
	public void setSub_cat_name(String sub_cat_name) {
		this.sub_cat_name = sub_cat_name;
	}
	public Category getCat() {
		return cat;
	}
	public void setCat(Category cat) {
		this.cat = cat;
	}
	public int getSub_cat_id() {
		return sub_cat_id;
	}
	public void setSub_cat_id(int sub_cat_id) {
		this.sub_cat_id = sub_cat_id;
	}
		
}
