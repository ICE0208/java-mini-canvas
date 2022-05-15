package mypanel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import main.MyFrame;
import mylistener.SaveListener;
import mylistener.UndoListener;
import mylistener.RedoListener;
import mylistener.ColorListener;
import mylistener.RemoveAllListener;

public class MenuPanel extends JPanel {
	public Container seleColor = new selectedColorContainer();
	public MenuPanel(MyFrame myFrame) {
		
		seleColor.addMouseListener(new ColorListener(myFrame));
		add(seleColor);
		
//		JButton colorSelector = new JButton("Color");
//		colorSelector.addActionListener(new ColorListener(myFrame));
//		add(colorSelector);
		
		// Undo Button
		JButton undoButton = new JButton("Undo");
		undoButton.addActionListener(new UndoListener());
		add(undoButton);
		
		// Redo Button
		JButton redoButton = new JButton("Redo");
		redoButton.addActionListener(new RedoListener());
		add(redoButton);
		
		// Remove All Button
		JButton removeAllButton = new JButton("Remove All");
		removeAllButton.addActionListener(new RemoveAllListener());
		add(removeAllButton);
		
		// Save Button
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new SaveListener(myFrame.paintPanel, myFrame));
//		myFrame.getPaintPanel();
		add(saveButton);
	}

	class selectedColorContainer extends Container {
		static final int SIZE = 16;
		
		public selectedColorContainer() {
			setPreferredSize(new Dimension(SIZE, SIZE));
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(MyFrame.selectedColor);
			g.fillOval(0, 0, SIZE, SIZE);
		}
	}
}
