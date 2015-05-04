package green.multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Server implements ReaderListener{

	private LinkedBlockingQueue<String> messages;
	private List<Socket> sockets;
	private WriterThread writer;
	private ServerSocket serverSocket;

	public Server() throws IOException {

		serverSocket = new ServerSocket(1112);
		sockets = new ArrayList<Socket>();
		messages = new LinkedBlockingQueue<String>();
		writer = new WriterThread(this);
		writer.start();

	}
	
	
	public void run (){
		while (true) {
			Socket socket;
			try {
				socket = serverSocket.accept();
				sockets.add(socket);
				ReaderThread thread = new ReaderThread(socket, this);
				thread.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
			

		}
	}
	
	@Override
	public void onLineRead(String string) {
		messages.add(string);
		
	}

	@Override
	public void onCloseSocket(Socket socket) {
		
	}


	public LinkedBlockingQueue<String> getMessages() {
		return messages;
	}

	public List<Socket> getSockets() {
		return sockets;
	}

	public WriterThread getWriter() {
		return writer;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}



}
