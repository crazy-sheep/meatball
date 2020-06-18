package com.eureka.ribbon.controller;

import com.eureka.ribbon.service.RibbonService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RibbonController {
    @Resource
    private RibbonService ribbonService;
    @Resource
    private LoadBalancerClient loadBalancerClient;
    public RibbonController(RibbonService ribbonService) {
        this.ribbonService = ribbonService;
    }

    /**
     * 多次请求 调用轮询调用不同端口服务
     * @param name
     * @return
     */
    @GetMapping("/hi")
    public String hi(@RequestParam(required = false, defaultValue = "疯狂的绵羊") String name){
        return ribbonService.hi(name);
    }

    /**
     * loadBalancerClient.choose()方法选择调用端口,详情看ribbon-client module
     * @return
     */
    //@GetMapping("/testRibbon")
    //public String testRibbon(){
    //    ServiceInstance instance = loadBalancerClient.choose("eureka-client");
    //    return instance.getHost() + ":" + instance.getPort();
    //}
}
