package com.premium.stc.dao;

import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import com.premium.stc.model.StockPriceDetail;



@Repository
public class EventsDao implements EventsDaoInterface {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void importData(StockPriceDetail stockPriceDetail) throws IOException, InvalidFormatException {

		if(stockPriceDetail==null)
			System.out.println("null object");
		else {
		Session session = sessionFactory.getCurrentSession();
		session.save(stockPriceDetail);
		}
	}

	// Setting the object for

}
