package mylistener;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.MyFrame;
import main.PointInfo;
import mypanel.PaintPanel;

public class PaintListener extends MouseMotionAdapter {
	
	static public PaintPanel paintPanel;
	public static ArrayList<PointInfo> tempPoints = null;
	
	public PaintListener(PaintPanel paintPanel) {
		PaintListener.paintPanel = paintPanel;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (PaintListener.tempPoints == null) return;
		
		PointInfo point = new PointInfo(e.getX(), e.getY(), 
				MyFrame.selectedColor, MyFrame.selectedStroke);
//		System.out.println(point.x + ", " + point.y);
		tempPoints.add(point);
		
		paintPanel.repaint();
	}
}