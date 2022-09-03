package org.example.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleDraw {
    private final String RECT_SHAPE = "rect";
    private final String OVAL_SHAPE = "oval";

    Frame frame = new Frame();

    Button btn1 = new Button("绘制矩形");
    Button btn2 = new Button("绘制椭圆");

    //顶一个变量，记录当前要绘制的是什么形状|
    private String shape = "";

    //自定义类继承Canvas，重写paint方法
    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            //绘制不同的图形
            if (shape.equals(RECT_SHAPE)) {
                g.setColor(Color.BLACK);
                g.drawRect(100, 100, 100, 100);

            } else if (shape.equals(OVAL_SHAPE)) {
                g.setColor(Color.RED);
                g.drawOval(100, 100, 150, 100);
            }
        }
    }

    //创建自定义的画布对象
    MyCanvas canvas = new MyCanvas();

    private void init() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //组装
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = RECT_SHAPE;
                btn1.repaint();
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = OVAL_SHAPE;
                btn2.repaint();
            }
        });

        canvas.setPreferredSize(new Dimension(300, 200));

        Panel p = new Panel();
        p.add(btn1);
        p.add(btn2);

        frame.add(p,BorderLayout.SOUTH);
        frame.add(canvas);


        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleDraw().init();
    }


}
