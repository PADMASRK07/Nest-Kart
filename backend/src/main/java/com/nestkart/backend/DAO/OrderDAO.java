package com.nestkart.backend.DAO;

import java.util.ArrayList;

import com.nestkart.backend.Model.Orders;


public interface OrderDAO 

{
	boolean add(Orders b);
	boolean update(Orders b);
	boolean delete(Orders b);
	boolean DeleteAll();
	ArrayList<Orders> selectAll();
	Orders selectOne(int id);
}
