import java.awt.Color;
import java.awt.Graphics;

public class Frog {
	int x,y;
	int size;
	//
	
	public Frog() {
		x = 0;
		y = 0;
		size = 32;
	}
	
	public Frog(int argX,int argY,int argS) {
		x = argX;
		y = argY;
		size = argS;
		
	}
	
	public int getX()    {return x;}
	public int getY()    {return y;}
	public int getSize() {return size;}
	
	public void setX(int argX)    {x = argX;}
	public void setY(int argY)    {y = argY;}
	public void setSize(int argS) {size = argS;}
	
	public void paint(Graphics g) {
		Color c = new Color(0,0,0);
        g.setColor(c);
        g.fillRect(x*32, y*32, size, size);
    }
}
