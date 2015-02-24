package green.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;

public class Snake extends JFrame implements KeyListener {

	//private Deque<SnakePiece> snake = new ArrayDeque<SnakePiece>();
	private SnakeScreen screen;
	//private int lastDirection = 40;
	//private Set<SnakePiece> set = new HashSet<SnakePiece>();

	public Snake() {

		setSize(800, 600);
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		screen = new SnakeScreen(/*snake*/);
		contentPane.add(screen);
		screen.addKeyListener(this);
		screen.setFocusable(true);
		contentPane.add(screen);


	}



	public static void main(String[] args) {
		final Snake frame = new Snake();
		frame.setVisible(true);

		Thread thread = new Thread() {
			public void run() {
				while (true) {
					frame.repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		};

		thread.start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println("pressed" + e.getKeyCode());
		screen.moveSnake(e, this);

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
