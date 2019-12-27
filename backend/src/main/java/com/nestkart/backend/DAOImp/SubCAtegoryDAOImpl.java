package com.nestkart.backend.DAOImp;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nestkart.backend.DAO.SubCategoryDAO;
import com.nestkart.backend.Model.SubCategory;

@Repository("subcategorydao")
@Transactional
public class SubCAtegoryDAOImpl implements SubCategoryDAO {

	@Autowired
	SessionFactory sf;

	public boolean add(SubCategory b) {
		try {
			sf.getCurrentSession().save(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean update(SubCategory b) {
		try {
			sf.getCurrentSession().update(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean delete(SubCategory b) {
		try {
			sf.getCurrentSession().delete(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean DeleteAll() {
		ArrayList<SubCategory> b1;
		try {
			b1 = (ArrayList<SubCategory>) sf.getCurrentSession().createQuery("from SubCategory").list();
			Iterator<SubCategory> i = b1.listIterator();
			while (i.hasNext()) {
				SubCategory nest = (SubCategory) i.next();
				sf.getCurrentSession().delete(nest);
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public ArrayList<SubCategory> selectAll() {
		ArrayList<SubCategory> b;
		try {

			b = (ArrayList<SubCategory>) sf.getCurrentSession().createQuery("from SubCategory").list();
			if (b.isEmpty())
				return null;
			else
				return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public SubCategory selectOne(int id) {
		SubCategory b;
		try {
			b = (SubCategory) sf.getCurrentSession().createCriteria(SubCategory.class).add(Restrictions.eq("sub_cat_id", id))
					.uniqueResult();
			return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
