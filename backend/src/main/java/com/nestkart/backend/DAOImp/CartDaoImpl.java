package com.nestkart.backend.DAOImp;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nestkart.backend.DAO.CartDAO;
import com.nestkart.backend.Model.Cart;


@Repository("cartdao")
@Transactional
public class CartDaoImpl implements CartDAO {

	@Autowired
	SessionFactory sf;

	public boolean add(Cart b) {
		try {
			sf.getCurrentSession().save(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean update(Cart b) {
		try {
			sf.getCurrentSession().update(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean delete(Cart b) {
		try {
			sf.getCurrentSession().delete(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean DeleteAll() {
		ArrayList<Cart> b1;
		try {
			b1 = (ArrayList<Cart>) sf.getCurrentSession().createQuery("from Cart").list();
			Iterator<Cart> i = b1.listIterator();
			while (i.hasNext()) {
				Cart nest = (Cart) i.next();
				sf.getCurrentSession().delete(nest);
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public ArrayList<Cart> selectAll() {
		ArrayList<Cart> b;
		try {
			b = (ArrayList<Cart>) sf.getCurrentSession().createQuery("from Cart").list();
			if (b.isEmpty())
				return null;
			else
				return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Cart selectOne(int id) {
		Cart b;
		try {
			b = (Cart) sf.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("cart_id", id)).uniqueResult();
			return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
