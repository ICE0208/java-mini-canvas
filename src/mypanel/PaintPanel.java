package mypanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.MyFrame;
import mylistener.PaintingListener;
import point.PointInfo;

@SuppressWarnings("serial")
public class PaintPanel extends JPanel {
	
	public PaintPanel() {
		setBackground(Color.WHITE);
	}
	
	 @Override
	 public void paint(Graphics g){
		 super.paint(g);
		 	
		 Graphics2D g2 = (Graphics2D) g;
		 
		 // OldPointsArray
		 for (int i=0; i<MyFrame.points.size(); i++) {
			 PointInfo startP;
			 PointInfo endP;
			 
			 ArrayList<PointInfo> pointObject = MyFrame.points.get(i);
			 
			 startP = pointObject.get(0);
			 g2.setColor(startP.color);
			 g2.setStroke(startP.stroke);
			 for(int j=0; j<pointObject.size(); j++) {
				 endP = pointObject.get(j);
//				 g.drawLine(startP.x, startP.y, endP.x, endP.y);
				 g2.draw(new Line2D.Float(startP.x, startP.y, endP.x, endP.y));
				 startP = endP;
			 }
		 }
		 
		 // PaintingPoints
		 ArrayList<PointInfo> paintingPoints = PaintingListener.tempPoints;
		 if (paintingPoints != null && paintingPoints.size() > 0) {
			 PointInfo startP;
			 PointInfo endP;
			 
			 startP = paintingPoints.get(0);
			 g2.setColor(startP.color);
			 g2.setStroke(startP.stroke);
			 for(int j=0; j<paintingPoints.size(); j++) {
				 endP = paintingPoints.get(j);
				 g2.draw(new Line2D.Float(startP.x, startP.y, endP.x, endP.y));
				 startP = endP;
			 }
		 }
	 }
	 

}
