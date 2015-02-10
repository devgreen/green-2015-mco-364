package green.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {
	
	
	boolean wink = false;
	boolean half = false;

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillOval(200, 150, 100, 100);
		g.setColor(Color.GREEN);
		g.fillOval(215, 165, 70, 70);
		g.setColor(Color.BLACK);
		g.drawOval(200, 150, 100, 100);
		g.fillOval(235, 185, 30, 30);

		if (!wink && !half) {
			g.setColor(Color.WHITE);
			g.fillOval(400, 150, 100, 100);
			g.setColor(Color.GREEN);
			g.fillOval(415, 165, 70, 70);
			g.setColor(Color.BLACK);
			g.drawOval(400, 150, 100, 100);
			g.fillOval(435, 185, 30, 30);
			wink = true;
			half = true;

		} else if (half) {
			g.setColor(Color.WHITE);
			g.fillArc(400, 130, 90, 120, 0, -180);
			g.setColor(Color.GREEN);
			g.fillArc(410, 150, 70, 90, 0, -180);
			g.setColor(Color.BLACK);
			g.fillArc(420, 160, 50, 70, 0, -180);
			half = false;

		} else {
			// g.drawLine(x1, y1, x2, y2);
			g.drawLine(400, 200, 475, 200);
			wink = false;

		}

		// start here
		g.drawOval(100, 50, 500, 500);

		if (wink) {
			g.setColor(Color.RED);
			g.drawArc(200, 350, 300, 150, 0, -180);

		} else {
			g.setColor(Color.RED);
			g.fillArc(330, 440, 50, 95, 0, -180);

		}

	}

	
	

}
