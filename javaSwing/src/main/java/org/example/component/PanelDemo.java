package org.example.component;

import java.awt.*;

public class PanelDemo {
    public static void main(String[] args) {
        //1. 创建一个window对象
        Frame frame = new Frame("演示PanelDemo");
        //2. 创建一个panel对象
        Panel panel = new Panel();
        //3. 创建一个文本框和一个按钮，并且把他们放入panel中
        panel.add(new TextField(("测试文字")));
        panel.add(new Button("测试按钮"));

        //4.panel放入window中
        frame.add(panel);
        //5.设置windows位置和大小
        //frame.setLocation(560, 240);frame.setSize(800, 600);
        frame.setBounds(560,240,800,600);
        //6.设置Windows可见
        frame.setVisible(true);
    }
}
