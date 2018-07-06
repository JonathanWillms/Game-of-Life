package gameoflife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameOfLife extends JPanel{
  

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static final int SIZE = 5;
  private static final int OFFSET = 1;
  
  private JFrame frame;
  private World world;

	public static void main(String[] args) {
	    GameOfLife gol = new GameOfLife();
	    gol.init();
	}
	
	private void init() {
    initWorld();
    initView();
    startSimulation();
  }

  private void startSimulation() {
   while(true) {
     world.nextGeneration();
     this.repaint();
     try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   }
  }

  private void initWorld() {
	     world = new World(100, 100);
	        world.populate(33);
	}
	
	private void initView() {
      frame = new JFrame();
      frame.getContentPane().add(this);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
	  
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(world.getWorldWidth() * (SIZE + OFFSET), world.getWorldLength() * (SIZE + OFFSET));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        frame.setTitle(String.format("Generation %s", world.getGeneration()));
        
        for (int x = 0; x < world.getWorldWidth(); x++) {
            for (int y = 0; y < world.getWorldLength(); y++) {
                if (world.isCellLiving(x, y)) {
                    g.setColor(Color.green);
                }else {
                  g.setColor(Color.red);
                }
                g.fillRect(x * (SIZE + OFFSET), y * (SIZE + OFFSET), SIZE, SIZE);
            }
        }
    }

}
