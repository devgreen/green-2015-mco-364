package green.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import javax.swing.JComponent;

public class SnakeScreen extends JComponent {

	private Deque<SnakePiece> snake;
	private Food food;
	private int lastDirection = 40;
	

	public Food getFood() {
		return food;
	}

	public SnakeScreen(/*Deque<SnakePiece> snake*/) {
		//this.snake = snake;
		snake = new ArrayDeque<SnakePiece>();
		SnakePiece p = new SnakePiece(20, 20, 10);
		snake.addFirst(p);
		this.addPiece();
		this.addPiece();
		

		//System.out.println(p.getX() + " " + p.getY() + " " + p.getPieceSize());
		Random random = new Random();
		int x = random.nextInt(75) * 10;
		int y = random.nextInt(53) * 10;
		food = new Food(x, y, 10);
		//System.out.println(food.getX() + " " + food.getY() + " " + food.getFoodSize());

	}
	
	public void addPiece() {
	SnakePiece last = snake.getLast();
	SnakePiece p = new SnakePiece(last.getX(), last.getY() + 10, last.getPieceSize());
	snake.addLast(p);
	//set.add(p);
}
	


	
	public void moveSnake(KeyEvent e, Snake s) {
		int key = e.getKeyCode();

		SnakePiece last;
		SnakePiece first;
		
		switch (key) {

		case 37:
			if (lastDirection == 39) {
				break;
			}
			last = snake.getLast();
			first = snake.getFirst();
			SnakePiece newPiece = new SnakePiece(last.getX() - 10, last.getY(), last.getPieceSize());
if (snake.contains(newPiece)){
	s.setEnabled(false);
	break;
	
}
			snake.removeFirst();
			snake.addLast(newPiece);

			if (snake.getLast().getX() == food.getX() && snake.getLast().getY() == food.getY()) {
				// SnakePiece add = new SnakePiece(first.getX() - 10,
				// first.getY(), first.getPieceSize());
				SnakePiece add = snake.getFirst();
				snake.addFirst(add);
				first = snake.getFirst();
				// add = new SnakePiece(first.getX() - 10, first.getY(),
				// first.getPieceSize());
				snake.addFirst(add);

			}
			lastDirection = 37;
			break;
		case 38:
			if (lastDirection == 40) {
				break;
			}
			last = snake.getLast();
			first = snake.getFirst();
			newPiece = new SnakePiece(last.getX(), last.getY() - 10, last.getPieceSize());
			if (snake.contains(newPiece)){
				s.setEnabled(false);
				break;
				
			}
			snake.removeFirst();
			snake.addLast(newPiece);

			if (snake.getLast().getX() == food.getX() && snake.getLast().getY() == food.getY()) {
				SnakePiece add = snake.getFirst();
				snake.addFirst(add);
				first = snake.getFirst();
				// add = new SnakePiece(first.getX() - 10, first.getY(),
				// first.getPieceSize());
				snake.addFirst(add);

			}
			lastDirection = 38;
			break;
		case 39:
			if (lastDirection == 37) {
				break;
			}
			last = snake.getLast();
			first = snake.getFirst();
			newPiece = new SnakePiece(last.getX() + 10, last.getY(), last.getPieceSize());
			if (snake.contains(newPiece)){
				s.setEnabled(false);
				break;
				
			}
			snake.removeFirst();
			snake.addLast(newPiece);
			if (snake.getLast().getX() == food.getX() && snake.getLast().getY() == food.getY()) {
				SnakePiece add = snake.getFirst();
				snake.addFirst(add);
				first = snake.getFirst();
				// add = new SnakePiece(first.getX() - 10, first.getY(),
				// first.getPieceSize());
				snake.addFirst(add);

			}
			lastDirection = 39;
			break;
		case 40:
			if (lastDirection == 38) {
				break;
			}
			last = snake.getLast();
			first = snake.getFirst();
			newPiece = new SnakePiece(last.getX(), last.getY() + 10, last.getPieceSize());
			if (snake.contains(newPiece)){
				s.setEnabled(false);
				break;
				
			}
			snake.removeFirst();
			snake.addLast(newPiece);
			if (snake.getLast().getX() == food.getX() && snake.getLast().getY() == food.getY()) {
				SnakePiece add = snake.getFirst();
				snake.addFirst(add);
				first = snake.getFirst();
				// add = new SnakePiece(first.getX() - 10, first.getY(),
				// first.getPieceSize());
				snake.addFirst(add);

			}
			lastDirection = 40;
			break;
		}
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
