package green.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Snake extends JFrame implements KeyListener{

	public Snake (){
		
		setSize(800, 600);
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		SnakeComponent c = new SnakeComponent();
		contentPane.add(c);
		c.addKeyListener(this);
		c.setFocusable(true);
		
		contentPane.add(c);
		
		
		
		
		
	}
	
	public static void main (String [] args){
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
		System.out.println("pressed");
		
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
