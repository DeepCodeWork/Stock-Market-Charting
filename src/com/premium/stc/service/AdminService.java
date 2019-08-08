package com.premium.stc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.premium.stc.dao.AdminDaoInterface;
import com.premium.stc.model.StockExchange;


@Service
@Transactional
public class AdminService implements AdminServiceInterface{

	@Autowired
	AdminDaoInterface adminDao;

	@Override
	public int addOrUpdateStockExchange(StockExchange stockExchangeData,int index) {
		return adminDao.addOrUpdateStockExchange(stockExchangeData,index);
	}	
}
