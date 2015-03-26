package green.network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.io.IOUtils;

public class Client {

	public static void main(String[] args) {

		Socket socket = null;
		try {
			socket = new Socket("192.168.1.4", 3763);
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			writer.println("Do or do not, there is no try");
			writer.flush();
			Thread.sleep(10 * 1000);
			writer.println("My name is Jeff");
			writer.flush();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(socket);// can be done instead of
			/*try {
				if (socket != null){
				socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		}
	}
}
