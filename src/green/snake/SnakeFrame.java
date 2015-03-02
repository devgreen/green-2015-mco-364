package green.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame implements KeyListener {

	private SnakeWorld screen = new SnakeWorld();
	private SnakeWorldComponent world; 

	public SnakeFrame() {

		setSize(800, 600);
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		world= new SnakeWorldComponent(screen);
		world.addKeyListener(this);
		world.setFocusable(true);
		contentPane.add(world);
		new GameThread(world).start();

	}
	
	public SnakeWorldComponent getSnakeWorldComponent(){
		return world;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyPressed = e.getKeyCode();
		String direction = "";
		switch(keyPressed){
		case 37:
			direction = "left";
			screen.getBody().moveSnake(direction, screen.getFood());
			break;
		case 38:
			direction = "up";
			screen.getBody().moveSnake(direction, screen.getFood());
			break;
		case 39:
			direction = "right";
			screen.getBody().moveSnake(direction, screen.getFood());
			break;
		case 40:
			direction = "down";
			screen.getBody().moveSnake(direction, screen.getFood());
			break;
		
		}
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
		SnakeFrame frame = new SnakeFrame();
		frame.setVisible(true);
		
	}

}
