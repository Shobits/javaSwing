package org.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingComponentDemo {

    JFrame f = new JFrame("测试swing基本组件");

    JMenuBar jMenuBar = new JMenuBar();

    JMenu fileBar = new JMenu("文件");
    JMenu editBar = new JMenu("编辑");
    JMenu formatBar = new JMenu("格式");

    JMenuItem autoLine = new JMenuItem("自动换行");
    JMenuItem copy = new JMenuItem("复制");
    JMenuItem paste = new JMenuItem("粘贴");
    JMenuItem command = new JMenuItem("注释");
    JMenuItem cancelCommand = new JMenuItem("取消注释");

    JTextArea ta = new JTextArea(8, 20);

    String[] colors = {"红色", "黄色", "蓝色"};
    JList<String> colorList = new JList<>(colors);

    JComboBox<String> colorSelect = new JComboBox<>();

    ButtonGroup bg = new ButtonGroup();
    JRadioButton male = new JRadioButton("男", true);
    JRadioButton female = new JRadioButton("女", false);

    JCheckBox isMarried = new JCheckBox("是否已婚？", true);

    JTextField tf = new JTextField(40);

    JButton btn = new JButton("确定");

    JPopupMenu jPopupMenu = new JPopupMenu();
    ButtonGroup PopButtonGroup = new ButtonGroup();
    JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal Style");
    JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus Style");
    JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows Style",true);
    JRadioButtonMenuItem windowsClassicItem = new JRadioButtonMenuItem("WindowsClassic Style");
    JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif Style");

    public void init() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(tf);
        bottomPanel.add(btn);

        f.add(bottomPanel, BorderLayout.SOUTH);

        JPanel selectPanel = new JPanel();

        colorSelect.addItem("红色");
        colorSelect.addItem("黄色");
        colorSelect.addItem("蓝色");

        selectPanel.add(colorSelect);
        bg.add(male);
        bg.add(female);
        selectPanel.add(male);
        selectPanel.add(female);
        selectPanel.add(isMarried);

        Box topLeft = Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(selectPanel);

        Box topBox = Box.createHorizontalBox();
        topBox.add(topLeft);
        topBox.add(colorList);

        f.add(topBox);

        jMenuBar.add(fileBar);
        jMenuBar.add(editBar);

        editBar.add(autoLine);
        editBar.addSeparator();
        editBar.add(copy);
        editBar.add(paste);
        editBar.addSeparator();
        editBar.add(formatBar);

        formatBar.add(command);
        formatBar.add(cancelCommand);

        f.setJMenuBar(jMenuBar);

        PopButtonGroup.add(metalItem);
        PopButtonGroup.add(nimbusItem);
        PopButtonGroup.add(windowsItem);
        PopButtonGroup.add(windowsClassicItem);
        PopButtonGroup.add(motifItem);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();

                try {
                    changeFlavor(actionCommand);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        };

        metalItem.addActionListener(listener);
        nimbusItem.addActionListener(listener);
        windowsItem.addActionListener(listener);
        windowsClassicItem.addActionListener(listener);
        motifItem.addActionListener(listener);

        jPopupMenu.add(metalItem);
        jPopupMenu.add(nimbusItem);
        jPopupMenu.add(windowsItem);
        jPopupMenu.add(windowsClassicItem);
        jPopupMenu.add(motifItem);

        ta.setComponentPopupMenu(jPopupMenu);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new SwingComponentDemo().init();
    }

    //改变界面格式

    private void changeFlavor(String command) throws Exception {
        switch (command) {
            case "Metal Style":
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case "Nimbus Style":
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                break;
            case "Windows Style":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case "WindowsClassic Style":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                break;
            case "Motif Style":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                break;
        }

        SwingUtilities.updateComponentTreeUI(f.getContentPane());
        SwingUtilities.updateComponentTreeUI(jMenuBar);
        SwingUtilities.updateComponentTreeUI(jPopupMenu);
    }
}
