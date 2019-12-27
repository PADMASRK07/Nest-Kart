package com.nestkart.backend.DAOImp;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nestkart.backend.DAO.ProductDAO;
import com.nestkart.backend.Model.Product;


@Repository("productdao")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sf;

	public boolean add(Product b) {
		try {
			sf.getCurrentSession().save(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean update(Product b) {
		try {
			sf.getCurrentSession().update(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean delete(Product b) {
		try {
			sf.getCurrentSession().delete(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean DeleteAll() {
		ArrayList<Product> b1;
		try {
			b1 = (ArrayList<Product>) sf.getCurrentSession().createQuery("from Product").list();
			Iterator<Product> i = b1.listIterator();
			while (i.hasNext()) {
				Product nest = (Product) i.next();
				sf.getCurrentSession().delete(nest);
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public ArrayList<Product> selectAll() {
		ArrayList<Product> b;
		try {
			b = (ArrayList<Product>) sf.getCurrentSession().createQuery("from Product").list();
			if (b.isEmpty())
				return null;
			else
				return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Product selectOne(int id) {
		Product b;
		try {
			b = (Product) sf.getCurrentSession().createCriteria(Product.class).add(Restrictions.eq("pro_id", id)).uniqueResult();
			return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
