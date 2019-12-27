package com.nestkart.backend.DAOImp;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nestkart.backend.DAO.OrderDAO;
import com.nestkart.backend.Model.Orders;


@Repository("orderdao")
@Transactional
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	SessionFactory sf;

	public boolean add(Orders b) {
		try {
			sf.getCurrentSession().save(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean update(Orders b) {
		try {
			sf.getCurrentSession().update(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean delete(Orders b) {
		try {
			sf.getCurrentSession().delete(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean DeleteAll() {
		ArrayList<Orders> b1;
		try {
			b1 = (ArrayList<Orders>) sf.getCurrentSession().createQuery("from Order").list();
			Iterator<Orders> i = b1.listIterator();
			while (i.hasNext()) {
				Orders nest = (Orders) i.next();
				sf.getCurrentSession().delete(nest);
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public ArrayList<Orders> selectAll() {
		ArrayList<Orders> b;
		try {
			b = (ArrayList<Orders>) sf.getCurrentSession().createQuery("from Orders").list();
			if (b.isEmpty())
				return null;
			else
				return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Orders selectOne(int id) {
		Orders b;
		try {
			b = (Orders) sf.getCurrentSession().createCriteria(Orders.class).add(Restrictions.eq("Order_id", id)).uniqueResult();
			return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
