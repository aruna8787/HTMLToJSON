package com.aruna.services;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.google.common.io.Files;


import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.aruna.dao.Invoice;
import com.google.common.base.Charsets;

public class HTMLParserService {
	
	
	public static void main(String[] args) throws IOException, ParseException {
		
		String filename =null;
		String jsonfileName =null;
		//select html file
		try {
			JFrame jframe =new JFrame();
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(jframe);
			if (result == JFileChooser.APPROVE_OPTION) {
			    File selectedFile = fileChooser.getSelectedFile();
			    filename = selectedFile.getAbsolutePath();
			    jsonfileName= filename.replaceFirst("[.][^.]+$", "");
			    System.out.println(jsonfileName);
			}
	        }catch(Exception e) {
	        	System.out.println("please select a HTML file");
	        }
		//reading file data
		File file = new File(filename);
		String content = Files.toString(file, Charsets.UTF_8);
		Document doc=Jsoup.parse(content);
		
		String date =doc.body().getElementsMatchingOwnText("Date").text();
		String reference = doc.body().getElementsMatchingOwnText("Invoice #").text();
		String amount =doc.body().getElementsMatchingOwnText("Grand Total").text();
		String currency ="USD";
		//extracting invoice reference
		if(reference.contains("Invoice")) {
		String[] inv = reference.split(":");
		if(inv.length > 1) {
		reference =inv[1].trim();
		}}
		//extracting date 
		if(date.contains("Date")) {
			String[] d =date.split(":");
			if(d.length > 1) {
			date =d[1].trim();
			}}
		//extracting amount 
		
		if(amount.contains("Grand Total")) {
			
			String[] d = amount.split(":");
			if(d.length > 1 && d[1].trim().startsWith("$")) {
			amount =d[1].trim().substring(1);
			if(amount.matches("([0-9].*[A-Z])")) {
				String temp[] = amount.split(" ");
				if(temp.length > 1) {
					amount =temp[0];
					currency = temp[1];
				}
			}
			}}
		
		System.out.println(reference);
		System.out.println(date);
		System.out.println(amount);
		System.out.println(currency);
		
		
		
		Invoice invoice =new Invoice(reference,currency, ParseDate.getDate(date),amount);
		System.out.println(invoice.getInvoice().toString());
		JSONObject jsonObject =invoice.getInvoice();
		FileWriter file1=null;
		try {
			//writing data to json file
			file1 = new FileWriter(jsonfileName+".json");

	        file1.write(jsonObject.toJSONString());
	       
			System.out.println("successfull");
		}catch(Exception e) {
			
			
			
		}finally { file1.close();}
		
		
		
			}
		
		
		
	}


