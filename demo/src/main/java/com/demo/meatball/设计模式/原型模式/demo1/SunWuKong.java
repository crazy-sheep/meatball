package com.demo.meatball.设计模式.原型模式.demo1;

import javax.swing.*;
import java.awt.*;

public class SunWuKong {
    static class SunWukong extends JPanel implements Cloneable
    {
        private static final long serialVersionUID = 5543049531872119328L;
        public SunWukong()
        {
            JLabel l1=new JLabel(new ImageIcon("src/scenery.jpeg"));
            this.add(l1);
        }
        public Object clone()
        {
            SunWukong w=null;
            try
            {
                w=(SunWukong)super.clone();
            }
            catch(CloneNotSupportedException e)
            {
                System.out.println("拷贝悟空失败!");
            }
            return w;
        }
    }
    public static class ProtoTypeWukong {
        public static void main(String[] args) {
            JFrame jf=new JFrame("原型模式测试");
            jf.setLayout(new GridLayout(1,2));
            Container contentPane=jf.getContentPane();
            SunWukong obj1=new SunWukong();
            contentPane.add(obj1);
            SunWukong obj2=(SunWukong)obj1.clone();
            contentPane.add(obj2);
            jf.pack();
            jf.setVisible(true);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}
