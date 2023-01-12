import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Street {
	// GRASS CODES: 4; Flowers     5; GrassPatch      6; Grass
	private String path = "Resources//road.gif";
	private int[][] grid;
	public AffineTransform tx;
	public Image Sprite;
	private int width;
	private int y;
	
	public Street(Grid g) {
		generateRoad(2,10,g);
		generateRoad(1,8,g);

		System.out.println(g.toString());
	}
	
	public void paint(Graphics g, Grid f) {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < f.getLength();i++) {
        	for (int a = 0; a < f.getHeight();a++) {
        		if (f.getValue(i,a) == 3) {
        			tx = AffineTransform.getTranslateInstance(i*64, a*64);
            		Sprite = getImage(path);
            		g2.drawImage(Sprite, tx, null);
        		}
        	}
        }
    }
	
	private void generateRoad(int width, int offset, Grid g) {
		for (int i = 0; i < g.getLength(); i++) {
			for (int a = offset; a < width+offset; a++) {
				g.setValue(i, a, 3);
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
