package green.multichat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

public class Client implements ReaderListener {

	private Socket socket;
	private JTextArea area;

	public Client(JTextArea area) throws UnknownHostException, IOException {
		socket = new Socket("localhost", 1112);
		this.area = area;

	}

	public Socket getSocket() {
		return socket;
	}

	@Override
	public void onLineRead(String string) {
		area.append(string + "\n");

	}

	@Override
	public void onCloseSocket(Socket socket) {
		// TODO Auto-generated method stub

	}

}
