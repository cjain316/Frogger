import java.awt.Image;
import java.awt.geom.AffineTransform;

public class Road {
	private int x,y;
	private int size = 64;
	private int width;
	private int counter = 0;
	public Image Sprite;
	public AffineTransform tx;
	private String path = "Resources//wood.png";
	
	public Road() {
		x = 0;
		y = 0;
		width = 3;
	}
	
	public void update(Grid g,Frog f) {
		
	}
}
