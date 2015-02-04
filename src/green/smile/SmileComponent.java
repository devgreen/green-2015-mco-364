package green.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		
		g.drawOval(100, 50, 500, 500);
		g.setColor(Color.GREEN);
		g.fillOval(250, 100, 50, 200);
		g.fillOval(400, 100, 50, 200);
		g.drawArc(200, 350, 300, 150, 0, -180);

	}

}
