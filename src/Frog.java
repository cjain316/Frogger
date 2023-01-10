import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Frog {
	public Image Sprite;
	public AffineTransform tx;
	int x,y;
	int size;
	private boolean alive;
	//as
	
	public Frog() {
		alive = true;
		x = 0;
		y = 0;
		size = 64;
	}
	
	public Frog(int argX,int argY,int argS,  String path) {
		alive = true;
		x = argX;
		y = argY;
		size = argS;
		Sprite = getImage(path);
		tx = AffineTransform.getTranslateInstance(x, y);
	}
	
	public int getX()    {return x;}
	public int getY()    {return y;}
	public int getSize() {return size;}
	public boolean getAlive()    {return alive;}
	
	public void setX(int argX)    {x = argX;}
	public void setY(int argY)    {y = argY;}
	public void setSize(int argS) {size = argS;}
	public void setAlive(boolean argS) {alive = argS;}
	
	
	public void paint(Graphics g, Grid f) {
        update(f);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(Sprite, tx, null);
    }

	public void update(Grid f) {
        tx.setToTranslation(x*f.getSegmentSize(), y*f.getSegmentSize());
    }
	protected Image getImage(String path) {

        Image tempImage = null;
        try {
            URL imageURL = Background.class.getResource(path);
            tempImage    = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {e.printStackTrace();}
        return tempImage;
    } 
}
