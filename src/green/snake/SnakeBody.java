package green.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Random;

public class SnakeBody {

	private Deque<SnakePiece> snake;
	private int lastDirection = 40;
	private boolean status = true;

	public boolean isStatus() {
		return status;
	}

	public SnakeBody() {

		snake = new ArrayDeque<SnakePiece>();
		SnakePiece p = new SnakePiece(20, 20, 10);
		snake.addFirst(p);
		this.addPiece();
		this.addPiece();

	}

	public void addPiece() {
		SnakePiece last = snake.getLast();
		SnakePiece p = new SnakePiece(last.getX(), last.getY() + 10, last.getPieceSize());
		snake.addLast(p);

	}

	public void moveSnake(KeyEvent e, Food food) {
		int key = e.getKeyCode();

		SnakePiece last;
		SnakePiece first;
		int lastX = snake.getLast().getX() + 10;
		int lastY = snake.getLast().getY() + 10;

		switch (key) {

		case 37:
			if (lastDirection == 39) {
				break;
			}
			last = snake.getLast();
			
			first = snake.getFirst();
			SnakePiece newPiece = new SnakePiece(last.getX() - 10, last.getY(), last.getPieceSize());
			if (snake.contains(newPiece)) {
				status = false;
				// gameover
			}
			snake.removeFirst();
			snake.addLast(newPiece);
			if (newPiece.getX() < 10 || newPiece.getX() > 760 || newPiece.getY() < 10 || newPiece.getY() > 540) {
				status = false;
				// game over
			}

		/*	if (snake.getLast().getX() == food.getX() && snake.getLast().getY() == food.getY()) {
				SnakePiece add = snake.getFirst();
				snake.addFirst(add);
				first = snake.getFirst();
				snake.addFirst(add);

			}*/
			
			if (lastX == food.getX() && lastY == food.getY()) {
				SnakePiece add = snake.getFirst();
				snake.addFirst(add);
				first = snake.getFirst();
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
			if (snake.contains(newPiece)) {
				status = false;
				// game over
			}

			snake.removeFirst();
			snake.addLast(newPiece);

			if (newPiece.getX() < 10 || newPiece.getX() > 760 || newPiece.getY() < 10 || newPiece.getY() > 540) {
				status = false;
				// game over
			}

			if (snake.getLast().getX() == food.getX() && snake.getLast().getY() == food.getY()) {
				SnakePiece add = snake.getFirst();
				snake.addFirst(add);
				first = snake.getFirst();
				snake.addFirst(add);

			}
			if (lastX == food.getX() && lastY == food.getY()) {
				SnakePiece add = snake.getFirst();
				snake.addFirst(add);
				first = snake.getFirst();
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
			if (snake.contains(newPiece)) {
				status = false;

				System.out.println("hit myslef");
			}

			snake.removeFirst();
			snake.addLast(newPiece);

			if (newPiece.getX() < 10 || newPiece.getX() > 760 || newPiece.getY() < 10 || newPiece.getY() > 540) {
				status = false;
				// game over
			}
			if (snake.getLast().getX() == food.getX() && snake.getLast().getY() == food.getY()) {
				SnakePiece add = snake.getFirst();
				snake.addFirst(add);
				first = snake.getFirst();
				snake.addFirst(add);

			}
			if (lastX == food.getX() && lastY == food.getY()) {
				SnakePiece add = snake.getFirst();
				snake.addFirst(add);
				first = snake.getFirst();
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
			if (snake.contains(newPiece)) {
				status = false;
			}

			snake.removeFirst();
			snake.addLast(newPiece);

			if (newPiece.getX() < 10 || newPiece.getX() > 760 || newPiece.getY() < 10 || newPiece.getY() > 540) {
				status = false;
				// game over
			}
			if (snake.getLast().getX() == food.getX() && snake.getLast().getY() == food.getY()) {
				SnakePiece add = snake.getFirst();
				snake.addFirst(add);
				first = snake.getFirst();
				snake.addFirst(add);

			}
			if (lastX == food.getX() && lastY == food.getY()) {
				SnakePiece add = snake.getFirst();
				snake.addFirst(add);
				first = snake.getFirst();
				snake.addFirst(add);

			}
			lastDirection = 40;
			break;
		}
	}

	public boolean checkCollision(Food f) {
		// boolean location;
		Iterator<SnakePiece> iter = snake.iterator();
		while (iter.hasNext()) {
			SnakePiece piece = iter.next();
			int a = piece.getX();
			int b = piece.getY();
			if (f.getX() >= (a +10) && f.getY() >= (b +10)) {
				return true;
			}
		}
		return false;
	}

	public Iterator<SnakePiece> iterator() {
		return snake.iterator();
	}

	public SnakePiece getLast() {
		return snake.getLast();
	}

}
