package com.premium.stc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.premium.stc.model.Company;

@Repository
public class CompanyDao implements CompanyDaoInterface {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int saveOrUpdateCompany(Company company,int index) {
		try {
			Session session = sessionFactory.getCurrentSession();
			if(index==1) {
				int x = (int)session.save(company);
				return x;
			}else {
				session.update(company);
				return 1;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return 0;
	}

	@SuppressWarnings("rawtypes")
	public int deactivateCompanyById(String companyId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String updateHqlQuery = "from Company set activated = ? where companyId=? ";
			Query query = session.createQuery(updateHqlQuery)
					.setParameter(0, 0)
					.setParameter(1, companyId);
			int result = query.executeUpdate();
			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkCompany(String companyCode) {
		try {
			Session session = sessionFactory.getCurrentSession();
			List<Company> companyList = session.createQuery("from Company where compnayCode=?").setParameter(0, companyCode).list();
			if(companyList.size()!=0&&companyList!=null)
			{
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
