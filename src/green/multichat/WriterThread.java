package green.multichat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class WriterThread extends Thread {

	private LinkedBlockingQueue<String> messages;
	private List<Socket> sockets;

	public WriterThread(LinkedBlockingQueue<String> messages, List<Socket> sockets) {
		this.messages = messages;
		this.sockets = sockets;

	}

	@Override
	public void run() {
		while (true) {

			String message;

			try {
				message = messages.take();
				Iterator<Socket> iter = sockets.iterator();
				while (iter.hasNext()) {
					Socket socket = iter.next();
					try {
						OutputStream out = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(out);
						writer.println(message);
						writer.flush();
					} catch (IOException e) {
						e.printStackTrace();
						iter.remove();

					}

				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

		}
	}
}
