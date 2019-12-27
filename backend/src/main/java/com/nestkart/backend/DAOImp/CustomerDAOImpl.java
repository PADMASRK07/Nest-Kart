package com.nestkart.backend.DAOImp;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nestkart.backend.DAO.CustomerDAO;
import com.nestkart.backend.Model.Customer;

@Repository("customerdao")
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	SessionFactory sf;

	public boolean add(Customer b) {
		try {
			sf.getCurrentSession().save(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean update(Customer b) {
		try {
			sf.getCurrentSession().update(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean delete(Customer b) {
		try {
			sf.getCurrentSession().delete(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean DeleteAll() {
		ArrayList<Customer> b1;
		try {
			b1 = (ArrayList<Customer>) sf.getCurrentSession().createQuery("from Customer").list();
			Iterator<Customer> i = b1.listIterator();
			while (i.hasNext()) {
				Customer nest = (Customer) i.next();
				sf.getCurrentSession().delete(nest);
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public ArrayList<Customer> selectAll() {
		ArrayList<Customer> b;
		try {

			b = (ArrayList<Customer>) sf.getCurrentSession().createQuery("from Customer").list();
			if (b.isEmpty())
				return null;
			else
				return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Customer selectOne(int id) {
		Customer b;
		try {
			b = (Customer) sf.getCurrentSession().createCriteria(Customer.class).add(Restrictions.eq("cus_id", id))
					.uniqueResult();
			return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
