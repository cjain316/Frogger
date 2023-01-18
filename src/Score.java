import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Score {
	 private int score;
	 private String path = "Resources//flag.gif";
	 private Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 64);
	public  AffineTransform tx;
	public  Image Sprite;
	
	public Score() {
		score = 0;
		ListJavaFonts();
	}
	
	public  void updateScore(int x) {
		score+=x;
	}
	
	public  void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(""+score, 850, 100);
		
		tx = AffineTransform.getTranslateInstance(780, 50);
		Sprite = getImage(path);
		g2.drawImage(Sprite, tx, null);
	}
	
	protected  Image getImage(String path) {

        Image tempImage = null;
        try {
            URL imageURL = Background.class.getResource(path);
            tempImage    = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {e.printStackTrace();}
        return tempImage;
    } 
	
	public void ListJavaFonts() {
		    String fonts[] = 
		      GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		    for (int i = 0; i < fonts.length; i++) {
		      System.out.println(fonts[i]);
		    }
		  }
}
