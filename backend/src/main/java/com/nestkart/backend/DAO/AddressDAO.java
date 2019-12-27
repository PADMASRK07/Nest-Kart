package com.nestkart.backend.DAO;

import java.util.ArrayList;

import com.nestkart.backend.Model.Address;


public interface AddressDAO 

{
	boolean add(Address b);
	boolean update(Address b);
	boolean delete(Address b);
	boolean DeleteAll();
	ArrayList<Address> selectAll();
	Address selectOne(int id);
}
