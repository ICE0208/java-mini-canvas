package mypanel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import main.MyFrame;
import mylistener.SaveListener;

public class MenuPanel extends JPanel {
	public MenuPanel(MyFrame myFrame) {
		add(new JButton("1"));
		add(new JButton("2"));
		
		JButton saveButton = new JButton("저장하기");
		saveButton.addActionListener(new SaveListener(myFrame.getPaintPanel(), myFrame));
//		myFrame.getPaintPanel();
		add(saveButton);
	}
}
