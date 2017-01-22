package com.expirit.mqttNode.utill;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	
	public static String getNowDateStringFormat(){
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return format.format(getNowDate());
	}
	
	public static Date getNowDate(){
		return new java.sql.Date(Calendar.getInstance().getTimeInMillis());
	}
}
