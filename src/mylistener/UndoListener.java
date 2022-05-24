package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import main.MiniCanvas;
import main.MyFrame;
import manager.ButtonManager;
import point.PointInfo;

public class UndoListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		doUndo();
		MiniCanvas.myFrame.requestFocus();
	}
	
	public void doUndo() {
		if (ButtonManager.canPressBtn() == false) return;
		int pointsLen = MyFrame.points.size();
		if (pointsLen == 0) return;
		
		ArrayList<PointInfo> removedPoint;
		do {
			removedPoint = MyFrame.points.remove(pointsLen-1);
		} while (removedPoint == null);
		MyFrame.pointsHistory.add(removedPoint);
		PaintingListener.paintPanel.repaint();
	}
}
