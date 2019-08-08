package com.premium.stc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.premium.stc.dao.CompanyDaoInterface;
import com.premium.stc.model.Company;


@Service
@Transactional
public class CompanyService implements CompanyServiceInterface {

	@Autowired
	private CompanyDaoInterface companyDaoInterface;
	
	public int saveOrUpdateCompany(Company company,int index) {
		return companyDaoInterface.saveOrUpdateCompany(company, index);
	}

	@Override
	public int deactivateCompanyById(String companyId) {
		return deactivateCompanyById(companyId);
	}
}
