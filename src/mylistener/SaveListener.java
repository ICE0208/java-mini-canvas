package mylistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import main.Main;
import manager.ButtonManager;
import manager.SaveManager;
import mypanel.PaintPanel;

public class SaveListener implements ActionListener {
	private PaintPanel c;
	private JFrame j;
	SaveManager saveManager = new SaveManager();
	
	public SaveListener(PaintPanel c, JFrame j) {
		super();
		this.c = c;
		this.j = j;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		doSave();
		Main.myFrame.requestFocus();
	}
	
	public void doSave() {
		if (ButtonManager.canPressBtn() == false) return;
		saveManager.start(c, j);
	}
}
