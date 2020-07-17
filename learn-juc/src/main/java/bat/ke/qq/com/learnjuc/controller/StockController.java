package bat.ke.qq.com.learnjuc.controller;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.ReentrantLock;


@RestController
public class StockController {

    @Autowired
    private Redisson redisson;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ReentrantLock lock;

    @RequestMapping("/reduce_stock")
    public String reduceStock() {

       lock.lock();
        try {
            //查库存    库存超卖
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                // 扣减库存
                stock--;
                stringRedisTemplate.opsForValue().set("stock", stock + "");
                System.out.println("扣减成功，库存stock:" + stock);
            } else {
                System.out.println("扣减失败，库存不足");
            }
        } finally {

            lock.unlock();
        }

        return "end";
    }


    @Bean
    public Redisson redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.3.14:6379").setDatabase(0);
        return (Redisson) Redisson.create(config);
    }

    @Bean
    public ReentrantLock lock(){
        return new ReentrantLock();
    }

}
