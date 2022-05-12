package mylistener;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import main.*;

public class SaveListener implements ActionListener {
	private Container c;
	private JFrame j;
	Screenshot screenshot = new Screenshot();
	
	public SaveListener(Container c, JFrame j) {
		super();
		this.c = c;
		this.j = j;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		screenshot.start(c, j);
		
	}
}
