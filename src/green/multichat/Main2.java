package green.multichat;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main2 {
	
	public static void main (String [] args){
	
	try {
		//Server server = new Server();
		for (int i = 0; i < 2; i++) {
			ClientFrame frame = new ClientFrame();
			frame.setVisible(true);
		}
		//server.run();

	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

}
}
