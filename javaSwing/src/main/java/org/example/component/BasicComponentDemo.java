package org.example.component;

import javax.swing.*;
import java.awt.*;

//-Dfile.encoding=GBK
public class BasicComponentDemo {
    Frame frame = new Frame("测试 BasicComponentDemo");

    TextArea ta = new TextArea(5, 20);

    Choice colorChooser = new Choice();

    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox male = new Checkbox("男", cbg, true);
    Checkbox female = new Checkbox("女", cbg, false);

    Checkbox isMarried = new Checkbox("是否已婚?");

    TextField tf = new TextField(20);
    Button ok = new Button("确认");

    List colorList = new List(6, true);


    public void init() {
        //组装界面

        //组装底部
        Box bBox = Box.createHorizontalBox();
        bBox.add(tf);
        bBox.add(ok);
        frame.add(bBox, BorderLayout.SOUTH);

        //组装 选择部分
        colorChooser.add("红色");
        colorChooser.add("蓝色");
        colorChooser.add("黄色");
        Box cBox = Box.createHorizontalBox();
        cBox.add(colorChooser);
        cBox.add(male);
        cBox.add(female);
        cBox.add(isMarried);

        //组装文本域和选择部分
        Box topLeft = Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(cBox);

        //组装topRight
        colorList.add("红色");
        colorList.add("蓝色");
        colorList.add("黄色");
        Box topRight = Box.createVerticalBox();
        topRight.add(colorList);

        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(topRight);

        //添加进入Frame
        frame.add(top);

        //设置可见
        frame.pack(); //最佳大小
        frame.setLocationRelativeTo(null); //居中显示
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        BasicComponentDemo bcd = new BasicComponentDemo();
        bcd.init();
    }
}
