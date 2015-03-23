package green.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(5955);
			while (true) {
				Socket socket = serverSocket.accept();
				if (socket != null) {
					ServerSocketThread thread = new ServerSocketThread(socket);
					thread.start();
				}

			}

			/*
			 * InputStream in = socket.getInputStream();
			 * 
			 * BufferedReader reader = new BufferedReader(new
			 * InputStreamReader(in)); String line; while ((line =
			 * reader.readLine()) != null) { System.out.println(line); } }
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
