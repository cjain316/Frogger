package src;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import javax.swing.JPanel;

public class Background extends JPanel{
	public Image Sprite;
	public AffineTransform tx;
	private int x,y;

	public Background(int x, int y, String path){
	        Sprite = getImage(path);
	        tx = AffineTransform.getTranslateInstance(x, y);
	    }

	public void paint(Graphics g) {
	        update();
	        Graphics2D g2 = (Graphics2D) g;
	        g2.drawImage(Sprite, tx, null);
	    }

	public void update() {
	        tx.setToTranslation(x, y);
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
