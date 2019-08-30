package com.madhav.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.madhav.publisher.Publisher;

@RestController("/")
public class MyController {

	@Value("${name}")
	private String name;
	
	@Autowired
	Publisher publisher;
	
	@GetMapping("/m1")
	public String m1() {
		return name;
	}
	@GetMapping("send/{msg}")
	public String sendMessage(@PathVariable String msg) {
		publisher.produceMessage(msg);
		return "message is "+msg+ publisher;
	}
}
