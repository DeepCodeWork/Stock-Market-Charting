package com.premium.stc.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.validator.constraints.NotEmpty;

public class StockExchange {

		@NotEmpty
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int stockExchangeId;
		
		@NotEmpty
		@Column(name="stockExchange",unique = true)
		private String stockExchange;
		
		@NotEmpty
		@Column(name="stockExchangeCode",unique = true)
		private String stockExchangeCode;
		
		@NotEmpty
		@Column(name="brief",unique = true)
		private String brief;
		
		@NotEmpty
		@Column(name="stockExchageAddress",unique = true)
		private String stockExchageAddress;
		
		@NotEmpty
		@Column(name="remarks")
		private String remarks;
		
		
		
		public String getStockExchangeCode() {
			return stockExchangeCode;
		}
		public void setStockExchangeCode(String stockExchangeCode) {
			this.stockExchangeCode = stockExchangeCode;
		}
		
		public int getStockExchangeId() {
			return stockExchangeId;
		}
		public void setStockExchangeId(int stockExchangeId) {
			this.stockExchangeId = stockExchangeId;
		}
		public String getStockExchange() {
			return stockExchange;
		}
		public void setStockExchange(String stockExchange) {
			this.stockExchange = stockExchange;
		}
		public String getBrief() {
			return brief;
		}
		public void setBrief(String brief) {
			this.brief = brief;
		}
		public String getStockExchageAddress() {
			return stockExchageAddress;
		}
		public void setStockExchageAddress(String stockExchageAddress) {
			this.stockExchageAddress = stockExchageAddress;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
}
