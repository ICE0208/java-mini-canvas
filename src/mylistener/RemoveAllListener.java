package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.MyFrame;
import mypanel.PaintPanel;

public class RemoveAllListener implements ActionListener{
	private static final String MESSAGE = "모두 지우시겠습니까? 이 기능을 수행하면 되돌릴 수 없습니다.";
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Remove All Confirm
		int confirm = JOptionPane.showConfirmDialog(null, MESSAGE, "Confirm", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.NO_OPTION) return;
		
		MyFrame.points.clear();
		PaintingListener.paintPanel.repaint();
	}

}
