package main;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import mylistener.*;
import mypanel.*;

public class MyFrame extends JFrame{
	static Color selectedColor;
	
	Container c = getContentPane();
	JFrame myFrame = this;
	SaveListener saveListener = new SaveListener(c, myFrame);
	
	
	MenuPanel menuPanel = new MenuPanel();
	PaintPanel paintPanel = new PaintPanel();

	
	MyFrame(){
		// 제목, 크기 등 기본 JFrame 설정
		SettingManager settingManager = new SettingManager(myFrame);
		c.setLayout(new BorderLayout());
		
		c.add(menuPanel, BorderLayout.NORTH);
		c.add(paintPanel, BorderLayout.CENTER);
		
		paintPanel.addMouseMotionListener(new PaintListener());
		
		setVisible(true);
	}
 
	

	
	
	
	public static void main(String[] args) {
//		System.setProperty("apple.laf.useScreenMenuBar", "true");
		MyFrame mf = new MyFrame();
		
		

	}

}
