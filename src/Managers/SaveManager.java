package Managers;
import java.awt.Component;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mypanel.PaintPanel;

public class SaveManager {
	PaintPanel c;
	JFrame j;
	
	public void start(PaintPanel c, JFrame j) {                                             
		this.c = c;
		this.j = j;
		BufferedImage image = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		c.printAll(g);
		g.dispose();
		JFileChooser chooser = new JFileChooser();
		chooser.approveSelection();
		chooser.getSelectedFile();
		
		
		try { 
		    ImageIO.write(image, "png", new File(getSavePath())); 
		    System.out.println("����Ϸ�!");
		} catch (Exception e) {
		    System.out.println("�������");
		}
    }
	
	private String getSavePath() throws Exception {
		FileDialog fd = new FileDialog(j, "file select", FileDialog.SAVE);
		fd.setVisible(true);
		StringBuilder sb = new StringBuilder();
		if (fd.getDirectory() == null) {
			throw new Exception();
		}
		sb.append(fd.getDirectory());
		sb.append(fd.getFile());
		sb.append(".png");
		return sb.toString();
	}
}