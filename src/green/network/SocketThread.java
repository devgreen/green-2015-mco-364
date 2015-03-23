package green.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextArea;

public class SocketThread extends Thread {

	private Socket socket;
	private BufferedReader reader;
	private PrintWriter out;
	private JTextArea area;

	public SocketThread(Socket socket, JTextArea area) {
		this.socket = socket;
		this.area = area;
	}

	@Override
	public void run() {

		InputStream in;
		try {
			in = socket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			out = new PrintWriter(socket.getOutputStream(), true);
			String inputLine;
			while ((inputLine = reader.readLine()) != null) {
				area.append(inputLine);
				area.append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public PrintWriter getOut() {
		return out;
	}

}
