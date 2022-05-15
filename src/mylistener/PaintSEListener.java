package mylistener;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import main.MyFrame;
import mypanel.PaintPanel;
import point.PointInfo;
import point.PointsHistory;

// SE's meaning : Start/End
public class PaintSEListener extends MouseAdapter {
	@Override
	public void mouseReleased(MouseEvent e) {
		MyFrame.points.add(PaintingListener.tempPoints);
		PaintingListener.tempPoints = null;
		PaintingListener.paintPanel.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		MyFrame.pointsHistory.clear();
		PaintingListener.tempPoints = new ArrayList<PointInfo>();
		PaintingListener.tempPoints.add(new PointInfo(e.getX(), e.getY(), 
				MyFrame.selectedColor, MyFrame.selectedStroke));
	}
		
		
		
		
}