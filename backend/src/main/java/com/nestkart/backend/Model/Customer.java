package com.nestkart.backend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.sun.jndi.cosnaming.IiopUrl.Address;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cus_id;
	
	@Column(nullable=false)
	@NotBlank(message="UserName Cannot Be Blank")
	@Size(min=3,message="Name Should Have Minimum 3 Charecters")
	String cus_name;
	
	@Column(unique=true,nullable=false)
	@NotBlank(message="UserEmailId Cannot Be Blank")
	@Email(message="Enter EmailId In Proper Format")
	String cus_emailid;
	
	@Column(unique=true,nullable=false)
	@NotBlank(message="User Mobile Number Cannot Be Blank")
	@Pattern(regexp="[0-9]{10}",message="Mobile Number must be of 10 digits begining with 9,8,7,6")
	String cus_phonenumber;
	
	@Column(nullable=false)
	@NotBlank(message="Password Cannot Be Blank")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",message="1UpperCase,1LowerCase,1Number,1SplChar(@,#,$,%),Minimum 6 char Maximum 20 char")
	String cus_password;
	
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getCus_emailid() {
		return cus_emailid;
	}
	public void setCus_emailid(String cus_emailid) {
		this.cus_emailid = cus_emailid;
	}
	public String getCus_phonenumber() {
		return cus_phonenumber;
	}
	public void setCus_phonenumber(String cus_phonenumber) {
		this.cus_phonenumber = cus_phonenumber;
	}
	public String getCus_password() {
		return cus_password;
	}
	public void setCus_password(String cus_password) {
		this.cus_password = cus_password;
	}
}