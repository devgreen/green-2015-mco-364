package green.physics;

public class Main {

	public static void main(String[] args) {

		Force force = new Force(0, -9.8);
		Body body = new Body(force);
		body.update();
		System.out.println(body.getPosition().x + " " + body.getPosition().y);
		force.setY(-19.6);
		body.update();
		System.out.println(body.getPosition().x + " " + body.getPosition().y);

	}

}
