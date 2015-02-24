package green.snake;

import java.awt.Graphics;
import java.util.Deque;
import java.util.Iterator;

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
	
	public boolean equals(SnakePiece piece){

		if(x==piece.getX() && y ==piece.getY()){

			return true;

		}

		else{

			return false;

		}

	}
	
	public boolean contains(SnakePiece p, Deque<SnakePiece>snake){
		Iterator<SnakePiece> iter = snake.iterator();
		while (iter.hasNext()){
			if (iter.next().equals(p)){
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
