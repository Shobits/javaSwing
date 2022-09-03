package org.example.layout;

import java.awt.*;
//-Dfile.encoding=GBK
public class BorderLayoutDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试BorderLayoutDemo2");

        //1. 设置BorderLayout布局
        frame.setLayout(new BorderLayout(30, 10));
        //2. 往frame指定区域添加组件
        frame.add(new Button("北方测试"), BorderLayout.NORTH);
        frame.add(new Button("南方测试"), BorderLayout.SOUTH);
        frame.add(new Button("中方测试"), BorderLayout.CENTER);

        frame.add(new TextField("测试文本框"));

        Panel panel = new Panel();
        panel.add(new Button("中间按钮"));
        panel.add(new TextField("测试文本框"));

        frame.add(panel);

        frame.pack();
        //frame.setLocation(560,240);
        //居中显示
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
