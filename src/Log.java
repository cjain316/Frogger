import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

import javax.swing.JPanel;

public class Log extends JPanel {
	private int x,y;
	private boolean direction; //True: Right || False: Left
	private int size = 64;
	private int width;
	private int counter = 0;
	private int spriter;
	private int artificial;
	public Image Sprite;
	public AffineTransform tx;
	private String[] sprites = {"Resources//Log.gif","Resources//Lilypad.gif"};
	
	public Log() {
		x = 0;
		y = 0;
		direction = true;
		width = 3;
	}
	
	public Log(int argx, int argy, boolean argdirection, int argw, Grid g) {
		x = argx;
		y = argy;
		direction = argdirection;
		width = argw;
		spriter = (int)(Math.random()*2);
	}
	
	public void update(Grid g,Frog f) {
		counter++;
		if (direction) {artificial = counter;}
		if (!direction) {artificial = -counter;}
		if (x > g.getLength() + 2) {
			x = 0;
		}
		if (x < 0) {
			x = g.getLength();
		}
		if (counter == 8) {
			counter = 0;
			if (direction) {
				if (f.getX() == x && f.getY() == y) {
					f.setX(f.getX() + 1);
				}
				x += 1;
			} else {
				if (f.getX() == x && f.getY() == y) {
					f.setX(f.getX() - 1);
				}
				x -= 1;
			}
		}
	}
	
	public int getArtificial() {
		return artificial;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean getDir() {
		return direction;
	}
	public boolean getCounter() {
		return direction;
	}
	
	public void paint(Graphics g) {
		Sprite = getImage(sprites[spriter]);
		if (direction) {
			tx = AffineTransform.getTranslateInstance(x*64+(counter*8), y*64);
		}
		if (!direction) {
			tx = AffineTransform.getTranslateInstance(x*64-(counter*8), y*64);
		}
		Color c = new Color(0,0,0);
		Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(Sprite, tx, null);
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
