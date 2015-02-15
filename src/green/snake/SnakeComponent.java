package green.snake;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

public class SnakeComponent extends JComponent implements KeyListener{
	
	@Override
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(100, 100, 600, 400);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//4 or left then we turn left
		// 6 or right, we turn right
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
