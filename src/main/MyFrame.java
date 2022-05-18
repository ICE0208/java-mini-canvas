package main;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import manager.CursorManager;
import manager.SettingManager;
import mylistener.*;
import mypanel.*;
import point.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	public static Color paintColor;
	public static Color selectedColor;
	public static BasicStroke selectedStroke;
	public static ArrayList<ArrayList<PointInfo>> points = new ArrayList<ArrayList<PointInfo>>();
	public static PointsHistory pointsHistory = new PointsHistory();
	
	public Container c = getContentPane();
	public MyFrame myFrame = this;
	SettingManager settingManager = new SettingManager(myFrame);
	public CursorManager cursorManager = new CursorManager(myFrame);
	
	public PaintPanel paintPanel = new PaintPanel();
	public MenuPanel menuPanel = new MenuPanel(myFrame);


	MyFrame(){
		// Set Default Settings
		settingManager.resetSettings();
		c.setLayout(new BorderLayout());
		cursorManager.setPenCursor(CursorManager.PEN);
		
		c.add(menuPanel, BorderLayout.NORTH);
		
		c.add(paintPanel, BorderLayout.CENTER);
		paintPanel.addMouseMotionListener(new PaintingListener(paintPanel));
		paintPanel.addMouseListener(new PaintSEListener());
	
		
		setVisible(true);
		menuPanel.requestFocus();
	}


}
