package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import main.Main;
import manager.SettingManager;

public class StrokeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<?> cb = (JComboBox<?>)e.getSource();
		int index = cb.getSelectedIndex();
		SettingManager.setStroke(index+1);
		Main.myFrame.requestFocus();
	}

}
