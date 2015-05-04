package green.multichat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.BlockingQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField text;
	private JButton submit;
	private JTextArea area;
	private Client client;

	public ClientFrame() throws UnknownHostException, IOException {
		setSize(800, 600);
		setTitle("Client Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		area = new JTextArea();
		
		container.add(area, BorderLayout.CENTER);
		client = new Client(area);
		text = new JTextField("enter comment here");
		Container south = new Container();
		south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
		south.add(text);

		ActionListener submitText = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String message = text.getText();
					OutputStream out = client.getSocket().getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					writer.println(message);
					writer.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				text.setText("");

			}
		};

		submit = new JButton("submit");
		submit.addActionListener(submitText);
		south.add(submit);
		container.add(south, BorderLayout.SOUTH);

	}



}
