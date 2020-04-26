package com.infy.verizon.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.verizon.service.TravelerService;

@CrossOrigin
@RestController
@RequestMapping("TravelerAPI")
public class TravelerAPI {
	@Autowired
	private TravelerService customerService;
	
	@Autowired
	private Environment environment;
	
	static Logger logger = LogManager.getLogger(TravelerAPI.class.getName());
}
