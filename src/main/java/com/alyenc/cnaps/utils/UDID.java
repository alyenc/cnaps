package com.alyenc.cnaps.utils;

import java.util.UUID;

public class UDID {

	public static String getUDID(){
		UUID uuid = UUID.randomUUID();
        String udid = uuid.toString().replaceAll("-", "");
		return udid;
		
	}
}

