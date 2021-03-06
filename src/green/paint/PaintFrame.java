package green.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.text.html.StyleSheet;

public class PaintFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Canvas canvas;
	private DrawListener drawListener;
	private ModeButton pencil;
	private ModeButton rectangle;
	private JButton clear;
	//private BrushListener brushListener;

	public PaintFrame() {

		setSize(800, 600);
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		canvas = new Canvas(600, 600);
		add(canvas, BorderLayout.CENTER);
		//drawListener = new DrawListener(canvas);
		//canvas.addMouseListener(drawListener);
		//canvas.addMouseMotionListener(drawListener);
		// Color[] colors = { Color.BLACK, Color.RED, Color.ORANGE };

		String[] colors = { "BLACK", "RED", "ORANGE", "GREEN", "BLUE", "YELLOW", "PURPLE" };
		JComboBox<String> colorList = new JComboBox<String>(colors);
		colorList.setSelectedIndex(0);
		colorList.addActionListener(listener);
		Container north = new Container();
		north.setLayout(new BoxLayout(north, BoxLayout.X_AXIS));
		add(north, BorderLayout.NORTH);
		north.add(colorList);
		pencil = new ModeButton("pencil", new PencilListener(canvas));
		pencil.addActionListener(shapeListener);
		rectangle = new ModeButton("rectangle", new RectangleListener(canvas));
		rectangle.addActionListener(shapeListener);
		
		//rectangle.addActionListener(changeShape);
		north.add(pencil);
		north.add(rectangle);
		clear = new JButton("clear");
		clear.addActionListener(clearListener);
		north.add(clear);

	}

	ActionListener listener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox<Color> box = (JComboBox<Color>) e.getSource();
			// Color color = (Color) box.getSelectedItem();
			StyleSheet sheet = new StyleSheet();
			String selectedColor = (String) box.getSelectedItem();
			Color color = sheet.stringToColor(selectedColor);
			drawListener.setColor(color);

		}

	};
/*	ActionListener changeShape = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton shape = (JButton) e.getSource();

			if (shape.equals(pencil)) {
				drawListener.setNumber(1);
				// System.out.println (drawListener.getNumber());
			} else {
				drawListener.setNumber(2);
				// System.out.println (drawListener.getNumber());

			}
		}

	};*/
	ActionListener clearListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();

			if (button.equals(clear)) {
				canvas.getImage().getGraphics().fillRect(0, 0, 600, 600);
				canvas.repaint();
			}
		}

	};
	
	ActionListener shapeListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ModeButton button = (ModeButton) e.getSource();
			BrushListener brushListener = button.getListener();
			canvas.setBrushListener(brushListener);
			canvas.addMouseListener(brushListener);
			canvas.addMouseMotionListener(brushListener);

		}

	};

	public static void main(String[] args) {
		PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
	}

}
