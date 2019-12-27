package com.nestkart.backend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
	}

	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cart_id;
	
	@Column(nullable=false)
	int cart_quantity;
	
	@Column(nullable=false)
	float cart_price;
	
	@ManyToOne
	Product pro;
	
	@ManyToOne
	Customer cus;

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getCart_quantity() {
		return cart_quantity;
	}

	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}

	public float getCart_price() {
		return cart_price;
	}

	public void setCart_price(float cart_price) {
		this.cart_price = cart_price;
	}

	
}
