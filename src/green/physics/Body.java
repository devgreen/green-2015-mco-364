package green.physics;

import java.awt.geom.Point2D;

public class Body {

	private Point2D.Double position;
	private Force force;

	public Body(Force force) {
		this.force = force;
		position = new Point2D.Double();

	}

	public Body() {
		position = new Point2D.Double();

	}

	public Point2D.Double getPosition() {
		return position;
	}

	public void setPosition(Point2D.Double position) {
		this.position = position;
	}

	public Force getForce() {
		return force;
	}

	public void setForce(Force force) {
		this.force = force;
	}

	public void update() {
		position.x += force.getX();
		position.y += force.getY();

	}

}
