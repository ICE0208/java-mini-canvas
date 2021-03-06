package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.MiniCanvas;
import main.MyFrame;
import manager.ButtonManager;

public class RemoveAllListener implements ActionListener{
	private static final String MESSAGE = "모두 지우시겠습니까? 이 기능을 수행하면 되돌릴 수 없습니다.";
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MiniCanvas.myFrame.requestFocus();
		if (ButtonManager.canPressBtn() == false) return;
		// Remove All Confirm
		int confirm = JOptionPane.showConfirmDialog(null, MESSAGE, "Confirm", JOptionPane.YES_NO_OPTION);
		MiniCanvas.myFrame.requestFocus();
		if (confirm != JOptionPane.YES_OPTION) return;
		
		MyFrame.points.clear();
		MyFrame.pointsHistory.clear();
		PaintingListener.paintPanel.repaint();
	}

}
