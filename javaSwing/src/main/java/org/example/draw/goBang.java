package org.example.draw;

import java.awt.*;

public class goBang {
    private Frame frame = new Frame("五子棋");


    private void init() throws Exception {

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new goBang().init();
    }

}
