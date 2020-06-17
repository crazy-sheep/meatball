package com.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class testController {
    @Value("${server.port}")
    private String port;
    @GetMapping("/hi/{name}")
    public String home(@PathVariable String name){
        return name + ":端口号是" + port;
    }

}
