package com.eureka.ribbon.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class RibbonService {
    @Resource
    private RestTemplate restTemplate;


    public String hi(String name){
        return restTemplate.getForObject("http://eureka-client/hi?name="+name,String.class);
    }
}
