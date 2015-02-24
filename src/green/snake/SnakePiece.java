package green.snake;

import java.util.Deque;
import java.util.Iterator;

public class SnakePiece {

	private int x;
	private int y;
	private int size;

	public SnakePiece(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}

	public boolean equals(Object other) {

		if (other instanceof SnakePiece) {
			if (this.x == ((SnakePiece) other).getX() && this.y == ((SnakePiece) other).getY()) {
				return true;
			}
		}

		return false;

	}

	public boolean contains(SnakePiece p, Deque<SnakePiece> snake) {
		Iterator<SnakePiece> iter = snake.iterator();
		while (iter.hasNext()) {
			if (iter.next().equals(p)) {
				return true;
			}
		}
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getPieceSize() {
		return size;
	}

}