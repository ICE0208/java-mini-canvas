package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MyFrame;

public class UndoListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		int pointsLen = MyFrame.points.size();
		if (pointsLen == 0) return;
		
		MyFrame.points.remove(pointsLen-1);
		PaintListener.paintPanel.repaint();
		
	}
}
