import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Grass {
	// GRASS CODES: 4; Flowers     5; GrassPatch      6; Grass
	private String[] sprites = {"Resources//Flowers.png","Resources//Grass.png","Resources//GrassPatch.png"};
	private int[][] grid;
	public AffineTransform tx;
	public Image Sprite;
	
	public Grass(Grid g) {
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
	
	public void paint(Graphics g, Grid f) {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < f.getLength();i++) {
        	for (int a = 0; a < f.getHeight();a++) {
        		tx = AffineTransform.getTranslateInstance(i*64, a*64);
        		if (f.getValue(i, a) == 4) {
        			Sprite = getImage(sprites[0]);
        		}
        		if (f.getValue(i, a) == 6) {
        			Sprite = getImage(sprites[1]);
        		}
        		if (f.getValue(i, a) == 5) {
        			Sprite = getImage(sprites[2]);
        		}
        		g2.drawImage(Sprite, tx, null);
        	}
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
