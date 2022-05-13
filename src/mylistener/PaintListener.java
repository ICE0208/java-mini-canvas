package mylistener;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.MyFrame;
import mypanel.PaintPanel;

public class PaintListener extends MouseMotionAdapter {
	
	static public PaintPanel paintPanel;
	public static ArrayList<Point> tempPoints = null;
	public static int curIndex = 0;
	
	public PaintListener(PaintPanel paintPanel) {
		this.paintPanel = paintPanel;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (PaintListener.tempPoints == null) return;
		
		Point point = new Point(e.getX(), e.getY());
//		System.out.println(point.x + ", " + point.y);
		tempPoints.add(point);
//		System.out.println(tempPoints.size());
		
		paintPanel.repaint();
	}
}