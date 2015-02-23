package green.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import javax.swing.JComponent;

public class SnakeScreen extends JComponent {

	private Deque<SnakePiece> snake;
	private Food food;
	private Set<SnakePiece> set = new HashSet<SnakePiece>();

	public Food getFood() {
		return food;
	}

	public SnakeScreen(Deque<SnakePiece> snake) {
		this.snake = snake;
		SnakePiece p = new SnakePiece(20, 20, 10);
		snake.addFirst(p);
		set.add(p);

		System.out.println(p.getX() + " " + p.getY() + " " + p.getPieceSize());
		Random random = new Random();
		int x = random.nextInt(75) * 10;
		int y = random.nextInt(53) * 10;
		food = new Food(x, y, 10);
		System.out.println(food.getX() + " " + food.getY() + " " + food.getFoodSize());

	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawRect(10, 10, 760, 540);

		Iterator<SnakePiece> piece = snake.iterator();
		while (piece.hasNext()) {

			SnakePiece p = piece.next();
			if (p.equals(snake.getLast())) {
				g.setColor(Color.GREEN);
				g.fillRect(p.getX(), p.getY(), 10, 10);
				if (p.getX() == food.getX() && p.getY() == food.getY()){
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

}
