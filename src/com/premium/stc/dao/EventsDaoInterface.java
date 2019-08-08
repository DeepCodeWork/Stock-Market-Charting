package com.premium.stc.dao;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import com.premium.stc.model.StockPriceDetail;

public interface EventsDaoInterface {

	public void importData(StockPriceDetail stockPriceDetails) throws IOException,InvalidFormatException;
}
