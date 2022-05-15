package main;

public class Main {
	public static MyFrame myFrame;
	public static void main(String[] args) {
//		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("apple.awt.application.appearance", "system"); // Apple Appearance (able to be Dark Mode)
		myFrame = new MyFrame();
		
	}
}

//ToDos
// When mouseDragged in PaintPanel is True, All Menu listeners have to be inactive.
// When a file with same name in selected path exists, Show ConfirmDialog (replace or no)
