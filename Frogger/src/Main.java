import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements KeyListener, ActionListener {
	private Grid grid = new Grid();
	private Frog player = new Frog();
	Timer c = new Timer(1,this);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main f = new Main();
	}
	
	public void paint(Graphics g) {
        super.paintComponent(g);
        player.paint(g);
        grid.paint(g);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getExtendedKeyCode());
		System.out.println(c.toString());
		if (arg0.getExtendedKeyCode() == 87) {
			player.setY(player.getY()-1);
		}
		if (arg0.getExtendedKeyCode() == 65) {
			player.setX(player.getX()-1);
		}
		if (arg0.getExtendedKeyCode() == 83) {
			player.setY(player.getY()+1);
		}
		if (arg0.getExtendedKeyCode() == 68) {
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
        JFrame f = new JFrame("Le Froge");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,900);
        f.add(this);
        f.addKeyListener(this);
        
        t = new Timer(7, this);
        t.start();
        f.setVisible(true);
       
        
    }

}
