package mylistener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.Main;

public class BtnKeyListener extends KeyAdapter {
	
	private static final int HOTKEY = 157; 
	private int oldInput = -1;
	private int curInput = -1;

	@Override
	public void keyPressed(KeyEvent e) {
		oldInput = curInput;
		curInput = e.getKeyCode();
		System.out.println("old: " + oldInput + ", new: " + curInput);
		SaveListener saveListener = Main.myFrame.menuPanel.saveListener;
		if (oldInput == HOTKEY && curInput == KeyEvent.VK_S) {
			System.out.println("try save");
			if (saveListener.saveManager.saveTrying == true) return;
			saveListener.saveManager.saveTrying  = true;
			saveListener.doSave();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		curInput = -1;
	}


}
