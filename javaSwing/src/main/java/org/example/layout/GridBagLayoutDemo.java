package org.example.layout;

import java.awt.*;

//-Dfile.encoding=GBK
public class GridBagLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("测试 GridBagLayoutDemo");

        //创建GridBagLayout对象
        GridBagLayout gbl = new GridBagLayout();

        //将frame对象的布局位置设置为GridBagLayout
        frame.setLayout(gbl);

        //创建GridBagConstraints对象
        GridBagConstraints gbc = new GridBagConstraints();

        //创建容量为10的button数组
        Button[] bs = new Button[10];

        //遍历数组，初始化每一个Button
        for (int i = 0; i < bs.length; i++) {
            bs[i] = new Button("按钮" + (i + 1));
        }

        //设置所有的GridBagConstraints对象的fill 属性为GridBagConstraints.BOTH
        //当有空白区域时，组件自动扩大沾满空白区域
        gbc.fill = GridBagConstraints.BOTH;

        //设置GridBagConstraints对象的 weightx设置为 1，表示横向扩展比例为1
        gbc.weightx = 1;

        //往frame中添加数组中的前3个Button

        frame.pack();
        //frame.setLocation(560,240);
        //居中显示
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
