package main;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import manager.CursorManager;
import manager.SettingManager;
import mylistener.*;
import mypanel.*;
import point.PointInfo;
import point.PointsHistory;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
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
		cursorManager.setPenCursor();
		
		c.add(menuPanel, BorderLayout.NORTH);
		
		c.add(paintPanel, BorderLayout.CENTER);
		paintPanel.addMouseMotionListener(new PaintingListener(paintPanel));
		paintPanel.addMouseListener(new PaintSEListener());
		
		setVisible(true);
		requestFocus();
	}


}
