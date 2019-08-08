package com.premium.stc.service;

import com.premium.stc.model.Company;

public interface CompanyServiceInterface {

	public int saveOrUpdateCompany(Company company,int index);
	public int deactivateCompanyById(String companyId);
}
