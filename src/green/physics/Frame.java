package green.physics;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class Frame extends JFrame {

	Force force;
	Body body;
	Circle circle;

	public Frame() {
		setSize(800, 600);
		setTitle("Client Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		force = new Force(0, 0);
		body = new Body(force);
		circle = new Circle(body);
		container.add(circle);

	}

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);
		double force = -9.8;
		while (true) {
			frame.getBody().getForce().setY(force);
			force += force;
			frame.getBody().update();
			try {
				Thread.sleep(500000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			frame.repaint();
		}
	}

	public Force getForce() {
		return force;
	}

	public void setForce(Force force) {
		this.force = force;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}
}
