package mylistener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;

import main.MiniCanvas;
import main.MyFrame;
import manager.ButtonManager;
import manager.CursorManager;
import manager.SettingManager;

public class ColorListener extends MouseAdapter {
	MyFrame myFrame;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (ButtonManager.canPressBtn() == false) return;
		Color pickedColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
		if (pickedColor == null) return;
		SettingManager.setColor(pickedColor);
		myFrame.menuPanel.seleColor.repaint();
		MiniCanvas.myFrame.cursorManager.setCursor(CursorManager.PEN);
		MyFrame.paintStroke = MyFrame.selectedPenStroke;
		MiniCanvas.myFrame.requestFocus();
	}
	
	public ColorListener(MyFrame myFrame) {
		this.myFrame = myFrame;
	}
}


