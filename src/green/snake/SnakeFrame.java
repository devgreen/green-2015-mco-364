package green.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame implements KeyListener {

	private SnakeWorld screen = new SnakeWorld();

	public SnakeFrame() {

		setSize(800, 600);
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		SnakeWorldComponent world = new SnakeWorldComponent(screen);
		world.addKeyListener(this);
		world.setFocusable(true);
		contentPane.add(world);

		new GameThread(world).start();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		screen.getBody().moveSnake(e, screen.getFood());

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		SnakeFrame frame = new SnakeFrame();
		frame.setVisible(true);
	}

}
