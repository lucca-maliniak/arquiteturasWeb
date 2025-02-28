package com.aplicacoesWeb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api") 
public class HelloController {
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello, World!";
	}
}
