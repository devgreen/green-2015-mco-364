package green.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;
import java.util.Deque;

import javax.swing.JFrame;

public class Snake extends JFrame implements KeyListener {

	private Deque<SnakePiece> snake = new ArrayDeque<SnakePiece>();
	private SnakeScreen screen;

	public Snake() {

		setSize(800, 600);
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		screen = new SnakeScreen(snake);
		contentPane.add(screen);
		screen.addKeyListener(this);
		screen.setFocusable(true);

		contentPane.add(screen);

		this.addPiece();
		this.addPiece();

	}

	public void addPiece() {
		SnakePiece last = snake.getLast();
		SnakePiece p = new SnakePiece(last.getX(), last.getY() + 10, last.getPieceSize());
		snake.add(p);
	}

	public static void main(String[] args) {
		final Snake frame = new Snake();
		frame.setVisible(true);

		Thread thread = new Thread() {
			public void run() {
				while (true) {
					frame.repaint();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		};

		thread.start();
	}

	public void moveSnake(KeyEvent e) {
		int key = e.getKeyCode();
		SnakePiece last;
		SnakePiece first;
		Food f = screen.getFood();
		switch (key) {

		case 37:
			last = snake.getLast();
			first = snake.getFirst();
			SnakePiece newPiece = new SnakePiece(last.getX() - 10, last.getY(), last.getPieceSize());
			snake.removeFirst();
			snake.addLast(newPiece);

			if (snake.getLast().getX() == f.getX() && snake.getLast().getY() == f.getY()) {
				SnakePiece add = new SnakePiece(first.getX() - 20, first.getY(), first.getPieceSize());
				snake.addFirst(add);

			}
			break;
		case 38:
			last = snake.getLast();
			first = snake.getFirst();
			newPiece = new SnakePiece(last.getX(), last.getY() - 10, last.getPieceSize());
			snake.removeFirst();
			snake.addLast(newPiece);

			if (snake.getLast().getX() == f.getX() && snake.getLast().getY() == f.getY()) {
				SnakePiece add = new SnakePiece(first.getX() - 20, first.getY(), first.getPieceSize());
				snake.addFirst(add);

			}
			break;
		case 39:
			last = snake.getLast();
			first = snake.getFirst();
			newPiece = new SnakePiece(last.getX() + 10, last.getY(), last.getPieceSize());
			snake.removeFirst();
			snake.addLast(newPiece);
			if (snake.getLast().getX() == f.getX() && snake.getLast().getY() == f.getY()) {
				SnakePiece add = new SnakePiece(first.getX() - 20, first.getY(), first.getPieceSize());
				snake.addFirst(add);

			}
			break;
		case 40:
			last = snake.getLast();
			first = snake.getFirst();
			newPiece = new SnakePiece(last.getX(), last.getY() + 10, last.getPieceSize());
			snake.removeFirst();
			snake.addLast(newPiece);
			if (snake.getLast().getX() == f.getX() && snake.getLast().getY() == f.getY()) {
				SnakePiece add = new SnakePiece(first.getX() - 20, first.getY(), first.getPieceSize());
				snake.addFirst(add);

			}
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println("pressed" + e.getKeyCode());
		moveSnake(e);

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
