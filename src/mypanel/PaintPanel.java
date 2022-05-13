package mypanel;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.MyFrame;

public class PaintPanel extends JPanel {
	
	public PaintPanel() {
		setBackground(Color.PINK);
//		repaint();
	}
	
	 @Override
	 public void paint(Graphics g){
		 super.paint(g);
		 
		 Point startP;
		 Point endP;
		
		 
		 g.setColor(Color.BLACK);
//		 for(int i=0; i<MyFrame.points.size(); i++) {
//			 Point point = MyFrame.points.get(i);
//			 g.fillOval(point.x, point.y, 10, 10);
//		 }
//		 System.out.println(MyFrame.points.size());
		 
		 
		 if (MyFrame.points.size() < 1) return;
		 for (int i=0; i<MyFrame.points.size(); i++) {
			 ArrayList<Point> pointObject = MyFrame.points.get(i);
			 
			 startP = pointObject.get(0);
			 for(int j=1; j<pointObject.size(); j++) {
				 endP = pointObject.get(j);
				 g.drawLine(startP.x, startP.y, endP.x, endP.y);
				 startP = endP;
			 }
		 }
		
		 
//		 g.fillOval(startX, startY, 10, 10); // x, y 지점에 70,70 크기의 원 그리기
	 }
	 
	 @Override
	 public void update(Graphics g){
		 paint(g);
	 }
}
