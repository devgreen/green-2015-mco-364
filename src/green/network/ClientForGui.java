package green.network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

public class ClientForGui {

	private JTextArea area;
	private SocketThread thread;

	public ClientForGui(JTextArea area) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 1111);
		this.area = area;
		if (socket != null) {
			thread = new SocketThread(socket, area);
			thread.start();
		}
	}

	public SocketThread getSocketThread() {
		return thread;
	}
}
