package main;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import manager.CursorManager;
import manager.FocusManager;
import manager.SettingManager;
import manager.ShortCutManager;
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
	public CursorManager cursorManager = new CursorManager(myFrame);
	
	public PaintPanel paintPanel = new PaintPanel();
	public MenuPanel menuPanel = new MenuPanel(myFrame);
	
	SettingManager settingManager = new SettingManager(myFrame);
	ShortCutManager shortCutManager = new ShortCutManager(menuPanel);


	MyFrame(){
		// Set Default Settings
		settingManager.resetSettings();
		c.setLayout(new BorderLayout());
		cursorManager.setPenCursor(CursorManager.PEN);
		
		c.add(menuPanel, BorderLayout.NORTH);
		
		c.add(paintPanel, BorderLayout.CENTER);
		paintPanel.addMouseMotionListener(new PaintingListener(paintPanel));
		paintPanel.addMouseListener(new PaintSEListener());
			
		shortCutManager.setShortCutAll();

		setVisible(true);
		setFocusable(true);
		addWindowFocusListener(new FocusManager());
	}

}
