package org.example.layout;

import javax.swing.*;
import java.awt.*;

//-Dfile.encoding=GBK
public class BoxLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("测试 BoxLayoutDemo");

        //基于Frame容器，创建一个BoxLayout对象，并且，该对象存放组件是垂直存放的
        BoxLayout boxLayout = new BoxLayout(frame,BoxLayout.X_AXIS);
        //把BoxLayout设置给Frame
        frame.setLayout(boxLayout);
        //往Frame中添加两个组件
        frame.add(new Button("BOX1"));
        frame.add(new Button("BOX2"));


        frame.pack();
        frame.setLocationRelativeTo(null); //居中显示
        frame.setVisible(true);
    }
}
