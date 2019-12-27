package com.nestkart.backend.DAO;

import java.util.ArrayList;

import com.nestkart.backend.Model.SubCategory;


public interface SubCategoryDAO 

{
	boolean add(SubCategory b);
	boolean update(SubCategory b);
	boolean delete(SubCategory b);
	boolean DeleteAll();
	ArrayList<SubCategory> selectAll();
	SubCategory selectOne(int id);
}
