package green.paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PaintFrame extends JFrame {


	private static final long serialVersionUID = 1L;
	private Canvas canvas;

	public PaintFrame() {

		setSize(800, 600);
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		canvas = new Canvas(600, 600);
		add(canvas, BorderLayout.CENTER);
		DrawListener drawListener = new DrawListener(canvas);
		canvas.addMouseListener(drawListener);
		canvas.addMouseMotionListener(drawListener);

	}

	public static void main(String[] args) {
		PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
	}

}
