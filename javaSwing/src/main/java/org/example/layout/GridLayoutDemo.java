package org.example.layout;

import java.awt.*;

//-Dfile.encoding=GBK
public class GridLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("测试 GridLayoutDemo 计算器");

        //创建panel对象，存放一个textFiled对象
        Panel panel1 = new Panel();
        panel1.add(new TextField(30));
        //将这个panel放在Frame北区域
        frame.add(panel1, BorderLayout.NORTH);
        //创建一个panel对象，并创建GridLayout布局
        Panel panel2 = new Panel();
        panel2.setLayout(new GridLayout(3, 5, 4, 4));
        //添加panel内容
        for (int i = 0; i < 10; i++) {
            panel2.add(new Button(i + ""));
        }
        panel2.add(new Button("+"));
        panel2.add(new Button("-"));
        panel2.add(new Button("*"));
        panel2.add(new Button("/"));
        panel2.add(new Button("."));

        //panel添加到 frame中
        frame.add(panel2, BorderLayout.CENTER);

        frame.pack();
        //frame.setLocation(560,240);
        //居中显示
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
