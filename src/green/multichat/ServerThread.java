package green.multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerThread extends Thread  implements ReaderListener{

	private ServerSocket serverSocket;
	private List<Socket> sockets;
	private ReaderListener listener;
	private LinkedBlockingQueue<String> messages;

	public ServerThread(ServerSocket serverSocket, List<Socket> sockets, LinkedBlockingQueue <String> messages, ReaderListener listener) {
		this.serverSocket = serverSocket;
		this.sockets = sockets;
		this.messages = messages;
		this.listener = listener;
	}

	@Override
	public void run() {

		while (true) {
			Socket socket;
			try {
				socket = serverSocket.accept();
				sockets.add(socket);
				ReaderThread thread = new ReaderThread(socket, listener);
				thread.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
			

		}

	}
	
	@Override
	public void onLineRead(String string) {
		System.out.println ("adding");
		messages.add(string);
		
	}

	@Override
	public void onCloseSocket(Socket socket) {
		
	}

}
