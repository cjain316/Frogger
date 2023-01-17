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
	
	
	public void paint(Graphics g, Grid f, Log l) {
        update(f,l);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(Sprite, tx, null);
    }

	public void update(Grid f,Log l) {
		if (alive == false) {
			x = f.getLength()/2;
			y = f.getHeight()-2;
			alive = true;
		}
		if (l!=null) {
			tx.setToTranslation(x*f.getSegmentSize()+16+(l.getArtificial()*8), y*f.getSegmentSize()+16);
		} else {
			tx.setToTranslation(x*f.getSegmentSize()+16, y*f.getSegmentSize()+16);
		}
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
