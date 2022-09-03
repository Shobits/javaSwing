package org.example.container;

import java.awt.*;

public class ScrollPaneDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("演示 ScrollPane");
        //1. 创建一个scrollPane
        /**
         * ScrollPane.SCROLLBARS_ALWAYS 总是显示滚动条
         */
        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        //2. 往ScrollPane中添加内容
        sp.add(new TextField("===测试文本==="));
        sp.add(new Button("测试按钮"));

        //3. 把ScrollPane添加到window中
        frame.add(sp);

        frame.setBounds(560, 240, 800, 600);
        frame.setVisible(true);
    }
}
