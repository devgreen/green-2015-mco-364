package green.snake;

public class GameLoopThread extends Thread {

	private SnakeScreen2 screen;
	

	public GameLoopThread(SnakeScreen2 screen) {
		this.screen = screen;
	}

	public void run() {
		while (true) {
			screen.repaint();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
