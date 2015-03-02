package green.snake;

public class GameThread extends Thread {

	private SnakeWorldComponent world;
	private SnakeFrame frame;
	

/*	public GameThread(SnakeWorldComponent world) {
		this.world = world;
	}*/
	
	public GameThread(SnakeFrame frame){
		this.frame = frame;
	}

	public void run() {

		boolean game = frame.getSnakeWorldComponent().getWorld().getBody().isStatus();
		while (game) {
			//String direction = 
			
			frame.getSnakeWorldComponent().repaint();
			game = frame.getSnakeWorldComponent().getWorld().getBody().isStatus();
			frame.getSnakeWorldComponent().getWorld().getBody().moveSnake(frame.getKeyPressed(),frame.getSnakeWorldComponent().getWorld().getFood());
				
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}


}
