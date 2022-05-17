package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import main.MyFrame;
import manager.ButtonManager;
import point.PointInfo;

public class UndoListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		if (ButtonManager.canPressBtn() == false) return;
		int pointsLen = MyFrame.points.size();
		if (pointsLen == 0) return;
		
		ArrayList<PointInfo> removedPoint;
		removedPoint = MyFrame.points.remove(pointsLen-1);
		MyFrame.pointsHistory.add(removedPoint);
		PaintingListener.paintPanel.repaint();
		
	}
}
