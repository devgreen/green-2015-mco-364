package green.snake;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JComponent;

public class SnakeBody {
	
	private Queue <JComponent> snakeBody;
	private Deque <SnakePiece> snake;
	
	
	public SnakeBody(){
		//snakeBody = new LinkedList<JComponent>();
		snake = new ArrayDeque<SnakePiece>();
		SnakePiece p = new SnakePiece(10, 10, 10);
		snake.add(p);
		
	}

}
