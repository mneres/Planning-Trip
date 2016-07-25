package com.planning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String error() {
		return "get error";
	}

}
