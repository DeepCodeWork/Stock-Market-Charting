package com.premium.stc.service;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.premium.stc.model.StockPriceDetail;

public interface EventsServiceInterface {

	public void importData(StockPriceDetail stockPriceDetail) throws IOException,InvalidFormatException;
}
