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

import mylistener.*;
import mypanel.*;


@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	static public Color selectedColor;
	static public BasicStroke selectedStroke;
	public static ArrayList<ArrayList<PointInfo>> points = new ArrayList<ArrayList<PointInfo>>();
	
	Container c = getContentPane();
	MyFrame myFrame = this;
	SettingManager settingManager = new SettingManager(myFrame);
	
	PaintPanel paintPanel = new PaintPanel();
	MenuPanel menuPanel = new MenuPanel(myFrame);
	
	public PaintPanel getPaintPanel() {	
		return paintPanel;
	}


	MyFrame(){
		// 제목, 크기 등 기본 JFrame 설정
		settingManager.resetSettings();
		c.setLayout(new BorderLayout());
		
		c.add(menuPanel, BorderLayout.NORTH);
		c.add(paintPanel, BorderLayout.CENTER);
		
		paintPanel.addMouseMotionListener(new PaintListener(paintPanel));
		paintPanel.addMouseListener(new PaintListener2());
		
		setVisible(true);
	}
 
	

	
	
	
	public static void main(String[] args) {
//		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("apple.awt.application.appearance", "system"); // Apple Appearance (able to be Dark Mode)
		MyFrame mf = new MyFrame();
		
		

	}

}
