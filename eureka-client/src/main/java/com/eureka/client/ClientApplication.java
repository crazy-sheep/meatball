package com.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    //笔记:
    //      在springCloud的项目中, 负载均衡器Ribbon会默认到Eureka Client 的服务注册列表中获取服务信息,并缓存一份
    //根据缓存的服务注册列表信息,可以通过LoadBalancerClient 来选择不同的服务实例,从而实现负载均衡
    //      如果禁止 Ribbon 从 Eureka 获取注册信息,则需要自己维护一份服务注册列表信息,最终实现负载均衡,具体示例可以查看 ribbon-client module
    //
    //
    //
    //
    //
    //
    //

}
