package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import main.MiniCanvas;
import main.MyFrame;
import manager.ButtonManager;
import manager.CursorManager;
import manager.SettingManager;

public class PenStrokeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (ButtonManager.canPressBtn() == false) return;
		JComboBox<?> cb = (JComboBox<?>)e.getSource();
		int index = cb.getSelectedIndex();
		SettingManager.setPenStroke(index+1);
		
		// 펜으로 바꾸기
		MyFrame.paintColor = MyFrame.selectedColor;
		MyFrame.paintStroke = MyFrame.selectedPenStroke;
		MiniCanvas.myFrame.cursorManager.setCursor(CursorManager.PEN);
		MiniCanvas.myFrame.requestFocus();
	}

}
