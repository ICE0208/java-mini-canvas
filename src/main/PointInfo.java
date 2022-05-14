package main;

import java.awt.BasicStroke;
import java.awt.Color;

public class PointInfo {
	public int x;
	public int y;
	public Color color;
	public BasicStroke stroke;
	
	public PointInfo(int x, int y, Color color, BasicStroke stroke) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.stroke = stroke;
	}
}
