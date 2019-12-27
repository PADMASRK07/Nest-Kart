package com.nestkart.backend.DAOImp;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nestkart.backend.DAO.AddressDAO;
import com.nestkart.backend.Model.Address;


@Repository("addressdao")
@Transactional
public class AddressDAOImpl implements AddressDAO {

	@Autowired
	SessionFactory sf;

	public boolean add(Address b) {
		try {
			sf.getCurrentSession().save(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean update(Address b) {
		try {
			sf.getCurrentSession().update(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean delete(Address b) {
		try {
			sf.getCurrentSession().delete(b);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean DeleteAll() {
		ArrayList<Address> b1;
		try {
			b1 = (ArrayList<Address>) sf.getCurrentSession().createQuery("from Address").list();
			Iterator<Address> i = b1.listIterator();
			while (i.hasNext()) {
				Address nest = (Address) i.next();
				sf.getCurrentSession().delete(nest);
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public ArrayList<Address> selectAll() {
		ArrayList<Address> b;
		try {
			b = (ArrayList<Address>) sf.getCurrentSession().createQuery("from Address").list();
			if (b.isEmpty())
				return null;
			else
				return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Address selectOne(int id) {
		Address b;
		try {
			b = (Address) sf.getCurrentSession().createCriteria(Address.class).add(Restrictions.eq("add_id", id)).uniqueResult();
			return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
