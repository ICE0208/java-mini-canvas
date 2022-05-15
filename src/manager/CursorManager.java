package manager;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import main.Main;
import main.MyFrame;

public class CursorManager {
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static ImageIcon PENICON = new ImageIcon(Main.class.getResource("/img/pen.png"));
	private static Image PENIMAGE = PENICON.getImage();
	Point point = new Point(0, 30);
	@SuppressWarnings("serial")
	private static ArrayList<Cursor> cursorList = new ArrayList<Cursor>() {{
		add(tk.createCustomCursor(PENIMAGE, new Point(0, 30), "pen"));
	}};
	
	public static final int PEN = 0;
	public static final int ERASER = 1;
	public static int selectedCursor = PEN;
	MyFrame myFrame;
	
	public CursorManager(MyFrame myFrame) {
		this.myFrame = myFrame;
	}
	
	public void setPenCursor() {
		myFrame.paintPanel.setCursor(cursorList.get(selectedCursor));
	}
}
