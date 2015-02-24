package green.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javax.swing.JComponent;

public class SnakeBody {

	private Deque<SnakePiece> snake;
	private Set<SnakePiece> set = new HashSet<SnakePiece>();
	private int lastDirection = 40;

	public SnakeBody() {

		snake = new ArrayDeque<SnakePiece>();
		//this.snake = snake;
		SnakePiece p = new SnakePiece(20, 20, 10);
		snake.addFirst(p);
		set.add(p);
		this.addPiece();
		this.addPiece();

	}

	public void addPiece() {
		SnakePiece last = snake.getLast();
		SnakePiece p = new SnakePiece(last.getX(), last.getY() + 10, last.getPieceSize());
		snake.addLast(p);
		set.add(p);
	}

	public void paint(Graphics g) {

		Iterator<SnakePiece> piece = snake.iterator();
		while (piece.hasNext()) {

			SnakePiece p = piece.next();
			if (p.equals(snake.getLast())) {
				g.setColor(Color.GREEN);
				g.fillRect(p.getX(), p.getY(), 10, 10);
				// if (p.getX() == food.getX() && p.getY() == food.getY()){
				// Random random = new Random();
				// int x = random.nextInt(75) * 10;
				// int y = random.nextInt(53) * 10;
				// food = new Food(x, y, 10);
				//
				//
				// }
			} else {
				g.setColor(Color.BLACK);
				g.fillRect(p.getX(), p.getY(), 10, 10);
			}
		}
	}

	public void moveSnake(KeyEvent e, Food f, SnakeScreen2 screen) {
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
			if (set.contains(newPiece)) {
				screen.setEnabled(false);
				break;
			}
			//SnakePiece toRemove = snake.removeFirst();
			//set.remove(toRemove);
			snake.removeFirst();
			snake.addLast(newPiece);
			//set.add(newPiece);

			if (snake.getLast().getX() == f.getX() && snake.getLast().getY() == f.getY()) {
				SnakePiece add = new SnakePiece(first.getX() - 10, first.getY(), first.getPieceSize());
				snake.addFirst(add);
				set.add(add);
				first = snake.getFirst();
				// add = new SnakePiece(first.getX() - 10, first.getY(),
				// first.getPieceSize());
				// snake.addFirst(add);

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
			if (set.contains(newPiece)) {
				screen.setEnabled(false);
				break;
			}
			//toRemove = snake.removeFirst();
			//set.remove(toRemove);
			snake.removeFirst();
			snake.addLast(newPiece);
			//set.add(newPiece);

			if (snake.getLast().getX() == f.getX() && snake.getLast().getY() == f.getY()) {
				SnakePiece add = new SnakePiece(first.getX() - 10, first.getY(), first.getPieceSize());
				snake.addFirst(add);
				first = snake.getFirst();
				set.add(add);
				// add = new SnakePiece(first.getX() - 10, first.getY(),
				// first.getPieceSize());
				// snake.addFirst(add);

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
			if (set.contains(newPiece)) {
				screen.setEnabled(false);
				break;
			}
			//toRemove = snake.removeFirst();
			//set.remove(toRemove);
			snake.removeFirst();
			snake.addLast(newPiece);
			//set.add(newPiece);

			if (snake.getLast().getX() == f.getX() && snake.getLast().getY() == f.getY()) {
				SnakePiece add = new SnakePiece(first.getX() - 10, first.getY(), first.getPieceSize());
				snake.addFirst(add);
				first = snake.getFirst();
				set.add(add);
				// add = new SnakePiece(first.getX() - 10, first.getY(),
				// first.getPieceSize());
				// snake.addFirst(add);

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
			if (set.contains(newPiece)) {
				screen.setEnabled(false);
				break;
			}
			//toRemove = snake.removeFirst();
			//set.remove(toRemove);
			snake.removeFirst();
			snake.addLast(newPiece);
			//set.add(newPiece);

			if (snake.getLast().getX() == f.getX() && snake.getLast().getY() == f.getY()) {
				SnakePiece add = new SnakePiece(first.getX() - 10, first.getY(), first.getPieceSize());
				snake.addFirst(add);
				first = snake.getFirst();
				set.add(add);
				// add = new SnakePiece(first.getX() - 10, first.getY(),
				// first.getPieceSize());
				// snake.addFirst(add);

			}
			lastDirection = 40;
			break;
		}
	}
	
	public SnakePiece getHead(){
		return snake.peekLast();
	}

	public Iterator<SnakePiece> iterator() {
		return snake.iterator();
	}

}
