package mylistener;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

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
		if (PaintingListener.tempPoints == null) return;
		
		PointInfo point = new PointInfo(e.getX(), e.getY(), 
				MyFrame.selectedColor, MyFrame.selectedStroke);
		tempPoints.add(point);
		
		paintPanel.repaint();
	}
}