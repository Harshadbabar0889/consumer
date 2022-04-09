package com.example.consumer.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.consumer.model.Country;

@Service
public class ConsumerService {

	@Autowired
	RestTemplate template;

	public ResponseEntity<Country[]> getCountries() {
		final String url = "http://localhost:9090/getCountries";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Country[]> response = template.exchange(url, HttpMethod.POST, entity, Country[].class);

		List<Country> products = Arrays.asList(response.getBody());

		System.out.println(products.toString());

		return response;
	}
}
