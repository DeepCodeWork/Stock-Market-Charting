package com.premium.stc.model;

import java.util.Date;

public class IpoDetails {

		private int id;
		private String companyNname;
		private String stockExchange;
		private double pricePerShare;
		private double TotalShare;
		private Date openingDate;
		private String remarks;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCompanyNname() {
			return companyNname;
		}
		public void setCompanyNname(String companyNname) {
			this.companyNname = companyNname;
		}
		public String getStockExchange() {
			return stockExchange;
		}
		public void setStockExchange(String stockExchange) {
			this.stockExchange = stockExchange;
		}
		public double getPricePerShare() {
			return pricePerShare;
		}
		public void setPricePerShare(double pricePerShare) {
			this.pricePerShare = pricePerShare;
		}
		public double getTotalShare() {
			return TotalShare;
		}
		public void setTotalShare(double totalShare) {
			TotalShare = totalShare;
		}
		public Date getOpeningDate() {
			return openingDate;
		}
		public void setOpeningDate(Date openingDate) {
			this.openingDate = openingDate;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
}