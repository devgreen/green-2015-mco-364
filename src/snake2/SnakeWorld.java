package snake2;

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
		int x1 = random.nextInt(65)+10;
		int y1 = random.nextInt(43)+10;
		int x2 = x1 *10;
		int y2 = y1* 10;
		food = new Food(x2, y2, 10);
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
					int x = random.nextInt(75) * 10;
					int y = random.nextInt(53) * 10;
					food = new Food(x, y, 10);

				}
			}
			g.fillRect(p.getX(), p.getY(), 10, 10);
			System.out.println(p.getX() + " " + p.getY() + " " + p.getPieceSize());

		}

		g.setColor(Color.RED);
		g.fillRect(food.getX(), food.getY(), 10, 10);

	}
	/*
	 * @Override protected void paintComponent(Graphics g) {
	 * super.paintComponent(g);
	 * 
	 * g.drawRect(10, 10, 760, 540);
	 * 
	 * Iterator<SnakePiece> piece = snake.iterator(); while (piece.hasNext()) {
	 * 
	 * SnakePiece p = piece.next(); if (p.equals(snake.getLast())) {
	 * g.setColor(Color.GREEN); g.fillRect(p.getX(), p.getY(), 10, 10); if
	 * (p.getX() == food.getX() && p.getY() == food.getY()){ Random random = new
	 * Random(); int x = random.nextInt(75) * 10; int y = random.nextInt(53) *
	 * 10; food = new Food(x, y, 10);
	 * 
	 * 
	 * } } g.fillRect(p.getX(), p.getY(), 10, 10); System.out.println(p.getX() +
	 * " " + p.getY() + " " + p.getPieceSize());
	 * 
	 * }
	 * 
	 * 
	 * 
	 * g.setColor(Color.RED); g.fillRect(food.getX(), food.getY(), 10, 10);
	 * 
	 * }
	 */

}
