package mylistener;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import main.Main;
import main.MyFrame;
import manager.CursorManager;
import mypanel.PaintPanel;
import point.PointInfo;
import point.PointsHistory;

// SE's meaning : Start/End
public class PaintSEListener extends MouseAdapter {
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() != MouseEvent.BUTTON1) return;
		MyFrame.points.add(PaintingListener.tempPoints);
		PaintingListener.tempPoints = null;
		PaintingListener.paintPanel.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() != MouseEvent.BUTTON1) return;
		MyFrame.pointsHistory.clear();
		PaintingListener.tempPoints = new ArrayList<PointInfo>();
		PaintingListener.tempPoints.add(new PointInfo(e.getX(), e.getY(), 
				MyFrame.paintColor, MyFrame.selectedStroke));
	}
		
}