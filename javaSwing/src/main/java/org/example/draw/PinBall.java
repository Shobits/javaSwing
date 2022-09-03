package org.example.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinBall {
    //创建窗口对象
    Frame frame = new Frame();

    //桌面宽度
    private final int TABLE_WIDTH = 300;
    private final int TABLE_HEIGHT = 300;

    //球拍高度和宽度
    private final int RACKET_WIDTH = 80;
    private final int RACKET_HEIGHT = 20;

    //球的大小
    private final int BALL_SIZE = 15;

    //定义变量，记录小球的坐标
    private int ball_X = 120;
    private int ball_Y = 120;

    //定义变量，记录小球x和y方向上的速度
    private int speed_X = 10;
    private int speed_Y = 10;

    //定义变量，记录球拍的位置
    private int racket_X = 120;
    private final int racket_Y = 275;

    //定义变量，游戏是否结束
    private boolean isOver = false;

    //声明一个定时器
    private Timer timer;

    //自定义个类，继承canvas，重写方法
    public class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            //TODO 在这里绘制内容
            if (isOver) {
                //游戏结束
                g.setColor(Color.BLACK);
                g.setFont(new Font("Times", Font.BOLD, 30));
                g.drawString("游戏结束！", 80, 150);
            } else {
                //游戏继续
                //绘制小球
                g.setColor(Color.RED);
                g.fillOval(ball_X, ball_Y, BALL_SIZE, BALL_SIZE);
                //绘制球拍
                g.setColor(Color.GRAY);
                g.fillRect(racket_X, racket_Y, RACKET_WIDTH, RACKET_HEIGHT);
            }

        }
    }

    //创建绘画区域
    MyCanvas drawArea = new MyCanvas();


    public void init() {
        //组装视图，游戏逻辑的控制
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //完成球拍的变化
        KeyListener listener = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //获取当前按下的键位
                int keyCode = e.getKeyCode();

                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                        if (racket_X > 0) {
                            racket_X -= 10;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (racket_X < TABLE_HEIGHT) {
                            racket_X += 10;
                        }
                        break;
                }
            }
        };
        //给frame和draw
        frame.addKeyListener(listener);
        drawArea.addKeyListener(listener);

        //小球坐标的控制
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //根据边界范围，修正速度
                if (ball_X <= 0 || ball_X >= (TABLE_WIDTH - BALL_SIZE-4)) {
                    speed_X = -speed_X;
                }
                if (ball_Y <= 0 || ball_Y > racket_Y - BALL_SIZE-7 && ball_X > racket_X && ball_Y < racket_Y + RACKET_WIDTH) {
                    speed_Y = -speed_Y;
                }
                if (ball_Y > racket_Y - BALL_SIZE && (ball_X < racket_X || ball_X > racket_X + RACKET_WIDTH)) {
                    //当小球超出了球拍的范围，游戏结束

                    //停止定时器
                    timer.stop();
                    //修改游戏是否结束的标记
                    isOver = true;
                    drawArea.repaint();
                }

                //更新小球的坐标，重绘界面
                ball_X += speed_X;
                ball_Y += speed_Y;

                drawArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));

                //重绘界面
                drawArea.repaint();
            }
        };
        timer = new javax.swing.Timer(100, task);
        timer.start();

        drawArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
        drawArea.setBackground(Color.yellow);
        frame.add(drawArea);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PinBall().init();
    }


}
