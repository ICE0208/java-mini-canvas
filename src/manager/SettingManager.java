package manager;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import main.MyFrame;

public class SettingManager {
	JFrame jFrame;
	static private ArrayList<BasicStroke> Strokes = new ArrayList<BasicStroke>();
	
	
	public SettingManager(JFrame j) {
		this.jFrame = j;
		
		for (int i=0; i<11; i++) {
			Strokes.add(new BasicStroke(i));
		}
	}
	
	public void resetSettings() {
		// Default Frame Settings
		jFrame.setTitle("MINI CANVAS v0.4.0");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(1000, 600);
//		jFrame.setResizable(false);
		
		// Default Drawing Settings
		SettingManager.setColor(Color.BLACK);
		SettingManager.setEraserStroke(4);
		SettingManager.setPenStroke(4);
		MyFrame.paintStroke = Strokes.get(4);
	}
	
	static public void setColor(Color color) {
		MyFrame.paintColor = color;
		MyFrame.selectedColor = color;
	}
	
	static public void setPenStroke(int stroke) {
		if (stroke < 1 || stroke > 10) {
			System.out.println("Error in setStroke -> selectedStroke was not changed");
			return;
		}
//		MyFrame.paintStroke = SettingManager.Strokes.get(stroke);
		MyFrame.selectedPenStroke = SettingManager.Strokes.get(stroke);
	}
	static public void setEraserStroke(int stroke) {
		if (stroke < 1 || stroke > 10) {
			System.out.println("Error in setStroke -> selectedStroke was not changed");
			return;
		}
//		MyFrame.paintStroke = SettingManager.Strokes.get(stroke);
		MyFrame.selectedEraserStroke = SettingManager.Strokes.get(stroke);
	}
	
}
