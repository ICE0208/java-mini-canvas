package mylistener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MiniCanvas;
import main.MyFrame;
import manager.ButtonManager;
import manager.CursorManager;

public class EraserListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (ButtonManager.canPressBtn() == false) return;
		MyFrame.paintColor = Color.WHITE;
		MyFrame.paintStroke = MyFrame.selectedEraserStroke;
		MiniCanvas.myFrame.cursorManager.setCursor(CursorManager.ERASER);
		MiniCanvas.myFrame.requestFocus();
	}

}
