package green.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

public class ServerForGui {

	private ServerSocket serverSocket;
	private JTextArea area;
	private SocketThread thread;

	public ServerForGui(JTextArea area) throws IOException {
		serverSocket = new ServerSocket(1111);
		this.area = area;
		
			Socket socket = serverSocket.accept();
			if (socket != null) {
				thread = new SocketThread(socket, area);
				thread.start();
			
		}
	}

	public SocketThread getSocketThread() {
		return thread;
	}
}
