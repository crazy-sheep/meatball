# meatball
<P style="color: #ffb6c1">注意:仅供学习交流,喜欢的帮忙点颗小星星</P>

串联整个springCloud 生态 整合当前热门技术

一、demo module

    1.spring Boot 整合JPA
    
    2.spring Boot 整合Redis
    
    3.spring Boot 整合Swagger2
    
    4.设计模式示例
        com.demo.meatball.factory 工厂模式示例
        
    5.语音 转换 文字小demo
    
    6.录制功能和推流功能测试阶段

二、eureka-client eureka-server module

    1.服务的注册与发现 Eureka示例

三、ribbon-client module

    1.负载均衡 Ribbon示例,使用RestTemplate 和 Ribbon 消费服务
四、eureka-feign-client module
    
    feign实现过程:
        1.通过@EableFeignClients 注解 开启FeignClient功能,有这个注解,程序会在启动时开启对@FeignClient注解
        2.根据Feign 的规则实现接口,并在接口上面加上@FeignClient 注解
        3.启动容器后,会进行包扫描,扫描所有@FeignClient的注解类,并将这些信息注入IoC容器中
        4.当接口的方法被调用,通过JDK的代理来生成具体的RequestTempplate 模板对象
        5根据RequestTempplate 再生成Http请求的Request对象
        6.Request 对象交给Client 去处理,
        7.最后Client被封装到LoadBalanceClient类,这个类结合类Ribbon做到负载均衡
待做、 JFrame简单使用(//todo)










last:个人笔记:

    eureka:只是服务端与客户端
    
    ribbon:具体 负载均衡 的操作是ribbon在做
    
    feign:具有远程调用功能,并且具有负载均衡能力,因为feign起步依赖,默认引入Ribbon 和 Hystrix(熔断器) 依赖
    