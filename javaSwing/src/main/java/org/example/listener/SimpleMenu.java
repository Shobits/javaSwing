package org.example.listener;

import java.awt.*;
import java.awt.event.*;

public class SimpleMenu {
    //创建接口
    private Frame frame = new Frame();

    //创建菜单条
    MenuBar menuBar = new MenuBar();

    //创建菜单组件
    Menu fileMenu = new Menu("文件");
    Menu editMenu = new Menu("编辑");
    Menu formatMenu = new Menu("格式");

    //菜单项组件
    MenuItem auto = new MenuItem("自动换行");
    MenuItem copy = new MenuItem("复制");
    MenuItem paste = new MenuItem("粘贴");

    MenuItem comment = new MenuItem("注释", new MenuShortcut(KeyEvent.VK_Q, true));
    MenuItem cancelComment = new MenuItem("取消注释");

    TextArea ta = new TextArea(6, 40);

    public void init() {
        //组装试图
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("你点击了菜单项：" + e.getActionCommand());
            }
        });
        formatMenu.add(comment);
        formatMenu.add(cancelComment);

        editMenu.add(auto);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(formatMenu);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setMenuBar(menuBar);
        frame.add(ta);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SimpleMenu menu = new SimpleMenu();
        menu.init();
    }
}
