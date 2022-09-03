package org.example.layout;

import javax.swing.*;
import java.awt.*;

//-Dfile.encoding=GBK
public class BoxLayoutDemo3 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试 BoxLayoutDemo");

        //创建一个水平排列组件的Box容器
        Box hb = Box.createHorizontalBox();
        //往容器中添加两个按钮
        hb.add(new Button("按钮1"));
        hb.add(Box.createHorizontalGlue());
        hb.add(new Button("按钮2"));
        hb.add(Box.createHorizontalStrut(20));
        hb.add(new Button("按钮3"));
        //创建一个垂直排列组件的Box容器
        Box vb = Box.createVerticalBox();
        vb.add(new Button("按钮4"));
        vb.add(Box.createVerticalGlue());
        vb.add(new Button("按钮5"));
        vb.add(Box.createVerticalStrut(20));
        vb.add(new Button("按钮6"));
        //把两个Box容器添加到Frame中
        frame.add(hb, BorderLayout.NORTH);
        frame.add(vb);

        frame.pack();
        frame.setLocationRelativeTo(null); //居中显示
        frame.setVisible(true);
    }
}
