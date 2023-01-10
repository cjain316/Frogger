import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
//a
public class Main extends JPanel implements KeyListener, ActionListener {
	private Grid grid = new Grid();
	private Frog player = new Frog(0, 0,32, "Resources//FrogJump.gif");
	private Log[] first = new Log[grid.getLength()+4];
	private Background background = new Background(0,0,"Resources//background.png");
	private Grass grass = new Grass(grid);
	Timer c = new Timer(1,this);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main f = new Main();
		
	}
	
	public void paint(Graphics g) {
        super.paintComponent(g);
        background.paint(g);
        grid.paint(g);
        grass.paint(g, grid);
        for (int i = 0;i<first.length;i++) {
        	if(first[i] != null) {
        		first[i].update(grid,player);
        		first[i].paint(g);
        	}
        }
        player.paint(g,grid);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
		
	}
	//as

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getExtendedKeyCode() == 87 && player.getY() > 0) {
			player.setY(player.getY()-1);
		}
		if (arg0.getExtendedKeyCode() == 65 && player.getX() > 0) {
			player.setX(player.getX()-1);
		}
		if (arg0.getExtendedKeyCode() == 83 && player.getY() <= grid.getHeight()) {
			player.setY(player.getY()+1);
		}
		if (arg0.getExtendedKeyCode() == 68 && player.getX() <= grid.getLength()) {
			player.setX(player.getX()+1);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	Timer t;
    
    public Main() {
    	for (int i = 0; i < first.length;i++) {
        	if (i%6!=0 && i%6!=1 && i%6!=2) {
        		first[i] = new Log(i,8,true,1);
        	}
    	}
    	
        JFrame f = new JFrame("Le Froge");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1680,934);
        f.add(this);
        f.addKeyListener(this);
        
        t = new Timer(7, this);
        t.start();
        f.setVisible(true);
        
       
        
    }

}
