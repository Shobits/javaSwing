package org.example.container;

import java.awt.*;

public class WindowsDemo {
    public static void main(String[] args) {
        //1. 创建一个窗口对象
        Frame frame = new Frame("测试Windows窗口");
        //2. 指定窗口的位置，大小
        frame.setLocation(560, 240);
        frame.setSize(800, 600);
        //3. 设置窗口可见
        frame.setVisible(true);
    }
}
