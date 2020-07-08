package com.demo.meatball.设计模式.原型模式.demo2;

public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation citation = new Citation("张三", "同学：在2020学年第一学期中表现优秀，被评为三好学生。", "学院");
        System.out.println("====================》"+citation.getName());
        Citation citation2 = citation.clone();
        citation2.setName("李四");
        System.out.println("====================》"+citation2.getName());
    }
}
