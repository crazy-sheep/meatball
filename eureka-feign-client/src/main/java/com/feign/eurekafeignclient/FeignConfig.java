package com.feign.eurekafeignclient;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 重写 FeignClientsCongfiguration 类中的 Bean
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer feignRetryer(){
        //参数: 100:重试间隔时间毫秒,1:最大重试时间1秒,5:重试次数
        return new Retryer.Default(100,SECONDS.toMillis(1),5);
    }
}
