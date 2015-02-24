package green.snake;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Food extends JComponent{
	
	int x;
	int y;
	int size;

	public Food(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public void paint (Graphics g){
		
		g.setColor(Color.RED);
		g.fillRect(x, y, size, size);
		
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	public int getFoodSize() {
		return size;
	}

}
