package green.multichat;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main {
	
	
	public static void main(String[] args) {

		try {
			Server server = new Server();
			
			for (int i = 0; i < 3; i++) {
				ClientFrame frame = new ClientFrame();
				frame.setVisible(true);
				/*ServerThread thread = new ServerThread(server.getServerSocket(), server.getSockets(),server.getMessages(), frame);
				thread.start();*/
				
			}
			server.run();

			System.out.println("started");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
