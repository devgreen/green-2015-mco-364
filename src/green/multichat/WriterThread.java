package green.multichat;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class WriterThread extends Thread {

	private LinkedBlockingQueue<String> messages;
	private List<Socket> sockets;

	public WriterThread(Server server) {
		messages = server.getMessages();
		sockets = server.getSockets();

	}

	@Override
	public void run() {
		while (true) {

			String message;
			try {
				message = messages.take();
				for (Socket socket : sockets) {
					OutputStream out = socket.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					writer.println(message);
					writer.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	}
}
