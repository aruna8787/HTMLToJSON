package com.aruna.services;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
//this class is just to parse date
public class ParseDate {

	static String[] DateFormats =
		{
		      "yyyy.MM.dd G 'at' HH:mm:ss z",
		      "EEE, MMM d, ''yy",
		      "h:mm a",
		      "hh 'o''clock' a, zzzz",
		      "K:mm a, z",
		      "yyyyy.MMMMM.dd GGG hh:mm aaa",
		      "EEE, d MMM yyyy HH:mm:ss Z",
		      "yyMMddHHmmssZ",
		      "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
		      "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
		      "YYYY-'W'ww-u",
		      "EEE, dd MMM yyyy HH:mm:ss z", 
		      "EEE, dd MMM yyyy HH:mm zzzz",
		      "yyyy-MM-dd'T'HH:mm:ssZ",
		      "MMMM d, u",
		      "yyyy-MM-dd'T'HH:mm:ss.SSSzzzz", 
		      "yyyy-MM-dd'T'HH:mm:sszzzz",
		      "yyyy-MM-dd'T'HH:mm:ss z",
		      "yyyy-MM-dd'T'HH:mm:ssz", 
		      "yyyy-MM-dd'T'HH:mm:ss",
		      "yyyy-MM-dd'T'HHmmss.SSSz",
		      "yyyy-MM-dd",
		      "yyyyMMdd",
		      "dd/MM/yy",
		      "dd/MM/yyyy"
		};	
public ParseDate(){}

public static Date getDate(String date) throws ParseException {
	
	Date date1= DateUtils.parseDate(date, DateFormats);
	return date1;
}



	
}
