package green.snake;

import java.awt.Graphics;

import javax.swing.JComponent;

public class SnakePiece extends JComponent {

	private int x;
	private int y;
	private int size;

	public SnakePiece(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
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
