package green.snake;

import java.awt.Graphics;

import javax.swing.JComponent;

public class SnakeWorldComponent extends JComponent {

	private SnakeWorld world;
	

	public SnakeWorld getWorld() {
		return world;
	}

	public SnakeWorldComponent(SnakeWorld world) {
		this.world = world;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(10, 10, 760, 540);
		
		try {
			world.draw(g);
			
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		if (!world.getBody().isStatus()) {
			g.drawString("Game Over!", 380, 270);
		}
		

	}

}
