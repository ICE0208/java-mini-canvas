package mylistener;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import main.MyFrame;

public class PaintListener2 extends MouseAdapter {
	@Override
	public void mouseReleased(MouseEvent e) {
//		System.out.println("release");
		MyFrame.points.add(PaintListener.tempPoints);
		PaintListener.curIndex += 1;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
//		System.out.println("Press");
		PaintListener.tempPoints = new ArrayList<Point>();
		
	}
		
		
		
		
}