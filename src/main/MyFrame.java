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

public class MyFrame extends JFrame{
	static Color selectedColor;
	public static ArrayList<Point> points = new ArrayList<Point>();
	
	Container c = getContentPane();
	MyFrame myFrame = this;
	
	
	PaintPanel paintPanel = new PaintPanel();
	MenuPanel menuPanel = new MenuPanel(myFrame);
	
	public PaintPanel getPaintPanel() {
		
		return paintPanel;
	}


	MyFrame(){
		// 제목, 크기 등 기본 JFrame 설정
		SettingManager settingManager = new SettingManager(myFrame);
		c.setLayout(new BorderLayout());
		
		c.add(menuPanel, BorderLayout.NORTH);
		c.add(paintPanel, BorderLayout.CENTER);
		
		paintPanel.addMouseMotionListener(new PaintListener(paintPanel));
		
		setVisible(true);
	}
 
	

	
	
	
	public static void main(String[] args) {
//		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("apple.awt.application.appearance", "system"); // Apple Appearance (able to be Dark Mode)
		MyFrame mf = new MyFrame();
		
		

	}

}
