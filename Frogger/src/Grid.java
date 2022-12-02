import java.awt.Color;
import java.awt.Graphics;

public class Grid {
	private boolean[][] grid;
	private int length;
	private int height;
	private int segmentsize;
	
	public Grid() {
		segmentsize = 64;
		length = 24;
		height = 12;
		grid = new boolean[length][height];
		
		for (int i = 0; i < length;i++) {
			for (int a = 0; i < height;i++) {
				grid[i][a] = false;
			}
		}
	}
	//
	
	public Grid(int argS, int argL, int argH) {
		segmentsize = argS;
		length = argL;
		height = argH;
		grid = new boolean[length][height];
		
		for (int i = 0; i < length;i++) {
			for (int a = 0; i < height;i++) {
				grid[i][a] = false;
			}
		}
		
	}
	
	public int getSegmentSize() {return segmentsize;}
	public int getLength()      {return length;}
	public int getHeight()      {return height;}
	
	public void setSegmentSize(int argS) {segmentsize = argS;}
	public void setLength(int argL)      {segmentsize = argL;}
	public void setHeight(int argH)      {segmentsize = argH;}
	
	public void paint(Graphics g) {
		Color c = new Color(0,0,0);
        g.setColor(c);
        for (int i = 1; i <= length; i++) {
        	g.drawLine(i*segmentsize, 0, i*segmentsize, 900);
        }
        for (int i = 1; i <= height; i++) {
        	g.drawLine(0, i*segmentsize, 1600, i*segmentsize);
        }
    }
	
	
}
