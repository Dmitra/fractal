package com.test;
/* <applet code = "Scribble2" width=200 height=200>
* </applet>
*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Scribble2 extends Applet implements
MouseListener, MouseMotionListener {
private int last_x, last_y;
public void init() {
// �������� ������� ������� � ���, ����� �������
// ������� MouseListener � MouseMotionListener �� ������ ���������
// � ��������, ��������� � ����� � �� ������������.
// ��������� ��������� ����������� � ����� �������,
// ��� ���� ����� ���������� ������ �������.
this.addMouseListener(this) ;
this.addMouseMotionListener(this);
}

// ����� ���������� MouseListener. ���������� ��� �������
// ������������� ������ ����.
public void mousePressed(MouseEvent e) {
last_x = e.getX();
last_y = e.getY();
}

// ����� ���������� MouseMotionListener. ���������� ���
// ����������� ���� � ������� �������.
public void mouseDragged(MouseEvent e) {
Graphics g = this.getGraphics();
int x = e.getX(), y = e.getY();
g.drawLine(last_x, last_y, x, y);
last_x = x; last_y = y;
}
// ������, �� ������������ ������ ���������� MouseListener.
public void mouseReleased(MouseEvent e) {;}
public void mouseClicked(MouseEvent e) {;}
public void mouseEntered(MouseEvent e) {;}
public void mouseExited(MouseEvent e) {;}

// ������ ����� ���������� MouseMotionListener.
public void mouseMoved(MouseEvent e) {;}
}