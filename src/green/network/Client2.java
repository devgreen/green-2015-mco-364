package green.network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {

	
	public static void main(String[] args) {

		Socket socket = null;
		try {
			socket = new Socket("localhost", 3762);
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			writer.println("This is client 2");
			writer.flush();
			//Thread.sleep(10 * 1000);
			writer.println("Yay! I work!");
			writer.flush();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
