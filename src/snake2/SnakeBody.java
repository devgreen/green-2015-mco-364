package snake2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Random;

public class SnakeBody {

	private Deque<SnakePiece> snake;
	private int lastDirection = 40;

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

		switch (key) {

		case 37:
			if (lastDirection == 39) {
				break;
			}
			last = snake.getLast();
			first = snake.getFirst();
			SnakePiece newPiece = new SnakePiece(last.getX() - 10, last.getY(), last.getPieceSize());

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

			snake.removeFirst();
			snake.addLast(newPiece);
			if (snake.getLast().getX() == food.getX() && snake.getLast().getY() == food.getY()) {
				SnakePiece add = snake.getFirst();
				snake.addFirst(add);
				first = snake.getFirst();
				snake.addFirst(add);

			}
			lastDirection = 40;
			break;
		}
	}

	public Iterator<SnakePiece> iterator() {
		return snake.iterator();
	}

	public SnakePiece getLast() {
		return snake.getLast();
	}

}
