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
		// Save on Mac
		if (oldInput == HOTKEY) {
			if (curInput == KeyEvent.VK_S) {
				System.out.println("try save");
				SaveListener saveListener = Main.myFrame.menuPanel.saveListener;
				if (saveListener.saveManager.saveTrying == true) return;
				saveListener.saveManager.saveTrying  = true;
				saveListener.doSave();
				return;
			}
			if (curInput == KeyEvent.VK_Z) {
				System.out.println("try undo");
				Main.myFrame.menuPanel.undoListener.doUndo();
				return;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() != HOTKEY) {
			curInput = oldInput;
		}
	}


}
