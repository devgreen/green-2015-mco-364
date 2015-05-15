package green.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawListener implements MouseListener, MouseMotionListener {

	private Canvas canvas;
	private int prevX;
	private int prevY;

	public DrawListener(Canvas canvas) {
		this.canvas = canvas;

	}

	@Override
	public void mouseClicked(MouseEvent event) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();

		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(Color.BLACK);
		graphics.drawLine(x, y, x, y);
		prevX = x;
		prevY = y;
		canvas.repaint();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void mouseDragged(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();

		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(Color.BLACK);
		graphics.drawLine(prevX, prevY, x, y);

		prevX = x;
		prevY = y;
		canvas.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

}
