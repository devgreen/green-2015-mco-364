package green.multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReaderThread extends Thread {

	private Socket socket;
	private ReaderListener listener;

	public ReaderThread(Socket socket, ReaderListener listener) {
		this.socket = socket;
		this.listener = listener;

	}

	@Override
	public void run() {
		InputStream in;
		try {
			in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line + " reader thread");
				listener.onLineRead(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
