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
				int i = 0;
				for (Socket socket : sockets) {	
					System.out.println (message + " " + i);
					OutputStream out = socket.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					writer.println(message);
					writer.flush();	
					System.out.println ("i flushed!");
					i++;
				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	}
}
