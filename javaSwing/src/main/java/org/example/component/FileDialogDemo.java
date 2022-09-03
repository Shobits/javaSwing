package org.example.component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileDialogDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("Test FileDialogDemo");

        //创建两个Dialog对象
        FileDialog fd1 = new FileDialog(frame, "Select File To Open", FileDialog.LOAD);
        FileDialog fd2 = new FileDialog(frame, "Select File To Save", FileDialog.SAVE);
        //创建两个按钮
        Button btn1 = new Button("Open File");
        Button btn2 = new Button("Save File");
        //给两个按钮绑定点击事件
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fd1.setVisible(true); //代码会堵塞到这里

                //获取选择的路径和文件
                String directory = fd1.getDirectory();
                String file = fd1.getFile();
                System.out.println("打开的文件路径为：" + directory);
                System.out.println("打开的文件名称为：" + file);
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fd2.setVisible(true);

                //获取选择的路径和文件
                String directory = fd2.getDirectory();
                String file = fd2.getFile();
                System.out.println("保存的文件路径为：" + directory);
                System.out.println("保存的文件名称为：" + file);

            }
        });
        //把按钮添加至Frame中
        frame.add(btn1, BorderLayout.NORTH);
        frame.add(btn2);


        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
