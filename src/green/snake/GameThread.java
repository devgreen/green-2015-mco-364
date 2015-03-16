package green.snake;

public class GameThread extends Thread {

	private SnakeFrame frame;

	public GameThread(SnakeFrame frame) {
		this.frame = frame;
	}

	@Override
	public void run() {

		SnakeWorldComponent component = frame.getSnakeWorldComponent();
		SnakeWorld world = component.getWorld();
		SnakeBody body = world.getBody();

		boolean game = body.isStatus();
		while (game) {
			// String direction =

			component.repaint();
			game = body.isStatus();
			body.moveSnake(frame.getKeyPressed(), world.getFood());

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
