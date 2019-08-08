package com.premium.stc.dao;

import com.premium.stc.model.Company;

public interface CompanyDaoInterface {

		public int saveOrUpdateCompany(Company company,int index);
		public int deactivateCompanyById(String companyId);
}
