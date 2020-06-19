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

二、eureka-client eureka-server module

    1.服务的注册与发现 Eureka示例

三、 ribbon-client module

    1.负载均衡 Ribbon示例,使用RestTemplate 和 Ribbon 消费服务










last:个人笔记:

    eureka:只是服务端与客户端
    
    ribbon:具体 负载均衡 的操作是ribbon在做
    
    feign:具有远程调用功能,并且具有负载均衡能力,因为feign起步依赖,默认引入Ribbon 和 Hystrix(熔断器) 依赖
    