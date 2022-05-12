package mylistener;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import main.MyFrame;
import mypanel.PaintPanel;

public class PaintListener extends MouseMotionAdapter {
	
	PaintPanel paintPanel;
	int startX;
	int startY;
	
	public PaintListener(PaintPanel paintPanel) {
		this.paintPanel = paintPanel;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		paintPanel.setStartX(e.getX());
		paintPanel.setStartY(e.getY());
		Point point = new Point(e.getX(), e.getY());
		System.out.println(point.x + ", " + point.y);
		MyFrame.points.add(point);
		
		paintPanel.repaint();
	}
}