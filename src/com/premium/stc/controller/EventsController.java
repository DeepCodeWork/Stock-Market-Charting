package com.premium.stc.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.premium.stc.model.StockPriceDetail;
import com.premium.stc.service.CompanyServiceInterface;
import com.premium.stc.service.EventsServiceInterface;

@Controller
public class EventsController {

	@Autowired
	EventsServiceInterface eventsServiceInterface;
	
	@Autowired
	CompanyServiceInterface companyServiceInterface;

	@GetMapping("/")
	public String x() {
		return "file";
	}

	@PostMapping("ab")
	public void importData(@RequestParam("file") MultipartFile fileAddress) throws IOException, InvalidFormatException {

		//Checking the extensions of file for.xlsx)
		if (fileAddress.getOriginalFilename().endsWith(".xlsx")) {
			XSSFWorkbook workbook = new XSSFWorkbook(fileAddress.getInputStream());
			XSSFSheet worksheet = workbook.getSheetAt(0);
			//Checking the column names(companycode,StockExchange,currentprice,date,time are allowed respectively) 
			if(!checkFormat(worksheet.getRow(0),null,1)) {
				System.out.println("Worksheet not correct");
				workbook.close();
				return;
			}else {
				System.out.println("Correct file");
			}
			//Reading the excel file
			int i = 1;
			while (i <= worksheet.getLastRowNum()) {
				XSSFRow row = worksheet.getRow(i++);
				eventsServiceInterface.importData(setStockObject(row, null, 1));
			}
			//Closing the workbook stream
			workbook.close();
			
		} else if (fileAddress.getOriginalFilename().endsWith(".xls")				//Checking the extensions of file for.xlsx)
				&& !fileAddress.getOriginalFilename().endsWith(".xlsx")) {
			HSSFWorkbook workbook = new HSSFWorkbook(fileAddress.getInputStream());
			HSSFSheet worksheet = workbook.getSheetAt(0);

			//Checking the column names(companycode,StockExchange,currentprice,date,time are allowed respectively) 
			if(!checkFormat(null,worksheet.getRow(0),2)) {
				System.out.println("Worksheet not correct");
				workbook.close();
				return;
			}else {
				System.out.println("Correct file");
			}

			//Reading the excel file
			int i = 1;
			while (i <= worksheet.getLastRowNum()) {
				HSSFRow row = worksheet.getRow(i++);
				eventsServiceInterface.importData(setStockObject(null, row, 2));
			}
			//Closing the workbook stream
			workbook.close();
		}


	}

	static ArrayList<String> dublicateDataList = new ArrayList<String>();
	// Setting the object for stock price details model class
	public StockPriceDetail setStockObject(XSSFRow XSSFrow, HSSFRow HSSFrow, int index) {
		StockPriceDetail stockPriceDetails = new StockPriceDetail();
		
		if (index == 1){
			String data = dateToString(XSSFrow.getCell(3).getDateCellValue())+XSSFrow.getCell(0).getStringCellValue();
				if(checkDublicateData(dublicateDataList, data)&&(checkCompany(XSSFrow.getCell(0).getStringCellValue())))
				{
					stockPriceDetails.setCompanyCode(XSSFrow.getCell(0).getStringCellValue());
					stockPriceDetails.setStockExchange((int) XSSFrow.getCell(1).getNumericCellValue());
					stockPriceDetails.setCurrentPrice((float) XSSFrow.getCell(2).getNumericCellValue());
					stockPriceDetails.setDate(XSSFrow.getCell(3).getDateCellValue());
					// stockPriceDetails.setTime(((XSSFrow.getCell(4).getDateCellValue()));
				}else {
					System.out.println("null xslx object");
					return null;
				}
		} else if (index == 2) {
			String data = dateToString(HSSFrow.getCell(3).getDateCellValue())+HSSFrow.getCell(0).getStringCellValue();
			if(checkDublicateData(dublicateDataList, data)&&checkCompany(HSSFrow.getCell(0).getStringCellValue()))
			{
				stockPriceDetails.setCompanyCode(HSSFrow.getCell(0).getStringCellValue());
				stockPriceDetails.setStockExchange((int) HSSFrow.getCell(1).getNumericCellValue());
				stockPriceDetails.setCurrentPrice((float) HSSFrow.getCell(2).getNumericCellValue());
				stockPriceDetails.setDate(HSSFrow.getCell(3).getDateCellValue());
				// stockPriceDetails.setTime(HSSFrow.getCell(4).getStringCellValue());	
			}else {
				return null;
			}
		
	}
		return stockPriceDetails;
	}




	//Function for Checking the format
	public boolean checkFormat(XSSFRow XSSFrow,HSSFRow HSSFrow,int index) {

		String columnName="";
		if(index==1) { 
			for(int i =0;i<5;i++){
				columnName = columnName+ XSSFrow.getCell(i).getStringCellValue().trim();
			}
			if(columnName.equalsIgnoreCase("companycodestockexchangecurrentpricedatetime")) 
				return true;
		}else {
			for(int i =0;i<5;i++){
				columnName = columnName+ HSSFrow.getCell(i).getStringCellValue().trim();
			}
			if(columnName.equalsIgnoreCase("companycodestockexchangecurrentpricedatetime")) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkCompany(String companyCode) {
	return companyServiceInterface.checkCompany(companyCode);	
	}
	
	
	public static boolean checkDublicateData(ArrayList<String> dublicateDataList,String data) {
		if(dublicateDataList.contains(data))
			return false;
		else
		dublicateDataList.add(data);
		return true;
		
	}
	
	public String dateToString(Date date) { 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		String strDate = dateFormat.format(date); 
		return strDate;
	}
}
