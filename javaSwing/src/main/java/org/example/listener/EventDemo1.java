package org.example.listener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventDemo1 {
    Frame frame = new Frame("测试 EventDemo1");

    TextField tf = new TextField(30);

    Button btn = new Button("Enter");

    public void init() {
        //组装视图
        MyListener listener = new MyListener();

        //注册监听器
        btn.addActionListener(listener);

        //把tf和btn放入frame
        frame.add(tf, BorderLayout.NORTH);
        frame.add(btn);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            tf.setText("Hello World");
        }
    }


    public static void main(String[] args) {
        new EventDemo1().init();
    }
}
