import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Water {
	// GRASS CODES: 4; Flowers     5; GrassPatch      6; Grass
	private String path = "Resources//water.gif";
	private int[][] grid;
	public AffineTransform tx;
	public Image Sprite;
	private int width;
	private int y;
	
	public Water(Grid g) {
		generateWater((int)((Math.random()*2)+1),(int)((Math.random()*8)+2),g);
		generateWater((int)((Math.random()*2)+1),(int)((Math.random()*8)+2),g);
		generateWater((int)((Math.random()*2)+1),(int)((Math.random()*8)+2),g);

		System.out.println(g.toString());
	}
	
	public void regenerateWater(Grid g) {
		generateWater((int)((Math.random()*2)+1),(int)((Math.random()*8)+2),g);
		generateWater((int)((Math.random()*2)+1),(int)((Math.random()*8)+2),g);
		generateWater((int)((Math.random()*2)+1),(int)((Math.random()*8)+2),g);
	}
	
	public void paint(Graphics g, Grid f) {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < f.getLength();i++) {
        	for (int a = 0; a < f.getHeight();a++) {
        		if (f.getValue(i,a) == 8) {
        			tx = AffineTransform.getTranslateInstance(i*64, a*64);
            		Sprite = getImage(path);
            		g2.drawImage(Sprite, tx, null);
        		}}}}
	
	public void generateWater(int width, int offset, Grid g) {
		for (int i = 0; i < g.getLength(); i++) {
			for (int a = offset; a < width+offset; a++) {
				g.setValue(i, a, 8);
			}}}
	
	protected Image getImage(String path) {

        Image tempImage = null;
        try {
            URL imageURL = Background.class.getResource(path);
            tempImage    = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {e.printStackTrace();}
        return tempImage;
    } 
	
	
}
