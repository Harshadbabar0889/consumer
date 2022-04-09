package com.example.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumer.model.Country;
import com.example.consumer.service.ConsumerService;

@RestController
public class ConsumerController {
	
	@Autowired
	ConsumerService service;

	@GetMapping("/getCountriesList")
	public ResponseEntity<Country[]> getVehicles(){
		return service.getCountries();
	}
}
