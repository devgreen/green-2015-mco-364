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
		int centerX = w / 2;
		int centerY = h / 2;

		int circleRadiusW = (int) (w * .45);
		int circleDiameterW = circleRadiusW * 2;
		int circleRadiusH = (int) (w * .45);
		int circleDiameterH = circleRadiusH * 2;
		int left = centerX - circleRadiusW;
		int facePlace;
		if (centerY - circleRadiusW > 0) {
			facePlace = centerY - circleRadiusW;
		} else {
			facePlace = circleRadiusW - centerY;
		}
		System.out.println("w = " + w);
		System.out.println("h = " + h);
		System.out.println("x = " + centerX);
		System.out.println("y = " + centerY);
		System.out.println("r = " + circleRadiusW);
		System.out.println("d = " + circleDiameterW);
		System.out.println("left = " + left);
		System.out.println("f = " + facePlace);
		// left = 100
		// faceplace = 50
		// circlediamtere = 500

		super.paintComponent(g);
		// g.drawOval(x, y, width, height);
		g.drawOval(left, facePlace, circleDiameterW, circleDiameterH);

		g.setColor(Color.WHITE);
		// g.fillOval(x, y, width, height);
		g.fillOval((int) (left * 2.5), (int) (facePlace / .5), circleDiameterW / 5, circleDiameterH / 5);
		g.setColor(Color.GREEN);
		g.fillOval((int) (left * 3.1), (int) (facePlace / .44), circleDiameterW / 7, circleDiameterH / 7);
		g.setColor(Color.BLACK);
		g.drawOval((int) (left * 2.5), (int) (facePlace / .5), circleDiameterW / 5, circleDiameterH / 5);
		g.fillOval((int)(left * 3.8), (int) (facePlace / .38), circleDiameterW / 15, circleDiameterH / 15);

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

			g.drawLine(400, 200, 475, 200);
			wink = false;

		}

		if (wink) {
			g.setColor(Color.RED);
			g.drawArc(200, 350, 300, 150, 0, -180);

		} else {
			g.setColor(Color.RED);
			g.fillArc(330, 440, 50, 95, 0, -180);

		}

	}

}
