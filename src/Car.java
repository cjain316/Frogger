import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

import javax.swing.JPanel;

public class Car extends JPanel {
	private int x,y;
	private boolean direction; //True: Right || False: Left
	private int size = 64;
	private int width;
	private int counter = 0;
	private int color;
	public Image Sprite;
	public AffineTransform tx;
	private String[] sprites = {"Resources//Orange_car.gif","Resources//Blue_car.gif","Resources//Green_car.gif",
			                    "Resources//Orange_car_r.gif","Resources//Blue_car_r.gif","Resources//Green_car_r.gif"};
	
	public Car(Grid g) {
		x = 0;
		y = 0;
		direction = true;
		width = 3;
		int ran;
		for (int i = 0; i < g.getHeight(); i++) {
			for (int a = 0; a < g.getLength(); a++) {
				if (g.getValue(a,i) == 1 || g.getValue(i, a) == 0) {
					ran = (int)(Math.random()*10);
					if (ran >= 9) {
						g.setValue(a, i, 4);
					} else if (ran > 6) {
						g.setValue(a, i, 5);
					} else {
						g.setValue(a, i, 6);
					}
				
				}
			}
		}
	}
	
	public Car(int argx, int argy, boolean argdirection, int argw, Grid g) {
		x = argx;
		y = argy;
		direction = argdirection;
		width = argw;
		int ran;
		for (int i = 0; i < g.getLength(); i++) {
			for (int a = 0; a < g.getHeight(); a++) {
				ran = (int)(Math.random()*3);
				if (ran == 0) {
					color = 0;
				} else if (ran == 1) {
					color = 1;
				} else {
					color = 2;
				}
			}
		}
	}
	
	public void update(Grid g,Frog f) {
		counter++;
		if (x > g.getLength()) {
			x = 0;
		}
		if (x < 0) {
			x = g.getLength();
		}
		if (counter == 8) {
			counter = 0;
			if (f.getX() == x && f.getY() == y) {
				f.setAlive(false);
			}
			if (direction) {
				x++;
			}
			if (!direction) {
				x--;
			}
		}
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (direction) {
			tx = AffineTransform.getTranslateInstance(x*64+(counter*8), y*64);
		}
		if (!direction) {
			tx = AffineTransform.getTranslateInstance(x*64-(counter*8), y*64);
		}
		if (direction) {
			Sprite = getImage(sprites[color]);
		} else {
			Sprite = getImage(sprites[color+3]);
		}
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
