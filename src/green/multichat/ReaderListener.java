package green.multichat;

import java.net.Socket;

public interface ReaderListener {

	void onLineRead(String string);

	void onCloseSocket(Socket socket);
	
	
	
	

}
