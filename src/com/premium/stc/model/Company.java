package com.premium.stc.model;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotEmpty;

public class Company {
	
	@NotEmpty
	@Column(name="companyName",unique = true)
	private String companyName;
	
	@NotEmpty
	@Column(name="companyCode",unique = true)
	private String companyCode;
	
	@NotEmpty
	@Column(name="tunrOver")
	private float tunrOver;
	
	@NotEmpty
	@Column(name="ceoName")
	private String ceoName;
	
	/*
	 * @NotEmpty
	 * 
	 * @Column(name="companyName") private ArrayList<String> boardOfDirectors;
	 */
	
	@NotEmpty
	@Column(name="stockExchange")
	private String stockExchange;
	
	@NotEmpty
	@Column(name="sectorId")
	private int sectorId;
	
	@NotEmpty
	@Column(name="writeup")
	private String writeup;
	
	@NotEmpty
	@Column(name="stockCode")
	private int stockCode;
	
	@Column(columnDefinition="tinyint(1) default 0")
	private boolean activated;
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public float getTunrOver() {
		return tunrOver;
	}
	public void setTunrOver(float tunrOver) {
		this.tunrOver = tunrOver;
	}
	public String getCeoName() {
		return ceoName;
	}
	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
	
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public int getSectorId() {
		return sectorId;
	}
	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}
	public String getWriteup() {
		return writeup;
	}
	public void setWriteup(String writeup) {
		this.writeup = writeup;
	}
	public int getStockCode() {
		return stockCode;
	}
	public void setStockCode(int stockCode) {
		this.stockCode = stockCode;
	}
	
	
}
