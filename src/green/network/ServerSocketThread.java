package green.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerSocketThread extends Thread {

	private Socket socket;

	public ServerSocketThread(Socket socket) {
		this.socket = socket;

	}

	public void run() {

		InputStream in;
		try {
			in = socket.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
