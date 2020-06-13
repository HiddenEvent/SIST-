package com.springexample.servicetwo.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("serviceone")
public interface ServiceOneFeignClient {
    @RequestMapping(
            method= RequestMethod.GET,
            value="/get-time-string",
            consumes="application/json")
    String getTimeString();
}
