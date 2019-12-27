package com.nestkart.backend.DAO;

import java.util.ArrayList;

import com.nestkart.backend.Model.Product;


public interface ProductDAO 

{
	boolean add(Product b);
	boolean update(Product b);
	boolean delete(Product b);
	boolean DeleteAll();
	ArrayList<Product> selectAll();
	Product selectOne(int id);
}
