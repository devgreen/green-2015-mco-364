package green.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JComponent;

public class SnakeScreen2 extends JComponent {

	SnakeBody body;
	Food food;

	public SnakeScreen2() {

		body = new SnakeBody();
		Random random = new Random();
		int x = (random.nextInt(75)+10) * 10;
		int y = (random.nextInt(53)+10) * 10;
		food = new Food(x, y, 10);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(10, 10, 760, 540);
		food.paint(g);
		body.paint(g);


	}

}
