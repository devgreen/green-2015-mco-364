package green.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame implements KeyListener {

	private SnakeWorld screen;
	private SnakeWorldComponent world; 
	private int keyPressed;

	public int getKeyPressed() {
		return keyPressed;
	}

	public SnakeFrame() throws CloneNotSupportedException {
		screen =  new SnakeWorld();

		setSize(800, 600);
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		world= new SnakeWorldComponent(screen);
		world.addKeyListener(this);
		world.setFocusable(true);
		contentPane.add(world);
		new GameThread(this).start();

	}
	
	public SnakeWorldComponent getSnakeWorldComponent(){
		return world;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyPressed = e.getKeyCode();
		
			//direction = "left";
			//screen.getBody().callMove(keyPressed, screen.getFood());
		
		
		
	}

	public SnakeWorld getScreen() {
		return screen;
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		SnakeFrame frame;
		try {
			frame = new SnakeFrame();
			frame.setVisible(true);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
