package mylistener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Main;
import main.MyFrame;
import manager.CursorManager;

public class EraserListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		MyFrame.paintColor = Color.WHITE;
		Main.myFrame.cursorManager.setPenCursor(CursorManager.ERASER);
	}

}
