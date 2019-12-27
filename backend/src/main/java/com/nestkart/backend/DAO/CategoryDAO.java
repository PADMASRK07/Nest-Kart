package com.nestkart.backend.DAO;

import java.util.ArrayList;

import com.nestkart.backend.Model.Category;


public interface CategoryDAO 

{
	boolean add(Category b);
	boolean update(Category b);
	boolean delete(Category b);
	boolean DeleteAll();
	ArrayList<Category> selectAll();
	Category selectOne(int id);
}
