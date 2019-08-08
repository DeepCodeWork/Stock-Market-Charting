package com.premium.stc.service;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

public interface EventsServiceInterface {

	public void importData(MultipartFile fileAddress) throws IOException,InvalidFormatException;
}
