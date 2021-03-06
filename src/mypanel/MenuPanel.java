package mypanel;

import java.awt.*;

import javax.swing.*;

import main.MyFrame;
import mylistener.*;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	public Container seleColor = new selectedColorContainer();
	public SaveListener saveListener;
	public UndoListener undoListener;
	public RedoListener redoListener;
	
	public MenuPanel(MyFrame myFrame) {
		
		seleColor.addMouseListener(new ColorListener(myFrame));
		add(seleColor);
		
		JButton selectPen = new JButton("Pen");
		selectPen.addActionListener(new PenListener());
		add(selectPen);
		
		String[] penStrokes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		JComboBox<Object> setPenStrokeCombo = new JComboBox<Object>(penStrokes);
		setPenStrokeCombo.setSelectedItem("4"); // default value
		setPenStrokeCombo.setBackground(Color.LIGHT_GRAY);
		setPenStrokeCombo.addActionListener(new PenStrokeListener());
		add(setPenStrokeCombo);
		
		add(new JSeparator(SwingConstants.VERTICAL)); // ????
		
		JButton selectEraser = new JButton("Eraser");
		selectEraser.addActionListener(new EraserListener());
		add(selectEraser);
		
		String[] eraserStrokes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		JComboBox<Object> setEraserStrokeCombo = new JComboBox<Object>(eraserStrokes);
		setEraserStrokeCombo.setSelectedItem("4"); // default value
		setEraserStrokeCombo.setBackground(Color.LIGHT_GRAY);
		setEraserStrokeCombo.addActionListener(new EraserStrokeListener());
		add(setEraserStrokeCombo);
		
		add(new JSeparator(SwingConstants.VERTICAL)); // ????
		
		// Undo Button
		JButton undoButton = new JButton("Undo");
		undoListener = new UndoListener();
		undoButton.addActionListener(undoListener);
		add(undoButton);
		
		
		// Redo Button
		JButton redoButton = new JButton("Redo");
		redoListener = new RedoListener();
		redoButton.addActionListener(redoListener);
		add(redoButton);
		
		// Remove All Button
		JButton removeAllButton = new JButton("Remove All");
		removeAllButton.addActionListener(new RemoveAllListener());
		add(removeAllButton);
		
		// Save Button
		JButton saveButton = new JButton("Save");
		saveListener = new SaveListener(myFrame.paintPanel, myFrame);
		saveButton.addActionListener(saveListener);
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
