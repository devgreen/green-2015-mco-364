package green.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Random;

public class SnakeWorld {

	SnakeBody body;

	Food food;

	public SnakeWorld() {

		this.body = new SnakeBody();
		Random random = new Random();
		int x = (random.nextInt(75) + 1) * 10;
		int y = (random.nextInt(53) + 1) * 10;
		food = new Food(x, y, 10);
		while (body.checkCollision(food)) {
			x = (random.nextInt(75) + 1) * 10;
			y = (random.nextInt(53) + 1) * 10;
			food = new Food(x, y, 10);
		}
	}

	public SnakeBody getBody() {
		return body;
	}

	public Food getFood() {
		return food;
	}

	public void draw(Graphics g) {

		Iterator<SnakePiece> piece = body.iterator();
		while (piece.hasNext()) {

			SnakePiece p = piece.next();
			if (p.equals(body.getLast())) {
				g.setColor(Color.GREEN);
				g.fillRect(p.getX(), p.getY(), 10, 10);
				if (p.getX() == food.getX() && p.getY() == food.getY()) {
					Random random = new Random();
					int x = (random.nextInt(75) + 1) * 10;
					int y = (random.nextInt(53) + 1) * 10;
					food = new Food(x, y, 10);
					while (body.checkCollision(food)) {
						x = (random.nextInt(75) + 1) * 10;
						y = (random.nextInt(53) + 1) * 10;
						food = new Food(x, y, 10);
					}

				}
			}
			g.fillRect(p.getX(), p.getY(), 10, 10);
		}

		g.setColor(Color.RED);
		g.fillRect(food.getX(), food.getY(), 10, 10);

	}

}