package snake2;

public class GameThread extends Thread {
	
	private SnakeWorldComponent world;

	public GameThread(SnakeWorldComponent world) {
		this.world = world;
	}
	
	
	public void run() {
		while (true) {
			world.repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
