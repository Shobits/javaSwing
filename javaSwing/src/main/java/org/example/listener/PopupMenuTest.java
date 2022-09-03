package org.example.listener;

import java.awt.*;
import java.awt.event.*;

public class PopupMenuTest {
    //创建接口
    private Frame frame = new Frame("SimpleMenu");

    TextArea ta = new TextArea("我爱中华\n", 6, 40);

    Panel p = new Panel();

    PopupMenu popupMenu = new PopupMenu();

    MenuItem comment = new MenuItem("注释");
    MenuItem cancelComment = new MenuItem("取消注释");
    MenuItem copy = new MenuItem("复制");
    MenuItem save = new MenuItem("保存");


    public void init() {
        //组装试图
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                ta.append("你惦记了：" + actionCommand + "\n");
            }
        };

        comment.addActionListener(actionListener);
        cancelComment.addActionListener(actionListener);
        copy.addActionListener(actionListener);
        save.addActionListener(actionListener);

        popupMenu.add(comment);
        popupMenu.add(cancelComment);
        popupMenu.add(copy);
        popupMenu.add(save);

        p.add(popupMenu);
        //设置Panel大小
        p.setPreferredSize(new Dimension(400, 150));
        //给Panel设置点击事件鼠标
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean popupTrigger = e.isPopupTrigger();
                if (popupTrigger) {
                    popupMenu.show(p, e.getX(), e.getY());
                }
            }
        });

        frame.add(ta, BorderLayout.NORTH);
        frame.add(p);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        PopupMenuTest menu = new PopupMenuTest();
        menu.init();
    }
}
