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

}
