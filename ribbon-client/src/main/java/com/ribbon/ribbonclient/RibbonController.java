package com.ribbon.ribbonclient;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RibbonController {
    @Resource
    private LoadBalancerClient loadBalancerClient;
    @GetMapping("/testRibbon")
    public String testRibbon(){
        ServiceInstance instance = loadBalancerClient.choose("stores");
        return instance.getHost() + ":" + instance.getPort();
    }
}
