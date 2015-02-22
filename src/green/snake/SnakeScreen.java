package green.snake;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import javax.swing.JComponent;

public class SnakeScreen extends JComponent {
	
	private Deque <SnakePiece> snake; 
	
	public SnakeScreen (Deque<SnakePiece> snake){
		this.snake = snake;
		SnakePiece p = new SnakePiece(20, 20, 10);
		snake.addFirst(p);
		
	}
	
	@Override
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawRect(100, 100, 600, 400);
		g.drawRect(10, 10, 760, 540);
		//g.fillRect(100, 200, 10, 10);
		
		
			Iterator<SnakePiece> piece = snake.iterator();
			while (piece.hasNext()){
				SnakePiece p = piece.next();
				//g.fillRect(p.getX(), p.getY(), p.getWidth(), p.getHeight());
				g.fillRect(p.getX(), p.getY(),p.getPieceSize(),p.getPieceSize());
				//p.repaint();
				//p.repaint(p.getY(), p.getX(),p.getWidth(),p.getHeight());
				
			}
			
		
		
	}

	
	

}
