package green.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class sc extends JComponent {
	
	
	boolean wink = false;
	
	@Override
	protected void paintComponent(Graphics g) {
		int w = getWidth();
		int h = getHeight();
		int centerX = w/2;
        int centerY = h/2;

		int circleRadius = w/3;
        int circleDiameter = circleRadius * 2;
        int left = centerX - circleRadius;
        int facePlace = centerY - circleRadius;
        System.out.println ("w = " + w);
        System.out.println ("h = " + h);
        System.out.println ("x = " + centerX);
        System.out.println ("y = " + centerY);
        System.out.println ("r = " + circleRadius);
        System.out.println ("d = " + circleDiameter);
        System.out.println ("left = " + left);
        System.out.println ("f = " + facePlace);

		super.paintComponent(g);
		// start here
		//g.drawOval(100, 50, 500, 500);
		g.drawOval(left, facePlace, circleDiameter, circleDiameter);
		g.setColor(Color.BLUE);
		//g.fillArc(x, y, width, height, startAngle, arcAngle);

		g.fillArc(250, 100, 50, 150, 0, -180);

		g.setColor(Color.BLACK);
		g.fillArc(250, 100, 50, 150, 0, 180);

		if (!wink) {
			g.setColor(Color.BLUE);
			g.fillArc(400, 100, 50, 150, 0, -180);
			g.setColor(Color.BLACK);
			g.fillArc(400, 100, 50, 150, 0, 180);
			wink = true;
		} else {
			g.setColor(Color.BLACK);
			g.fillArc(400, 100, 50, 150, 0, -180);
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
