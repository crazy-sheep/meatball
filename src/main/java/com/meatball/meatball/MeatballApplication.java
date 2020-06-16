package com.meatball.meatball;

import com.meatball.meatball.factory.Carfactory;
import com.meatball.meatball.factory.NewCar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MeatballApplication {


    public static void main(String[] args) {
        //Carfactory carfactory = new Carfactory();
        //NewCar bmw = carfactory.getCar("dazhong");
        //bmw.newCar();
        SpringApplication.run(MeatballApplication.class, args);
    }


}