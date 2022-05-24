package mylistener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import main.MyFrame;
import mypanel.PaintPanel;
import point.PointInfo;

public class PaintingListener extends MouseMotionAdapter {
	
	static public PaintPanel paintPanel;
	public static ArrayList<PointInfo> tempPoints = null;
	
	public PaintingListener(PaintPanel paintPanel) {
		PaintingListener.paintPanel = paintPanel;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (!SwingUtilities.isLeftMouseButton(e)) return;
		if (PaintingListener.tempPoints == null) return;
		if (PaintSEListener.painting == false) return;
		
		PointInfo point = new PointInfo(e.getX(), e.getY(), 
				MyFrame.paintColor, MyFrame.paintStroke);
		tempPoints.add(point);
		
		paintPanel.repaint();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
	}
	
}