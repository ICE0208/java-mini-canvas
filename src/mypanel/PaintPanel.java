package mypanel;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import main.MyFrame;

public class PaintPanel extends JPanel {
	int startX;
	int startY;
	
	public void setStartX(int startX) {
		this.startX = startX;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public PaintPanel() {
		setBackground(Color.PINK);
		repaint();
		this.startX = -50;
		this.startY = -50;
	}
	
	 @Override
	 public void paint(Graphics g){
		 super.paint(g);
		
		 
		 g.setColor(Color.BLACK);
		 for(int i=0; i<MyFrame.points.size(); i++) {
			 Point point = MyFrame.points.get(i);
			 g.fillOval(point.x, point.y, 10, 10);
		 }
		 
//		 g.fillOval(startX, startY, 10, 10); // x, y 지점에 70,70 크기의 원 그리기
	 }
	 
	 @Override
	 public void update(Graphics g){
		 paint(g);
	 }
}
