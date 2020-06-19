package com.feign.eurekafeignclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HiController {
    @Resource
    private HiService hiService;
    @GetMapping("/hi")
    public String syaGoodbye(@RequestParam(required = false,defaultValue = "疯狂的绵羊") String name){
        return  hiService.syaGoodbye(name);
    }
}
