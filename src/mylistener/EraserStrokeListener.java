package mylistener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import main.Main;
import main.MyFrame;
import manager.ButtonManager;
import manager.CursorManager;
import manager.SettingManager;

public class EraserStrokeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (ButtonManager.canPressBtn() == false) return;
		JComboBox<?> cb = (JComboBox<?>)e.getSource();
		int index = cb.getSelectedIndex();
		SettingManager.setEraserStroke(index+1);
		
		// 지우개로 바꾸기
		MyFrame.paintColor = Color.WHITE;
		MyFrame.paintStroke = MyFrame.selectedEraserStroke;
		Main.myFrame.cursorManager.setCursor(CursorManager.ERASER);
		Main.myFrame.requestFocus();
	}

}
