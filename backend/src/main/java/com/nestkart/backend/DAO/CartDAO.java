package com.nestkart.backend.DAO;

import java.util.ArrayList;

import com.nestkart.backend.Model.Cart;


public interface CartDAO 

{
	boolean add(Cart b);
	boolean update(Cart b);
	boolean delete(Cart b);
	boolean DeleteAll();
	ArrayList<Cart> selectAll();
	Cart selectOne(int id);
}
