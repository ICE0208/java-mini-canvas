package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Main;
import main.MyFrame;
import manager.ButtonManager;
import manager.CursorManager;

public class PenListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (ButtonManager.canPressBtn() == false) return;
		MyFrame.paintColor = MyFrame.selectedColor;
		MyFrame.paintStroke = MyFrame.selectedPenStroke;
		Main.myFrame.cursorManager.setCursor(CursorManager.PEN);
		Main.myFrame.requestFocus();
	}

}
