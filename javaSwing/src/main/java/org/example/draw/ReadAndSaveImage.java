package org.example.draw;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadAndSaveImage {
    private Frame frame = new Frame("图片查看器");

    MenuBar menuBar = new MenuBar();

    Menu fileBar = new Menu("File");

    MenuItem open = new MenuItem("Open File");
    MenuItem saveAs = new MenuItem("Save As");

    //声明bufferedImage对象，记录本地存取到内存中的图片
    BufferedImage image;

    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
    }

    MyCanvas drawArea = new MyCanvas();

    void init() {
        open.addActionListener(e -> {
            //打开文件对话框
            FileDialog fileDialog = new FileDialog(frame, "Open File", FileDialog.LOAD);
            fileDialog.setVisible(true);

            //获取用户选择的图片的路径
            String directory = fileDialog.getDirectory();
            String fileName = fileDialog.getFile();

            try {
                image = ImageIO.read(new File(directory, fileName));
                drawArea.repaint();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        saveAs.addActionListener(e -> {
            FileDialog fileDialog = new FileDialog(frame, "Save As", FileDialog.SAVE);
            fileDialog.setVisible(true);

            String directory = fileDialog.getDirectory();
            String fileName = fileDialog.getFile();

            try {
                ImageIO.write(image, "JPEG", new File(directory, fileName));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        fileBar.add(open);
        fileBar.add(saveAs);

        menuBar.add(fileBar);

        frame.setMenuBar(menuBar);

        frame.add(drawArea);

        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new ReadAndSaveImage().init();
    }
}
