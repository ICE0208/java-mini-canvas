package mylistener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import main.MiniCanvas;
import main.MyFrame;
import point.PointInfo;

// SE's meaning : Start/End
public class PaintSEListener extends MouseAdapter {
	
	public static boolean painting = false;
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (!SwingUtilities.isLeftMouseButton(e)) return;
		if (painting != true) return;
		painting = false;
		MyFrame.points.add(PaintingListener.tempPoints);
		PaintingListener.tempPoints = null;
		PaintingListener.paintPanel.repaint();
		MiniCanvas.myFrame.requestFocus();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (!SwingUtilities.isLeftMouseButton(e)) return;
		if (painting != false) return;
		painting = true;
		MyFrame.pointsHistory.clear();
		PaintingListener.tempPoints = new ArrayList<PointInfo>();
		PaintingListener.tempPoints.add(new PointInfo(e.getX(), e.getY(), 
				MyFrame.paintColor, MyFrame.paintStroke));
	}
	
	public static void forceMouseReleased() {
		painting = false;
		MyFrame.points.add(PaintingListener.tempPoints);
		PaintingListener.tempPoints = null;
		PaintingListener.paintPanel.repaint();
		MiniCanvas.myFrame.requestFocus();
	}
		
}