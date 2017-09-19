package com.easyloan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
	
	public static Date formatDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date_str = simpleDateFormat.format(new Date());
		try {
			return simpleDateFormat.parse(date_str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
