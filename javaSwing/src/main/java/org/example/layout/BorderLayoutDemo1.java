package org.example.layout;

import java.awt.*;

public class BorderLayoutDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试BorderLayoutDemo1");

        //1. 设置BorderLayout布局
        frame.setLayout(new BorderLayout(30,10));
        //2. 往frame指定区域添加组件
        frame.add(new Button("北方测试"),BorderLayout.NORTH);
        frame.add(new Button("南方测试"),BorderLayout.SOUTH);
        frame.add(new Button("西方测试"),BorderLayout.WEST);
        frame.add(new Button("东方测试"),BorderLayout.EAST);
        frame.add(new Button("中方测试"),BorderLayout.CENTER);

        frame.pack();
        //frame.setLocation(560,240);
        //居中显示
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
