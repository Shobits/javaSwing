package org.example.layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//-Dfile.encoding=GBK
public class CardLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("测试 CardLayoutDemo");

        //创建Panel存储多张卡片
        Panel p1 = new Panel();

        //创建CardLayout对象，并且把该对象创建给之前创建的容器
        CardLayout cardLayout = new CardLayout();
        p1.setLayout(cardLayout);

        //往Panel存储多个组件
        String[] names = {"第一张", "第二张", "第三张", "第四张", "第五张"};
        for (int i = 0; i < names.length; i++) {
            p1.add(names[i], new Button(names[i] + ""));
        }
        //Panel放入Frame中
        frame.add(p1);

        //创建另一个Panel，用来存储多个按钮组件
        Panel p2 = new Panel();

        //创建5个按钮组件
        Button btn1 = new Button("第一张");
        Button btn2 = new Button("上一张");
        Button btn3 = new Button("第三张");
        Button btn4 = new Button("下一张");
        Button btn5 = new Button("最后一张");

        //创建一个时间监听器，监听按钮的点击事件
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();//这个字符串其实就是按钮上的文字
                switch (actionCommand) {
                    case "第一张":
                        cardLayout.first(p1);
                        break;
                    case "上一张":
                        cardLayout.previous(p1);
                        break;
                    case "第三张":
                        cardLayout.show(p1, "第三张");
                        break;
                    case "下一张":
                        cardLayout.next(p1);
                        break;
                    case "最后一张":
                        cardLayout.last(p1);
                        break;
                }
            }
        };

        //把当前这个事件监听器和多个按钮绑定在一起
        btn1.addActionListener(listener);
        btn2.addActionListener(listener);
        btn3.addActionListener(listener);
        btn4.addActionListener(listener);
        btn5.addActionListener(listener);
        //把按钮添加到容器p2中
        p2.add(btn1);
        p2.add(btn2);
        p2.add(btn3);
        p2.add(btn4);
        p2.add(btn5);
        //把p2放入Frame中
        frame.add(p2, BorderLayout.SOUTH);

        frame.pack();
        //frame.setLocation(560,240);
        //居中显示
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
