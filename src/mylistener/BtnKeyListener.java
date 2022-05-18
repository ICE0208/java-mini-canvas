package mylistener;
	
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Queue;

import main.Main;

public class BtnKeyListener extends KeyAdapter {
	
	private static final int HOTKEY = 157; 
	private static final int SUBKEY = 16;
	private int curInput = -1;
	
	Queue<Integer> keyQueue = new LinkedList<Integer>();
	Object[] ary = keyQueue.toArray();
	
	public BtnKeyListener() {
		for (int i=0; i<3; i++) {
			keyQueue.offer(-1);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() != curInput) {
			curInput = e.getKeyCode();
			keyQueue.offer(curInput);
			while (keyQueue.size() > 3) {
				keyQueue.poll();
			}
			ary = keyQueue.toArray();
		}
		else return;
		
		
		int aryLen = ary.length;
		
		for (Object object : ary) {
			System.out.print(object + " ");
		}
		System.out.println();
		
		if (aryLen < 2) return;
		
		
		// 2개 키 command + [ ]
		if ((int)ary[aryLen-2] == HOTKEY) {
			// Save
			if ((int)ary[aryLen-1] == KeyEvent.VK_S) {
				SaveListener saveListener = Main.myFrame.menuPanel.saveListener;
				if (saveListener.saveManager.saveTrying == true) return;
				saveListener.saveManager.saveTrying  = true;
				saveListener.doSave();
				return;
			}
			// Undo
			if ((int)ary[aryLen-1] == KeyEvent.VK_Z) {
				Main.myFrame.menuPanel.undoListener.doUndo();
				return;
			}
		}
		
		if (aryLen < 3) return;
		// 3개 키 command + shift + [ ]
		if ((int)ary[aryLen-3] == HOTKEY && (int)ary[aryLen-2] == SUBKEY) {
			// Redo
			if ((int)ary[aryLen-1] == KeyEvent.VK_Z) {
				Main.myFrame.menuPanel.redoListener.doRedo();
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		while (keyQueue.contains(e.getKeyCode())) {
			keyQueue.remove(e.getKeyCode());
		}
		ary = keyQueue.toArray();
		if (ary.length <= 0) curInput = -1;
		else curInput = (int) ary[ary.length-1];
	}
}
