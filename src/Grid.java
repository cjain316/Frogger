import java.awt.Color;
import java.awt.Graphics;

public class Grid {
	private int[][] grid;
	private int length;
	private int height;
	private int segmentsize;
	
	
	public Grid() {
		segmentsize = 64;
		length = 26;
		height = 14;
		grid = new int[length][height];
		
		for (int i = 0; i < length;i++) {
			for (int a = 0; i < height;i++) {
				grid[i][a] = 1;
			}
		}
	}
	//
	
	public Grid(int argS, int argL, int argH) {
		segmentsize = argS;
		length = argL;
		height = argH;
		grid = new int[length][height];
		
		for (int i = 0; i < length;i++) {
			for (int a = 0; i < height;i++) {
				grid[i][a] = 1;
			}
		}
		
	}
	
	public String toString() {
		String output = "";
		for (int i = 0; i < height; i++) {
			for (int a = 0; a < length; a++) {
				output += grid[a][i];
			}
			output += "\n";
		}
		return output;
	}
	
	public int getSegmentSize() {return segmentsize;}
	public int getLength()      {return length;}
	public int getHeight()      {return height;}
	public int getValue(int x, int y)      {return grid[x][y];}
	
	public void setSegmentSize(int argS) {segmentsize = argS;}
	public void setLength(int argL)      {segmentsize = argL;}
	public void setHeight(int argH)      {segmentsize = argH;}
	public void setValue(int x, int y, int val)   {grid[x][y] = val;}
	
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
