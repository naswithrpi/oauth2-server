/**
 * Copyright nasrpi 2020
 */
package com.nasrpi.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * @author grandolf49
 */
@RestController
@Api
@RequestMapping
public class AuthServerController {
	@Autowired
	private AuthServerRepository authServerRepository;


	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public boolean auth(@RequestBody final String client_id) {
		return authServerRepository.auth(client_id);
	}
	
	@RequestMapping(value = "/getAuthCode", method = RequestMethod.POST)
	public String getAuthCode(@RequestBody final String username, final String password) {
		return authServerRepository.getAuthCode(username, password);
	}
	
	@RequestMapping(value = "/getAccessToken", method = RequestMethod.POST)
	public String getAccessToken(@RequestBody final String auth_code) {
		return authServerRepository.getAccessToken(auth_code);
	}
	
	@RequestMapping(value = "/validateAccessToken", method = RequestMethod.POST)
	public boolean validateAccessToken(@RequestBody final String access_token) {
		return authServerRepository.validateAccessToken(access_token);
	}
}
