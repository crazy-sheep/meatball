package com.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class testController {
    @Value("${server.port}")
    private String port;
    @GetMapping("/hi")
    public String home(@RequestParam String name){
        return name + ":端口号是" + port;
    }

}
