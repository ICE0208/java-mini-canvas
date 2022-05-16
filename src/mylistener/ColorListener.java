package mylistener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;

import main.Main;
import main.MyFrame;
import manager.CursorManager;
import manager.SettingManager;
import mypanel.MenuPanel;

public class ColorListener extends MouseAdapter {
	MyFrame myFrame;
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Color pickedColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
		if (pickedColor == null) return;
		SettingManager.setColor(pickedColor);
		myFrame.menuPanel.seleColor.repaint();
		Main.myFrame.cursorManager.setPenCursor(CursorManager.PEN);
	}
	
	public ColorListener(MyFrame myFrame) {
		this.myFrame = myFrame;
	}
}


