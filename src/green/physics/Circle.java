package green.physics;

import java.awt.Graphics;

import javax.swing.JComponent;

public class Circle extends JComponent {

	private Body body;

	public Circle(Body body) {
		this.body = body;
	}

	@Override
	protected void paintComponent(Graphics g) {
		//g.translate(0, 800);
		g.drawRect((int)body.getPosition().x,(int) body.getPosition().y, 3, 3);
	}

}
