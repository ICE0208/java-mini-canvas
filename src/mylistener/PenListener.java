package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Main;
import manager.CursorManager;

public class PenListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Main.myFrame.paintColor = Main.myFrame.selectedColor;
		Main.myFrame.cursorManager.setPenCursor(CursorManager.PEN);
	}

}
