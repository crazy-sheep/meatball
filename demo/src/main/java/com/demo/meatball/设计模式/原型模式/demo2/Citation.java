package com.demo.meatball.设计模式.原型模式.demo2;


//原型模式很简单，关键在于   1、类的属性通用型不可变，只有极个别需要更改
//                      2、类中有个clone()方法，类并实现Cloneable接口

public class Citation implements Cloneable{
    private String name;
    private String info;
    private String college;

    public Citation(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Citation clone() throws CloneNotSupportedException {
        System.out.println("奖状拷贝成功！");
        return (Citation)super.clone();
    }
    //============================原型模式只需改name，不需其他(根据需求自定)
    /*public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }*/
}
