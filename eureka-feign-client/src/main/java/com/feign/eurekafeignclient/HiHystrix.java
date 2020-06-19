package com.feign.eurekafeignclient;

import org.springframework.stereotype.Component;

@Component
public class HiHystrix implements EurekaClientFeign{
    @Override
    public String testClientEureka(String name) {
        return "hi," + name + ",服务出现异常,请联系管理员";
    }
}
