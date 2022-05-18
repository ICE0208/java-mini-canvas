package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.Main;
import main.MyFrame;
import manager.ButtonManager;

public class RemoveAllListener implements ActionListener{
	private static final String MESSAGE = "��� ����ðڽ��ϱ�? �� ����� �����ϸ� �ǵ��� �� �����ϴ�.";
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Main.myFrame.menuPanel.requestFocus();
		if (ButtonManager.canPressBtn() == false) return;
		// Remove All Confirm
		int confirm = JOptionPane.showConfirmDialog(null, MESSAGE, "Confirm", JOptionPane.YES_NO_OPTION);
		if (confirm != JOptionPane.YES_OPTION) return;
		
		MyFrame.points.clear();
		MyFrame.pointsHistory.clear();
		PaintingListener.paintPanel.repaint();
	}

}
