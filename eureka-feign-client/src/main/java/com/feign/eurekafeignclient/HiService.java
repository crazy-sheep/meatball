package com.feign.eurekafeignclient;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Service
public class HiService {
    @Resource
    private EurekaClientFeign eurekaClientFeign;
    public String syaGoodbye(String name){
        return eurekaClientFeign.testClientEureka(name);
    }
}
