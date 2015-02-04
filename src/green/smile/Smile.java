package green.smile;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class Smile extends JFrame {

	public Smile() {
		setSize(800, 600);
		setTitle("Smile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		contentPane.add(new SmileComponent());
	}

	public static void main(String[] args) {

		final Smile frame = new Smile();
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

}
