package com.premium.stc.model;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StockPriceDetail")
public class StockPriceDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockPriceDetailsID;
	private String companyCode;
	private int stockExchange;
	private float currentPrice;
	private Date date;
	private Time time;
	
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public int getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(int stockExchange) {
		this.stockExchange = stockExchange;
	}
	public float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getStockPriceDetailsID() {
		return stockPriceDetailsID;
	}
	public void setStockPriceDetailsID(int stockPriceDetailsID) {
		this.stockPriceDetailsID = stockPriceDetailsID;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	
	
}
