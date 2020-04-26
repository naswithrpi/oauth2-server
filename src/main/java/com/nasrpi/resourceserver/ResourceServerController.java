/**
 * Copyright nasrpi 2020
 */
package com.nasrpi.resourceserver;

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
public class ResourceServerController {
	
	@Autowired ResourceServerRepository resourceServerRepository;
	
	@RequestMapping(value = "/getResources", method = RequestMethod.POST)
	public GetResourceModel getResources(@RequestBody final String access_token) {
		return resourceServerRepository.getResources(access_token);
	}
}
