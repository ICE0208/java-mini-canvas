package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Main;
import main.MyFrame;
import manager.CursorManager;

public class PenListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		MyFrame.paintColor = MyFrame.selectedColor;
		Main.myFrame.cursorManager.setPenCursor(CursorManager.PEN);
	}

}
