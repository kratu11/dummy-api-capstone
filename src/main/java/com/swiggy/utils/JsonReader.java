package com.swiggy.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import lombok.SneakyThrows;

public class JsonReader {
	@SneakyThrows
	public static String returnEmailID() {
		JSONParser jsons = new JSONParser();
	
			
				JSONObject jsonObject = (JSONObject) jsons.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+"/Output/createUserresponse.json")));
				String emailId=(String)jsonObject.get("email");
				return emailId;
			
			
		
	}
	@SneakyThrows
	public static String returnOwnerId() {
		JSONParser jsons = new JSONParser();
	
			
				JSONObject jsonObject = (JSONObject) jsons.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+"/Output/createUserresponse.json")));
				String id=(String)jsonObject.get("id");
				return id;
			
			
		
	}
	@SneakyThrows
	public static String returnPostId() {
		JSONParser jsons = new JSONParser();
	
			
				JSONObject jsonObject = (JSONObject) jsons.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+"/Output/createPostresponse.json")));
				String iD=(String)jsonObject.get("id");
				return iD;
			
			
		
	}


	}
