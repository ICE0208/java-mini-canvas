package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MyFrame;

public class redoListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		MyFrame.pointsHistory.redo();
	}
}
