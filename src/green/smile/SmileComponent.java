package green.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	boolean wink = false;
	boolean half = false;

	@Override
	protected void paintComponent(Graphics g) {

		int w = getWidth();
		int h = getHeight();

		super.paintComponent(g);
		// g.drawOval(x, y, width, height);
		g.drawOval((int) (w * .1), (int) (h * .1), (int) (w * .8), (int) (h * .8));
		g.setColor(Color.WHITE);
		// g.fillOval(x, y, width, height);
		g.fillOval((int) (w * .2), (int) (h * .2), (int) (w * .2), (int) (h * .3));
		g.setColor(Color.GREEN);
		g.fillOval((int) (w * .23), (int) (h * .25), (int) (w * .14), (int) (h * .2));
		g.setColor(Color.BLACK);
		g.drawOval((int) (w * .2), (int) (h * .2), (int) (w * .2), (int) (h * .3));
		g.fillOval((int) (w * .25), (int) (h * .299), (int) (w * .1), (int) (h * .1));

		if (!wink && !half) {
			/*
			 * g.setColor(Color.WHITE); g.fillOval(400, 150, 100, 100);
			 * 
			 * g.setColor(Color.GREEN); g.fillOval(415, 165, 70, 70);
			 * g.setColor(Color.BLACK); g.drawOval(400, 150, 100, 100);
			 * g.fillOval(435, 185, 30, 30);
			 */

			g.setColor(Color.WHITE);
			// g.fillOval(x, y, width, height);
			g.fillOval((int) (w * .6), (int) (h * .2), (int) (w * .2), (int) (h * .3));
			g.setColor(Color.GREEN);
			g.fillOval((int) (w * .63), (int) (h * .25), (int) (w * .14), (int) (h * .2));
			g.setColor(Color.BLACK);
			g.drawOval((int) (w * .6), (int) (h * .2), (int) (w * .2), (int) (h * .3));
			g.fillOval((int) (w * .65), (int) (h * .299), (int) (w * .1), (int) (h * .1));

			wink = true;
			half = true;

		} else if (half) {
			/*
			 * g.setColor(Color.WHITE); g.fillArc(400, 130, 90, 120, 0, -180);
			 * g.setColor(Color.GREEN); g.fillArc(410, 150, 70, 90, 0, -180);
			 * g.setColor(Color.BLACK); g.fillArc(420, 160, 50, 70, 0, -180);
			 */
			g.setColor(Color.WHITE);
			// g.fillArc(x, y, width, height, startAngle, arcAngle);
			g.fillArc((int) (w * .6), (int) (h * .3), (int) (w * .2), (int) (h * .2), 0, -180);
			g.setColor(Color.BLACK);
			g.drawArc((int) (w * .6), (int) (h * .3), (int) (w * .2), (int) (h * .2), 0, -180);
			g.setColor(Color.GREEN);
			g.fillArc((int) (w * .63), (int) (h * .29), (int) (w * .15), (int) (h * .2), 0, -180);
			g.setColor(Color.BLACK);
			g.fillArc((int) (w * .64), (int) (h * .32), (int) (w * .12), (int) (h * .15), 0, -180);

			half = false;

		} else {

			// g.drawLine(400, 200, 475, 200);
			// g.drawLine(x1, y1, x2, y2);
			g.drawLine((int) (w * .6), (int) (h * .4), (int) (w * .78), (int) (h * .4));
			wink = false;

		}

		if (wink) {
			g.setColor(Color.RED);
			// g.drawArc(200, 350, 300, 150, 0, -180);
			g.drawArc((int) (w * .2), (int) (h * .5), (int) (w * .6), (int) (h * .3), 0, -180);

		} else {
			g.setColor(Color.RED);
			// g.fillArc(330, 440, 50, 95, 0, -180);
			g.fillArc((int) (w * .45), (int) (h * .6), (int) (w * .1), (int) (h * .3), 0, -180);

		}

	}

}
