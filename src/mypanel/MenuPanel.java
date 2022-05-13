package mypanel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import main.MyFrame;
import mylistener.SaveListener;
import mylistener.RemoveAllListener;

public class MenuPanel extends JPanel {
	public MenuPanel(MyFrame myFrame) {
		add(new JButton("Nothing"));
		JButton undoButton = new JButton("Remove All");
		undoButton.addActionListener(new RemoveAllListener());
		add(undoButton);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new SaveListener(myFrame.getPaintPanel(), myFrame));
//		myFrame.getPaintPanel();
		add(saveButton);
	}
}
