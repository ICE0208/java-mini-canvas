package mylistener;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.*;
import manager.SaveManager;
import mypanel.PaintPanel;

public class SaveListener implements ActionListener {
	private PaintPanel c;
	private JFrame j;
	SaveManager screenshot = new SaveManager();
	
	public SaveListener(PaintPanel c, JFrame j) {
		super();
		this.c = c;
		this.j = j;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		screenshot.start(c, j);
		
	}
}
