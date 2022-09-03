package org.example.layout;

import java.awt.*;

public class FlowLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("测试FlowLayout");

        //1. 通过setLayout方法去设置布局管理器
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        //2. 添加多个按钮到Frame中
        for (int i = 0; i < 100; i++) {
            frame.add(new Button("按钮 " + (i + 1)));
        }
        //3. 设置最佳大小
        frame.pack();

        frame.setVisible(true);
    }
}
