/**
 * Copyright nasrpi 2020
 */
package com.nasrpi.resourceserver;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Repository;

/**
 * @author grandolf49
 */
@Repository
public class ResourceServerRepository {

	public GetResourceModel getResources(String access_token) {
		
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(new FileReader(
					"C:\\Users\\Ajay\\Documents\\NAS with RPi\\OAuth2 Server\\src\\main\\resources\\Tokens.json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			System.out.println("in here");
			System.out.println(jsonObject.get("accesstoken").toString());
			System.out.println(access_token);
			
			if(jsonObject.get("accesstoken").toString().equals(access_token)) {
				
				
				
				GetResourceModel getResourceModel = new GetResourceModel();
				JSONParser parser1 = new JSONParser();
				Object obj1 = null;
				
				try {
					obj1 = parser1.parse(new FileReader(
							"C:\\Users\\Ajay\\Documents\\NAS with RPi\\OAuth2 Server\\src\\main\\resources\\Tokens.json"));
					JSONObject jsonObject1 = (JSONObject) obj1;
				
					System.out.println(jsonObject1.get("name").toString());
				getResourceModel.setUserName(jsonObject1.get("name").toString());
				getResourceModel.setUserID(jsonObject1.get("email").toString());
				getResourceModel.setDateOfBirth(jsonObject1.get("dob").toString());
				getResourceModel.setMobileNumber(jsonObject1.get("mobile").toString());
				
				
				}catch(Exception e) {
					e.printStackTrace();
				}
				return getResourceModel;
			}
			else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
			
	}

}
