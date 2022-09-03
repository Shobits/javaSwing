package org.example.listener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListenerDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试 ListenerDemo2");
        frame.setSize(800, 600);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });

        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
