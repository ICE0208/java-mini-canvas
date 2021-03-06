package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MiniCanvas;
import main.MyFrame;
import manager.ButtonManager;

public class RedoListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		doRedo();
		MiniCanvas.myFrame.requestFocus();
	}
	
	public void doRedo() {
		if (ButtonManager.canPressBtn() == false) return;
		MyFrame.pointsHistory.redo();
	}
}
