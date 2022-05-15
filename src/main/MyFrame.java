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

import Managers.SettingManager;
import mylistener.*;
import mypanel.*;
import point.PointInfo;
import point.PointsHistory;

// ToDos
// When mouseDragged in PaintPanel is True, All Menu listeners have to be inactive.

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	static public Color selectedColor;
	static public BasicStroke selectedStroke;
	public static ArrayList<ArrayList<PointInfo>> points = new ArrayList<ArrayList<PointInfo>>();
	public static PointsHistory pointsHistory = new PointsHistory();
	
	Container c = getContentPane();
	MyFrame myFrame = this;
	SettingManager settingManager = new SettingManager(myFrame);
	
	public PaintPanel paintPanel = new PaintPanel();
	public MenuPanel menuPanel = new MenuPanel(myFrame);


	MyFrame(){
		// Set Default Settings
		settingManager.resetSettings();
		c.setLayout(new BorderLayout());
		
		c.add(menuPanel, BorderLayout.NORTH);
		
		c.add(paintPanel, BorderLayout.CENTER);
		paintPanel.addMouseMotionListener(new PaintingListener(paintPanel));
		paintPanel.addMouseListener(new PaintSEListener());
		
		setVisible(true);
	}
 
	

	
	
	
	public static void main(String[] args) {
//		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("apple.awt.application.appearance", "system"); // Apple Appearance (able to be Dark Mode)
		MyFrame mf = new MyFrame();
		
		

	}

}
