package mylistener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;

import Managers.SettingManager;
import main.MyFrame;
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
	}
	
	public ColorListener(MyFrame myFrame) {
		this.myFrame = myFrame;
	}
}


