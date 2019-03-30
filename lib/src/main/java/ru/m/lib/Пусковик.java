package ru.m.lib;

import javax.swing.*;
import java.io.IOException;

public class Пусковик {
    public static void main(String[] args) throws IOException {
        JFrame ГлавноеОкно = new JFrame("\"MFLOPS\" (c) ParkhimovichDL 2016 (" + Runtime.getRuntime().availableProcessors() + " CPU)");
        ГлавноеОкно.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myView v = new myView(
                new myModel(
                        new myController()
                )
        );

        ГлавноеОкно.setBounds(200, 200, 640, 480);
        ГлавноеОкно.setVisible(true);
        ГлавноеОкно.add(v);
    }
}
