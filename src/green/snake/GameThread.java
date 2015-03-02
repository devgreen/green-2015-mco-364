package green.snake;

public class GameThread extends Thread {

	private SnakeWorldComponent world;

	public GameThread(SnakeWorldComponent world) {
		this.world = world;
	}

	public void run() {

		boolean game = world.getWorld().getBody().isStatus();
		while (game) {
			String direction = world.getWorld().getBody().getLastDirection();
			world.getWorld().getBody().moveSnake(direction, world.getWorld().getFood());
			world.repaint();
			game = world.getWorld().getBody().isStatus();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}


}
