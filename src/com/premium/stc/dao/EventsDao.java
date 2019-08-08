package com.premium.stc.dao;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.jni.Local;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.premium.stc.model.StockPriceDetail;

import javafx.util.converter.LocalTimeStringConverter;

import java.sql.*;
@Repository
public class EventsDao implements EventsDaoInterface{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void importData(MultipartFile fileAddress) throws IOException,InvalidFormatException{
		
		
		System.out.println(fileAddress);
		if(fileAddress.getOriginalFilename().endsWith(".xlsx"))
		{
			XSSFWorkbook workbook = new XSSFWorkbook(fileAddress.getInputStream());
			int i =1;
			XSSFSheet worksheet = workbook.getSheetAt(0);
			while (i <= worksheet.getLastRowNum()) {
				XSSFRow row = worksheet.getRow(i++);
				setStockObject(row, null , 1);
			}
			workbook.close();
		}else if(fileAddress.getOriginalFilename().endsWith(".xls")&&!fileAddress.getOriginalFilename().endsWith(".xlsx")){
			System.out.println(fileAddress.getOriginalFilename());
			HSSFWorkbook workbook = new HSSFWorkbook(fileAddress.getInputStream());
			System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
			int i =0;
			HSSFSheet worksheet = workbook.getSheetAt(0);
			while (i <= worksheet.getLastRowNum()) {
				HSSFRow row = worksheet.getRow(i++);
				setStockObject(null, row, 2);
			}
			
			workbook.close();
		}

	}
	
	//Setting the object for 
	public void setStockObject(XSSFRow XSSFrow,HSSFRow HSSFrow,int index) {
		StockPriceDetail stockPriceDetails = new StockPriceDetail();
		if(index==1) {
			stockPriceDetails.setCompanyCode(XSSFrow.getCell(0).getStringCellValue());
			stockPriceDetails.setStockExchange((int)XSSFrow.getCell(1).getNumericCellValue());
			stockPriceDetails.setCurrentPrice((float)XSSFrow.getCell(2).getNumericCellValue());
			stockPriceDetails.setDate(XSSFrow.getCell(3).getDateCellValue());
			//stockPriceDetails.setTime(((XSSFrow.getCell(4).getDateCellValue()));
			Session session = sessionFactory.getCurrentSession();
			session.save(stockPriceDetails);
		}else if(index==2) {
			stockPriceDetails.setCompanyCode(HSSFrow.getCell(0).getStringCellValue());
			stockPriceDetails.setStockExchange((int)HSSFrow.getCell(1).getNumericCellValue());
			stockPriceDetails.setCurrentPrice((float)HSSFrow.getCell(2).getNumericCellValue());
			stockPriceDetails.setDate(HSSFrow.getCell(3).getDateCellValue());
			//stockPriceDetails.setTime(HSSFrow.getCell(4).getStringCellValue());
			Session session = sessionFactory.getCurrentSession();
			session.save(stockPriceDetails);
		}
	}
}
