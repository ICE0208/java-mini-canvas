package manager;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import main.MyFrame;

public class SettingManager {
	JFrame jFrame;
	static private ArrayList<BasicStroke> bStrokes = new ArrayList<BasicStroke>();
	
	
	public SettingManager(JFrame j) {
		this.jFrame = j;
		
		for (int i=0; i<11; i++) {
			bStrokes.add(new BasicStroke(i));
		}
	}
	
	public void resetSettings() {
		// Default Frame Settings
		jFrame.setTitle("MINI CANVAS v0.3.22");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(1000, 600);
//		jFrame.setResizable(false);
		
		// Default Drawing Settings
		SettingManager.setColor(Color.BLACK);
		SettingManager.setStroke(4);
	}
	
	static public void setColor(Color color) {
		MyFrame.paintColor = color;
		MyFrame.selectedColor = color;
	}
	
	static public void setStroke(int stroke) {
		if (stroke < 0 || stroke > 10) {
			System.out.println("Error in setStroke -> selectedStroke was not changed");
		}
		MyFrame.selectedStroke = SettingManager.bStrokes.get(stroke);
	}
	
}
