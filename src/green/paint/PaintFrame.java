package green.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.text.html.StyleSheet;

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
		
		ActionListener listener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 JComboBox <String> box = (JComboBox <String>) e.getSource();
			     String color = (String)box.getSelectedItem();
			     StyleSheet sheet = new StyleSheet();
			     Color c = sheet.stringToColor(color);
			     drawListener.setColor(c);
				
			}
			
		};

		String[] colors = { "BLACK", "RED", "ORANGE", "GREEN", "BLUE", "YELLOW", "PURPLE" };
		JComboBox<String> colorList = new JComboBox<String>(colors);
		colorList.setSelectedIndex(0);
		colorList.addActionListener(listener);
		add(colorList, BorderLayout.NORTH);

	}

	public static void main(String[] args) {
		PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
	}

}
