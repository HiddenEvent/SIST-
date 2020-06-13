package com.springexample.servicetwo.client;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServiceOneDiscoveryClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    public String getTimeString() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("serviceone");

        if (instances.size()==0) return null;
        String serviceUri = String.format("%s/get-time-string",instances.get(0).getUri().toString());
    
        ResponseEntity< String > restExchange =
                restTemplate.exchange(
                        serviceUri,
                        HttpMethod.GET,
                        null, String.class);

        return restExchange.getBody();
    }
}
