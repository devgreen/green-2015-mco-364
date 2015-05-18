package green.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private BufferedImage image;
	private Point mousePressed;
	private Point mouseDragged;

	public void setMousePressed(Point mousePressed) {
		this.mousePressed = mousePressed;
	}

	public void setMouseDragged(Point mouseDragged) {
		this.mouseDragged = mouseDragged;
	}

	public Canvas(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		image.getGraphics().setColor(Color.WHITE);
		image.getGraphics().fillRect(0, 0, width, height);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		
		if (mousePressed != null && mouseDragged != null){
			int x = Math.min(mousePressed.x, mouseDragged.x);
			int y = Math.min(mousePressed.y, mouseDragged.y);
			int width = Math.abs(mousePressed.x - mouseDragged.x);
			int height = Math.abs(mousePressed.y - mouseDragged.y);
			g.drawRect(x, y, width, height);
		}
		

			
		
		

	}

	public BufferedImage getImage() {
		return image;
	}

}
