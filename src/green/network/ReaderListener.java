package green.network;

import java.net.Socket;

public interface ReaderListener {

	void onLineRead();

	void onCLoseSocket(Socket socket);
	
	
	
	

}
