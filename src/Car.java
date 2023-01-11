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
	private String[] sprites = {"Resources//Orange_car.gif","Resources//Blue_car.gif","Resources//Green_car.gif"};
	
	public Car(Grid g) {
		x = 0;
		y = 0;
		direction = true;
		width = 3;
		int ran;
		for (int i = 0; i < g.getLength(); i++) {
			for (int a = 0; a < g.getHeight(); a++) {
				if (g.getValue(i,a) == 1 || g.getValue(i, a) == 0) {
					ran = (int)(Math.random()*10);
					if (ran >= 9) {
						g.setValue(i, a, 4);
					} else if (ran > 6) {
						g.setValue(i, a, 5);
					} else {
						g.setValue(i, a, 6);
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
		if (x >= g.getLength()) {
			x = 0;
		}
		if (counter == 20) {
			counter = 0;
			if (f.getX() == x && f.getY() == y) {
				f.setAlive(false);
			}
		}
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
        tx = AffineTransform.getTranslateInstance(x*64, y*64);
        Sprite = getImage(sprites[color]);
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
