package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MyFrame;
import mypanel.PaintPanel;

public class RemoveAllListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		MyFrame.points.clear();
		
		PaintingListener.paintPanel.repaint();
	}

}
