package com.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialog extends JFrame {

  JTextArea txt;

  Dialog() {
     super("��������� ���������� � ��������� ��������");

     try  {
    	 UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
     }
     catch(Exception e) {
     }

    setSize(400, 200);
    Container c = getContentPane();
    c.add(new JLabel("Hello, ������"), BorderLayout.NORTH);
    txt = new JTextArea(5, 30);
    JScrollPane pane = new JScrollPane(txt);
    c.add(pane, BorderLayout.CENTER);

    WindowListener wndCloser = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
    addWindowListener(wndCloser);

    setVisible(true);
  }

  public void test() {
    txt.append("������ ������\n");
    txt.append("������ ������\n");
  }

  public static void main(String[] args) {
    Dialog d = new Dialog();
    d.test();
  }
}
