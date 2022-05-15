package mylistener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

import Managers.SettingManager;
import main.MyFrame;
import mypanel.MenuPanel;

public class ColorListener implements ActionListener {
	MyFrame myFrame;
	
	public ColorListener(MyFrame myFrame) {
		this.myFrame = myFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Color pickedColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
		if (pickedColor == null) return;
		SettingManager.setColor(pickedColor);
		myFrame.menuPanel.selectedColor.repaint();
	}
}


