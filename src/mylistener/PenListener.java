package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MiniCanvas;
import main.MyFrame;
import manager.ButtonManager;
import manager.CursorManager;

public class PenListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (ButtonManager.canPressBtn() == false) return;
		MyFrame.paintColor = MyFrame.selectedColor;
		MyFrame.paintStroke = MyFrame.selectedPenStroke;
		MiniCanvas.myFrame.cursorManager.setCursor(CursorManager.PEN);
		MiniCanvas.myFrame.requestFocus();
	}

}
