package snake2;

import java.awt.Graphics;

import javax.swing.JComponent;

public class SnakeWorldComponent extends JComponent{
	
	private SnakeWorld world;
	
	public SnakeWorldComponent(SnakeWorld world){
		this.world = world;
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawRect(10, 10, 760, 540);

		world.draw(g);

	}
	

}
