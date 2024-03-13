package com.onepoint.moduleparsing.service;

import com.onepoint.moduleparsing.dto.Courrier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUpdateService {

	private DateUpdateService() {
	}

	public static void update(Courrier courrier) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
		String today = simpleDateFormat.format(new Date());
		courrier.setDateReception(today);
	}

}
