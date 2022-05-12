package main;

import javax.swing.JFrame;

public class SettingManager {
	JFrame jFrame;
	
	public SettingManager(JFrame j) {
		this.jFrame = j;
		resetSettings();
	}
	
	private void resetSettings() {
		jFrame.setTitle("GUI");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(1000, 600);
//		jFrame.setResizable(false);
	}
}
