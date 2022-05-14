package mylistener;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import main.MyFrame;
import main.PointInfo;
import main.PointsHistory;
import mypanel.PaintPanel;

public class PaintListener2 extends MouseAdapter {
	@Override
	public void mouseReleased(MouseEvent e) {
		MyFrame.points.add(PaintListener.tempPoints);
		PaintListener.tempPoints = null;
		PaintListener.paintPanel.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
//		System.out.println("Press");
		MyFrame.pointsHistory.clear();
		PaintListener.tempPoints = new ArrayList<PointInfo>();
		PaintListener.tempPoints.add(new PointInfo(e.getX(), e.getY(), 
				MyFrame.selectedColor, MyFrame.selectedStroke));
	}
		
		
		
		
}