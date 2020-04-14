/**
 * Copyright nasrpi 2020
 */
package com.nasrpi.authserver;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Repository;

/**
 * @author grandolf49
 */
@Repository
public class AuthServerRepository {

	public boolean auth(String clientID) {

		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(new FileReader(
					"C:\\Users\\Ajay\\Documents\\NAS with RPi\\OAuth2 Server\\src\\main\\resources\\ClientDetails.json"));
			JSONObject jsonObject = (JSONObject) obj;
			return jsonObject.get("client_id").toString().equals(clientID);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String getAuthCode(String username, String password) {

		JSONParser parser = new JSONParser();
		Object obj = null;
		Object authObj = null;
		
		try {
			obj = parser.parse(new FileReader(
					"C:\\Users\\Ajay\\Documents\\NAS with RPi\\OAuth2 Server\\src\\main\\resources\\UserCredentials.json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			//parse the Tokens.json file to retrieve authorization token
			authObj = parser.parse(new FileReader(
					"C:\\Users\\Ajay\\Documents\\NAS with RPi\\OAuth2 Server\\src\\main\\resources\\Tokens.json"));
			JSONObject jsonAuthObject = (JSONObject) authObj;
			
			if (jsonObject.get("username").toString().equals(username) && jsonObject.get("password").toString().equals(password))
				return jsonAuthObject.get("authcode").toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public String getAccessToken(String authCode) {

		JSONParser parser = new JSONParser();
		Object obj = null;
		
		try {
			obj = parser.parse(new FileReader(
					"C:\\Users\\Ajay\\Documents\\NAS with RPi\\OAuth2 Server\\src\\main\\resources\\Tokens.json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			if (jsonObject.get("authcode").toString().equals(authCode))
				return jsonObject.get("accesstoken").toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public boolean validateAccessToken(String accessToken) {
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(new FileReader(
					"C:\\Users\\Ajay\\Documents\\NAS with RPi\\OAuth2 Server\\src\\main\\resources\\Tokens.json"));
			JSONObject jsonObject = (JSONObject) obj;
			return jsonObject.get("accesstoken").toString().equals(accessToken);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
