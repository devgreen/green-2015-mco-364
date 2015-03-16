package green.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Random;

public class SnakeWorld {

	public final static Random RANDOM = new Random();

	SnakeBody body;
	SnakeBody clone;
	Food food;

	public SnakeWorld() throws CloneNotSupportedException {

		this.body = (SnakeBody) new SnakeBody();
		//this.clone = (SnakeBody) body.clone();

		int x = (RANDOM.nextInt(76) + 1) * 10;
		int y = (RANDOM.nextInt(53) + 1) * 10;
		food = new Food(x, y, 10);
		boolean loc = body.checkCollision(food);
		while (loc) {
			x = (RANDOM.nextInt(76) + 1) * 10;
			y = (RANDOM.nextInt(53) + 1) * 10;
			food = new Food(x, y, 10);
			loc = body.checkCollision(food);

		}
	}

	public SnakeBody getBody() {
		return body;
	}

	public Food getFood() {
		return food;
	}

	public void draw(Graphics g) throws CloneNotSupportedException {
		
		
		this.clone = (SnakeBody) body.clone();
		Iterator<SnakePiece> piece = clone.iterator();
		while (piece.hasNext()) {

			SnakePiece p = piece.next();
			if (p.equals(clone.getLast())) {
				System.out.println(p.getX() + " " + p.getY());
				System.out.println("food: " + food.getX() + " " + food.getY());
				g.setColor(Color.GREEN);
				g.fillRect(p.getX(), p.getY(), 10, 10);
				if (p.getX() == food.getX() && p.getY() == food.getY()) {
					int x = (RANDOM.nextInt(76) + 1) * 10;
					int y = (RANDOM.nextInt(53) + 1) * 10;
					food = new Food(x, y, 10);
					System.out.println("i created a new food cuz i was eaten");

					boolean place = clone.checkCollision(food);
					while (place) {
						x = (RANDOM.nextInt(76) + 1) * 10;
						y = (RANDOM.nextInt(53) + 1) * 10;
						food = new Food(x, y, 10);
						place = clone.checkCollision(food);
						System.out.println("created new food cuz i was on the snake");
					}

				}
			} else {
				g.fillRect(p.getX(), p.getY(), 10, 10);
			}
		}

		g.setColor(Color.RED);
		g.fillRect(food.getX(), food.getY(), 10, 10);

	}

}
