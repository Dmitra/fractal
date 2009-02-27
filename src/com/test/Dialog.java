package com.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialog extends JFrame {

  JTextField fld = new JTextField();
  JButton btn = new JButton("������ �����");
  JLabel lbl = new JLabel(" ");

  Dialog() {
     super("��������� (listeners) ����� � ������");

     try  {
       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     }
     catch(Exception e) {
     }

    setSize(400, 150);
    Container c = getContentPane();
    c.add(lbl, BorderLayout.NORTH);
    c.add(fld, BorderLayout.CENTER);
    c.add(btn, BorderLayout.SOUTH);
    fld.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {
              lbl.setText("������ �����:"+fld.getText());
          }
        });
    btn.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {
              lbl.setText("������ ������");
          }
        });
    WindowListener wndCloser = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
    addWindowListener(wndCloser);

    setVisible(true);
  }

  public static void main(String[] args) {
    new Dialog();
  }
}
