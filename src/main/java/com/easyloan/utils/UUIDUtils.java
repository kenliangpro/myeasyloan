package com.easyloan.utils;

import java.util.UUID;

public class UUIDUtils {
	
	public static String toPrimaryKey(){
		String uuid = UUID.randomUUID().toString();
		return uuid.replace("-", "");
	} 
	
	
	
	
}
