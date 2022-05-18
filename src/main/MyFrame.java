package main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
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
		addKeyListener(new BtnKeyListener());
		addWindowFocusListener(new focus());
		
		requestFocus();
	}
	
	boolean isDialong = false;
	boolean isLost = false;
	
	public void forceFocus() {
		// Reference
		// https://stackoverflow.com/questions/12278546/focus-issues-with-java7-modal-dialogs-on-mac-osx
		isDialong = true;
		JDialog focusDialog = new JDialog(); 
		focusDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); 
		focusDialog.setUndecorated(true); 

		System.out.println("Forcing Focus...");
	    Timer timer = new Timer(50, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("Focus Done!");
	            focusDialog.dispose();
	            isDialong = false;
	        }
	    });
	    focusDialog.pack();
	    focusDialog.setVisible(true);
		timer.setRepeats(false);
		timer.start();
	}
		
	
	class focus implements WindowFocusListener {

		@Override
		public void windowGainedFocus(WindowEvent e) {
			Main.myFrame.requestFocus();
			if (isLost == false) return;
			isLost = false;
			forceFocus();
			
		}

		@Override
		public void windowLostFocus(WindowEvent e) {
			if (isDialong == false) {
				isLost = true;
			}
			
			if (PaintSEListener.painting == false) return;
			PaintSEListener.forceMouseReleased();
		}
	}


}
