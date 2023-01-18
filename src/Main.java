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
	private Score score = new Score();
	private Frog player = new Frog(grid.getLength()/2, grid.getHeight()-2,32, "Resources//FrogIdle.gif");
	private Log[][] logs = new Log[grid.getLength()+4][grid.getHeight()];
	private Car[][] cars = new Car[grid.getLength()][grid.getHeight()];
	private Grass grass = new Grass(grid);
	private Street street = new Street(grid);
	private Water water = new Water(grid);
	Timer c = new Timer(1,this);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main f = new Main();
		
	}
	
	public void paint(Graphics g) {
        super.paintComponent(g);
        update();
        grid.paint(g);
        grass.paint(g, grid);
        street.paint(g, grid);
        water.paint(g, grid);
        for (int i = 0;i<grid.getLength();i++) {
        	for (int a = 0;a<grid.getHeight();a++) {
        		if(logs[i][a] != null) {
        			logs[i][a].update(grid,player);
        			logs[i][a].paint(g);
        		}
        	}
        }
        for (int i = 0;i<grid.getLength();i++) {
        	for (int a = 0;a<grid.getHeight();a++) {
        		if(cars[i][a] != null) {
        			cars[i][a].update(grid,player);
        			cars[i][a].paint(g);
        		}
        	}
        }
        if (getRiding()[0] != -1) {player.paint(g,grid,logs[getRiding()[0]][getRiding()[1]], score);} 
        else {player.paint(g, grid, null, score);}
        
        if (player.getY() == 0) {
        	score.updateScore(1);
			regenerate(grid, street, water, grass);
		}
        score.paint(g);
       }
	
	private int[] getRiding() {
		int[] output = new int[2];
		for (int i = 0;i<grid.getLength();i++) {
            for (int a = 0;a<grid.getHeight();a++) {
            	if (logs[i][a] != null) {
            		if (logs[i][a].getX() == player.getX()) {
            			if (logs[i][a].getY() == player.getY()) {
            				output[0] = i;
            				output[1] = a;
            				return output;
            			}
            		}
            	}
            }
        }
		output[0] = -1;
		output[1] = -1;
		return output;
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
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getExtendedKeyCode() == 82) {
			regenerate(grid, street, water, grass);
		}
		if (arg0.getExtendedKeyCode() == 87 && player.getY() > 0) {
			player.setY(player.getY()-1);
		}
		if (arg0.getExtendedKeyCode() == 65 && player.getX() > 0) {
			player.setX(player.getX()-1);
		}
		if (arg0.getExtendedKeyCode() == 83 && player.getY() <= grid.getHeight()-2) {
			player.setY(player.getY()+1);
		}
		if (arg0.getExtendedKeyCode() == 68 && player.getX() <= grid.getLength()-2) {
			player.setX(player.getX()+1);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	Timer t;
    
    public Main() {
    	
    	//generate cars
    	boolean randir;
    	for (int a = 0; a < grid.getHeight();a++) {
    		randir = randomBool();
    		for (int i = 0; i < grid.getLength();i++) {
    			if (grid.getValue(i, a) == 3) {
    				if ((int)(Math.random()*10) > 5) {
    					cars[i][a] = new Car(i,a,randir,1,grid);
    				}
    			}
    		}
    	}
    	//generate logs
    	for (int a = 0; a < grid.getHeight();a++) {
    		randir = randomBool();
    		for (int i = 0; i < grid.getLength();i++) {
    			if (grid.getValue(i, a) == 8) {
    				if ((int)(Math.random()*10) > 5) {
    					logs[i][a] = new Log(i,a,randir,1,grid);
    				}
    			}
    		}
    	}
    	
        JFrame f = new JFrame("Le Froge");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1680,934);
        f.add(this);
        f.addKeyListener(this);
        f.setResizable(false);
        
        t = new Timer(60, this);
        t.start();
        f.setVisible(true);
        
       
        
    }
    
    private void update() {
    	player.update(grid, null, score);
    }
    
    private void regenerate(Grid g, Street s, Water w, Grass gr) {
    	for (int i = 0; i < g.getLength();i++) {
			for (int a = 0; a < g.getHeight();a++) {
				g.setValue(i,a,1);
			}
		}
    	System.out.println(g.toString());
    	gr.generateGrass(g);
    	w.regenerateWater(g);
    	s.regenerateStreet(g);
    	player.setY(13);
    	//Clear cars & logs
    	for (int a = 0; a < grid.getHeight();a++) {
    		for (int i = 0; i < grid.getLength();i++) {
    			cars[i][a] = null;
    		}
    	}
    	for (int a = 0; a < grid.getHeight();a++) {
    		for (int i = 0; i < grid.getLength();i++) {
    			logs[i][a] = null;
    		}
    	}
    	
    	
    	//generate cars
    	boolean randir;
    	for (int a = 0; a < grid.getHeight();a++) {
    		randir = randomBool();
    		for (int i = 0; i < grid.getLength();i++) {
    			if (grid.getValue(i, a) == 3) {
    				if ((int)(Math.random()*10) > 5) {
    					cars[i][a] = new Car(i,a,randir,1,grid);
    				}
    			}
    		}
    	}
    	//generate logs
    	for (int a = 0; a < grid.getHeight();a++) {
    		randir = randomBool();
    		for (int i = 0; i < grid.getLength();i++) {
    			if (grid.getValue(i, a) == 8) {
    				if ((int)(Math.random()*10) > 5) {
    					logs[i][a] = new Log(i,a,randir,1,grid);
    				}
    			}
    		}
    	}
    }
    
    private boolean randomBool() {
    	int ran = (int)(Math.random()*2);
    	if (ran == 0) {
    		return true;
    	} else {
    		return false;
    	}
    }

}
