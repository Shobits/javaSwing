package org.example.component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//-Dfile.encoding=GBK
public class DialogDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();

        //创建两个对话框Dialog对象，一个模式，一个非模式
        Dialog dialog1 = new Dialog(frame, "模式对话框", true);
        Dialog dialog2 = new Dialog(frame, "非模式对话框", false);

        //通过setBounds方法设置Dialog的位置以及大小
        dialog1.setSize(300, 200);
        dialog2.setSize(300, 200);
        dialog1.setLocationRelativeTo(null);
        dialog2.setLocationRelativeTo(null);

        //创建两个按钮
        Button btn1 = new Button("打开模式对话框");
        Button btn2 = new Button("打开非模式对话框");

        //按钮添加点击行为
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog1.setVisible(true);
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog2.setVisible(true);
            }
        });
        //把按钮添加到Frame中
        frame.add(btn1,BorderLayout.NORTH);
        frame.add(btn2);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
