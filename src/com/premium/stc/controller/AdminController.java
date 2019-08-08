package com.premium.stc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.premium.stc.model.Company;
import com.premium.stc.model.IpoDetails;
import com.premium.stc.model.StockExchange;
import com.premium.stc.service.AdminServiceInterface;
import com.premium.stc.service.CompanyServiceInterface;
import com.premium.stc.service.IpoServiceInterface;

@Controller
public class AdminController {

	@Autowired
	AdminServiceInterface adminServiceInterface;

	@Autowired
	CompanyServiceInterface companyServiceInterface;
	
	@Autowired
	IpoServiceInterface ipoServiceInterface;
	
	
	//displaying a stock Exchange page
	@GetMapping("addStockExchangePage")
	public ModelAndView addStockExchangePage() {
		return new ModelAndView("addStockPage","stockExchangeData", new StockExchange());
	}
	
	//saving a stock exchange page
	@PostMapping("addStockExchange")
	public ModelAndView addStockExchange(@ModelAttribute("stockExchangeData") StockExchange stockExchangeData) {
		int result = adminServiceInterface.addOrUpdateStockExchange(stockExchangeData,1);
		if(result!=0)
			return new ModelAndView("Success","message","Successfully added");
		else
			return new ModelAndView("404","message","error");
	}
	
	
	//displaying a company page
	@GetMapping("addCompanyPage")
	public ModelAndView addCompanyPage() {
		return new ModelAndView("addCompany","companyData",new Company());
	}
	
	//saving a new company
	@PostMapping("addCompany")
	public ModelAndView addCompany(@ModelAttribute("companyData") Company companyData) {
		int result = companyServiceInterface.saveOrUpdateCompany(companyData, 1);
		if(result!=0)
			return new ModelAndView("Success","message","Successfully added");
		else
			return new ModelAndView("404","message","error");
	}
	
	//Displaying a update company page
	@GetMapping("updateCompanyPage")
	public ModelAndView updateCompanyPage() {
		return new ModelAndView("updateCompanyPage","companyData", new Company());
	}
	
	
	//updating an existing company
	@PostMapping("updatecompany")
	public ModelAndView updateCompany(@ModelAttribute("companyData") Company companyData) {
		int result = companyServiceInterface.saveOrUpdateCompany(companyData, 2);
		if(result!=0)
			return new ModelAndView("Success","message","Successfully added");
		else
			return new ModelAndView("404","message","error");
	}
	
	
	//
	@PostMapping("deactivateCompany")
	public ModelAndView deactivatingCompany(@PathVariable("companyId") String companyId) {
		int result = companyServiceInterface.deactivateCompanyById(companyId);
		if(result>0) 
			return new ModelAndView("success","message","Company deactivated successfully");
		else
			return new ModelAndView("404","message","Company not found");
		
	}
	
	@GetMapping("addingIpoPage")
	public ModelAndView updatingIpoPage() {
		return new ModelAndView("updateIpoPage","ipoData",new IpoDetails());
	}
	
	@PostMapping("addingIpo")
	public ModelAndView updatingIpo(@ModelAttribute("ipoData") IpoDetails ipoData) {
		int result = ipoServiceInterface.addIpo(ipoData);
		if(result>0)
			return new ModelAndView("success","message","added succesfully");
		else
			return new ModelAndView("404","message","Not found");
	}

}
