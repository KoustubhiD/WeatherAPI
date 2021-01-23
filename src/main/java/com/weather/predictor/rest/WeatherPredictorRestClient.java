package com.weather.predictor.rest;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class WeatherPredictorRestClient {
	
	@Autowired
	RestTemplate restTemplate;

	public String getWeatherDetails() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		
		
		final String ROOT_URI = "https://samples.openweathermap.org/data/2.5/forecast?q=London,us&appid=d2929e9483efc82c82c32ee7%20e02d563e";
		ResponseEntity<String> response = restTemplate.exchange(ROOT_URI, HttpMethod.GET, entity, String.class);
		/*
		 * String responseBody = response.getBody();
		 * 
		 * ResponseEntity<String> response = restTemplate.getForEntity(ROOT_URI,
		 * String.class);
		 */
		return response.getBody();
 }
	public Weather getByName(String name) {
		final String ROOT_URI = "https://samples.openweathermap.org/data/2.5/forecast?q=London,us&appid=d2929e9483efc82c82c32ee7%20e02d563e";
		ResponseEntity<Weather> response = restTemplate.getForEntity(ROOT_URI + "/"+name, Weather.class);
		return response.getBody();
	}
}
