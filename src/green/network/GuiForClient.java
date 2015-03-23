package green.network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuiForClient extends JFrame {

	JTextField text;
	JButton submit;
	JTextArea area;
	private ClientForGui client;

	public GuiForClient() throws UnknownHostException, IOException {

		setSize(800, 600);
		setTitle("Client Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		area = new JTextArea();
		container.add(area, BorderLayout.CENTER);
		text = new JTextField("enter comment here");
		Container south = new Container();
		south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
		south.add(text);

		client = new ClientForGui(area);
		ActionListener submitText = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				area.append(text.getText() + "\n");
				PrintWriter writer = client.getSocketThread().getOut();
				writer.println(text.getText() + "\n");
				writer.flush();
				text.setText("");
			}
		};

		submit = new JButton("submit");
		submit.addActionListener(submitText);
		south.add(submit);
		container.add(south, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		try {
			GuiForClient frame = new GuiForClient();
			frame.setVisible(true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
