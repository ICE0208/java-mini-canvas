package mypanel;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
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
		
		 
	
		 Graphics2D g2 = (Graphics2D) g;
		 g2.setColor(Color.BLACK);
		 g2.setStroke(new BasicStroke(10));
//		 for(int i=0; i<MyFrame.points.size(); i++) {
//			 Point point = MyFrame.points.get(i);
//			 g.fillOval(point.x, point.y, 10, 10);
//		 }
//		 System.out.println(MyFrame.points.size());
		 
		 
		 if (MyFrame.points.size() < 1) return;
		 for (int i=0; i<MyFrame.points.size(); i++) {
			 ArrayList<Point> pointObject = MyFrame.points.get(i);
			 
			 startP = pointObject.get(0);
			 for(int j=0; j<pointObject.size(); j++) {
				 endP = pointObject.get(j);
//				 g.drawLine(startP.x, startP.y, endP.x, endP.y);
				 g2.draw(new Line2D.Float(startP.x, startP.y, endP.x, endP.y));
				 startP = endP;
			 }
		 }
		
		 
//		 g.fillOval(startX, startY, 10, 10); // x, y ������ 70,70 ũ���� �� �׸���
	 }
	 
	 @Override
	 public void update(Graphics g){
		 paint(g);
	 }
}
