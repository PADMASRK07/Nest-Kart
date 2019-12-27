package com.nestkart.backend.DAO;

import java.util.ArrayList;

import com.nestkart.backend.Model.Customer;


public interface CustomerDAO 

{
	boolean add(Customer b);
	boolean update(Customer b);
	boolean delete(Customer b);
	boolean DeleteAll();
	ArrayList<Customer> selectAll();
	Customer selectOne(int id);
}
