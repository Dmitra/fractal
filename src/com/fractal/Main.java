package com.fractal;
import static com.func.Puts.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
	public static Fractal fractal = Fractal.samples.get(0);;
	public static Date time = new Date(); 
  public static void main(String[] a) {
    time = new Date();
    fractal.iter(12, false);
    puts(new Date().getTime() - time.getTime());

    JFrame frame = new JFrame();
    frame.setSize(1600, 1200);
    frame.add(new Main ());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
  public void paint(Graphics g2) {
	  g2.setColor (Color.red);
	  for (Line i:fractal.list){
		  double[] coords = i.coords();
		  g2.drawLine ((int)coords[0], (int) coords[1], (int) coords[2], (int) coords[3]);
    }
  }
}