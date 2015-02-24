package green.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame implements KeyListener {

	SnakeScreen2 screen;

	public SnakeFrame() {

		setSize(800, 600);
		setTitle("Snake2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		screen = new SnakeScreen2();
		screen.addKeyListener(this);
		screen.setFocusable(true);
		contentPane.add(screen);
		screen.addKeyListener(this);
		screen.setFocusable(true);

		new GameLoopThread(screen).start();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		SnakeBody body = screen.getBody();
		Food f = screen.getFood();
		body.moveSnake(e, f, screen);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
