package com.demo.meatball.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Api
@RestController
public class HelloController {

    @ApiOperation(value = "测试",notes = "测试")
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String hello(){
        return "你好!哈哈!";
    }
    @ApiOperation(value = "获取指定网址html",notes = "html信息")
    @RequestMapping(value = "/getHtml",method = RequestMethod.POST)
    public String getHtml(@RequestBody String url){
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(url, String.class);
        return forObject;
    }
}
