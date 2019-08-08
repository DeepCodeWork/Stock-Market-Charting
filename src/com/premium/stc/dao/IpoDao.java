package com.premium.stc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.premium.stc.model.IpoDetails;

@Repository
public class IpoDao implements IpoDaoInterface {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public int addIpo(IpoDetails ipoData) {
		Session session = sessionFactory.getCurrentSession();
		try {
			int result = (int)session.save(ipoData);
			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
}
