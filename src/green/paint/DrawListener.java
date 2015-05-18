package green.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawListener implements MouseListener, MouseMotionListener {

	private Canvas canvas;
	private int prevX;
	private int prevY;
	private Color color;
	private int number;
	private int endX;
	private int endY;
	private int draggedX;
	private int draggedY;
	private Point mousePressed;
	private Point mouseDragged;

	public DrawListener(Canvas canvas) {
		this.canvas = canvas;
		this.color = Color.BLACK;
		this.number = 1;
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
		mousePressed = event.getPoint();
		canvas.setMousePressed(mousePressed);
		int x = event.getX();
		int y = event.getY();

		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(color);
		graphics.drawLine(x, y, x, y);
		prevX = x;
		prevY = y;
		canvas.repaint();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(color);
		int x = Math.min(mousePressed.x, mouseDragged.x);
		int y = Math.min(mousePressed.y, mouseDragged.y);
		int width = Math.abs(mousePressed.x - mouseDragged.x);
		int height = Math.abs(mousePressed.y - mouseDragged.y);
		graphics.drawRect(x, y, width, height);
		canvas.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		mouseDragged = event.getPoint();
		canvas.setMouseDragged(mouseDragged);
		int x = event.getX();
		int y = event.getY();
		draggedX = event.getX();
		draggedY = event.getY();
		endX = x - prevX;
		endY = y - prevY;

		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(color);
		if (number == 1) {
			graphics.drawLine(prevX, prevY, x, y);

			prevX = x;
			prevY = y;
			canvas.repaint();
		}
		
		canvas.repaint();

	}

	public Point getMousePressed() {
		return mousePressed;
	}

	public Point getMouseDragged() {
		return mouseDragged;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
