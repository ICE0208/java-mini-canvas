package mylistener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

import main.SettingManager;

public class ColorListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Color pickedColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
		SettingManager.setColor(pickedColor);
	}
}


