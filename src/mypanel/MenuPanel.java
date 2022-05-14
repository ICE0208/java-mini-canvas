package mypanel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import main.MyFrame;
import mylistener.SaveListener;
import mylistener.UndoListener;
import mylistener.ColorListener;
import mylistener.RemoveAllListener;

public class MenuPanel extends JPanel {
	public MenuPanel(MyFrame myFrame) {
		
		JButton colorSelector = new JButton("Color");
		colorSelector.addActionListener(new ColorListener());
		add(colorSelector);
		
		// Undo Button
		JButton undoButton = new JButton("Undo");
		undoButton.addActionListener(new UndoListener());
		add(undoButton);
		
		// Remove All Button
		JButton removeAllButton = new JButton("Remove All");
		removeAllButton.addActionListener(new RemoveAllListener());
		add(removeAllButton);
		
		// Save Button
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new SaveListener(myFrame.getPaintPanel(), myFrame));
//		myFrame.getPaintPanel();
		add(saveButton);
	}
}
