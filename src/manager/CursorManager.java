package manager;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import main.MiniCanvas;
import main.MyFrame;

public class CursorManager {
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static ImageIcon PENICON = new ImageIcon(MiniCanvas.class.getResource("/img/pen.png"));
	private static Image PENIMAGE = PENICON.getImage();
	private static ImageIcon ERASERICON = new ImageIcon(MiniCanvas.class.getResource("/img/eraser.png"));
	private static Image ERASERIMAGE = ERASERICON.getImage();
	@SuppressWarnings("serial")
	private static ArrayList<Cursor> cursorList = new ArrayList<Cursor>() {{
		add(tk.createCustomCursor(PENIMAGE, new Point(0, 30), "pen"));
		add(tk.createCustomCursor(ERASERIMAGE, new Point(12, 30), "eraser"));
	}};
	
	public static final int PEN = 0;
	public static final int ERASER = 1;
	MyFrame myFrame;
	
	public CursorManager(MyFrame myFrame) {
		this.myFrame = myFrame;
	}
	
	public void setCursor(int cursorShape) {
		if (cursorShape < 0 || cursorShape >= cursorList.size()) return;
		
		myFrame.paintPanel.setCursor(cursorList.get(cursorShape));
	}
}
