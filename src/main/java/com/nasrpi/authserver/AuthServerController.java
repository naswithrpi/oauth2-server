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
}
