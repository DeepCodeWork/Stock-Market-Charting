package com.premium.stc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.premium.stc.model.StockExchange;

@Repository
public class AdminDao implements AdminDaoInterface{

	@Autowired
	SessionFactory sessionFactory;
	
	public int addOrUpdateStockExchange(StockExchange stockExchangeData, int index) {
		try {
			Session session = sessionFactory.getCurrentSession();
			if(index==1&&stockExchangeData!=null){
				int x = (int)session.save(stockExchangeData);
				return x;
			}else if(stockExchangeData!=null) {
				session.update(stockExchangeData);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
		
}
