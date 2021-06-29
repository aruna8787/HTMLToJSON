package com.aruna.dao;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;

public class Invoice {
	public Invoice(String ref, String currency, Date date, String amount) {
		
		this.ref = ref;
		this.currency = currency;
		this.date = date;
		this.amount = amount;
	}
	String ref;
	String currency;
	Date date;
	String amount;
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public JSONObject getInvoice() {
		
 
		JSONObject jobject =new JSONObject();
		jobject.put("ref", ref);
		jobject.put("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
		jobject.put("currency", currency);
		jobject.put("amount", amount);
		
		return jobject;
		
	}

}
