package com.weather.predictor;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins="*")
@RestController
public class WeatherPredictorApiController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value = "/city", produces = { "application/json" })
	public String getWeather() {
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(1487246400);
		System.out.println(date);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		final String ROOT_URI = "https://samples.openweathermap.org/data/2.5/forecast?q=London,us&appid=d2929e9483efc82c82c32ee7%20e02d563e";
		ResponseEntity<String> response = restTemplate.exchange(ROOT_URI, HttpMethod.GET, entity, String.class);
		return response.getBody();
	}
}
