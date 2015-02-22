package green.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;
import java.util.Deque;

import javax.swing.JFrame;

public class Snake extends JFrame implements KeyListener {
	
	private Deque <SnakePiece>snake = new ArrayDeque<SnakePiece>();

	public Snake() {

		setSize(800, 600);
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		SnakeScreen screen = new SnakeScreen(snake);
		contentPane.add(screen);
		screen.addKeyListener(this);
		screen.setFocusable(true);

		contentPane.add(screen);
		
		this.addPiece();
		this.addPiece();

	}
	
	public void addPiece(){
		SnakePiece last = snake.getLast();
		SnakePiece p = new SnakePiece(last.getX()+10, last.getY()+10, last.getWidth()+10);
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
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		};

		thread.start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("pressed" + e.getKeyCode());
		SnakePiece head = snake.getFirst();
		SnakePiece newPiece = new SnakePiece(head.getX()-5, head.getY()-5, head.getWidth()+5);
		snake.addFirst(newPiece);

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
