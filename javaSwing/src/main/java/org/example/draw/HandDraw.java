package org.example.draw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class HandDraw {
    private Frame frame = new Frame();

    //定义画图去的宽高
    private final int AREA_WIDTH = 500;
    private final int AREA_HEIGHT = 500;

    //定义一个邮件菜单，用于设置画笔的颜色
    private PopupMenu colorMenu = new PopupMenu();
    private MenuItem redItem = new MenuItem("红色");
    private MenuItem greenItem = new MenuItem("绿色");
    private MenuItem yellowItem = new MenuItem("黄色");

    //定义变量，记录画笔的颜色
    private Color ForceColor = Color.BLACK;

    //创建一个BufferedImage位图
    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);

    //通过位图，获取关联的Graphics对象
    Graphics g = image.getGraphics();

    //定义一个类继承Canvas
    public class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
    }

    MyCanvas drawArea = new MyCanvas();

    //定义鼠标上一次所处的坐标
    private int preX = -1;
    private int preY = -1;

    public void init() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                switch (command) {
                    case "红色":
                        ForceColor = Color.RED;
                        break;
                    case "绿色":
                        ForceColor = Color.GREEN;
                        break;
                    case "黄色":
                        ForceColor = Color.YELLOW;
                        break;
                }
            }
        };

        redItem.addActionListener(listener);
        greenItem.addActionListener(listener);
        yellowItem.addActionListener(listener);

        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(yellowItem);

        drawArea.add(colorMenu);


        drawArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean popupTrigger = e.isPopupTrigger();
                if (popupTrigger) {
                    colorMenu.show(drawArea, e.getX(), e.getY());
                }

                preX = -1;
                preY = -1;
            }
        });

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);

        drawArea.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                if (preX > 0 && preY > 0) {
                g.setColor(ForceColor);
                g.drawLine(preX, preY, e.getX(), e.getY());
                }

                //修正preX和preY的值
                preX = e.getX();
                preY = e.getY();

                //重绘
                drawArea.repaint();
            }

        });

        drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
        frame.add(drawArea);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new HandDraw().init();
    }
}
