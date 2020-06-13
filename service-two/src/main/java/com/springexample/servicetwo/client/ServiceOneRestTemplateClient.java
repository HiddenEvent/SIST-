package com.springexample.servicetwo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServiceOneRestTemplateClient {
    
	@Autowired
    RestTemplate restTemplate;

    public String getTimeString() {
        ResponseEntity<String> restExchange =
                restTemplate.exchange(
                        "http://serviceone/get-time-string",
                        HttpMethod.GET,
                        null, String.class);

        return restExchange.getBody();
    }
}
