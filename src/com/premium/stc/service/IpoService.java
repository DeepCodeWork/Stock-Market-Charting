package com.premium.stc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.premium.stc.dao.IpoDaoInterface;
import com.premium.stc.model.IpoDetails;

@Service
@Transactional
public class IpoService implements IpoServiceInterface{

	@Autowired
	IpoDaoInterface ipoDaoInterface;
	
	@Override
	public int addIpo(IpoDetails ipoData) {
		return ipoDaoInterface.addIpo(ipoData);
	}

}
