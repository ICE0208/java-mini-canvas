package manager;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import main.Main;
import mylistener.PaintSEListener;

public class FocusManager implements WindowFocusListener {

	boolean isDialong = false;
	boolean isLost = false;
	
	public static void forceFocus() {
		Main.myFrame.setFocusable(true);
		Main.myFrame.requestFocusInWindow();
	}
	
	@Override
	public void windowGainedFocus(WindowEvent e) {
		Main.myFrame.requestFocus();
		if (isLost == false) return;
		isLost = false;
		forceFocus();
		System.out.println("focus");
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		System.out.println("out");
		if (isDialong == false) {
			isLost = true;
		}
		
		if (PaintSEListener.painting == false) return;
		PaintSEListener.forceMouseReleased();
	}
}
