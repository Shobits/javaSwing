package org.example.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//-Dfile.encoding=GBK
public class DialogDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame();

        //创建两个对话框Dialog对象，一个模式，一个非模式
        Dialog dialog1 = new Dialog(frame, "模式对话框", true);

        //创建一个垂直的容器
        Box vBox = Box.createVerticalBox();
        vBox.add(new TextField());
        vBox.add(new Button("确认"));

        //把Box容器添加到Dialog
        dialog1.add(vBox);


        //通过setBounds方法设置Dialog的位置以及大小
        dialog1.setSize(300, 200);
        dialog1.setLocationRelativeTo(null);

        //创建两个按钮
        Button btn1 = new Button("打开模式对话框");

        //按钮添加点击行为
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog1.setVisible(true);
            }
        });

        //把按钮添加到Frame中
        frame.add(btn1, BorderLayout.NORTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
