package com.premium.stc.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.premium.stc.dao.EventsDaoInterface;
import com.premium.stc.model.StockPriceDetail;


@Service
@Transactional
public class EventsService implements EventsServiceInterface{

	@Autowired
	EventsDaoInterface eventsDaoInterface;
	@Override
	public void importData(StockPriceDetail stockPriceDetail) throws IOException, InvalidFormatException {
		eventsDaoInterface.importData(stockPriceDetail);
	}
	

}
