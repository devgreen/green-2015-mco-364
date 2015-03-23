package green.network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuiForServer extends JFrame {

	private JTextField text;
	private JButton submit;
	private JTextArea area;
	private ServerForGui server;

	public GuiForServer() throws IOException {

		setSize(800, 600);
		setTitle("Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		area = new JTextArea();
		container.add(area, BorderLayout.CENTER);
		text = new JTextField("enter comment here");
		Container south = new Container();
		south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));

		south.add(text);
		setVisible(true);

		submit = new JButton("submit");
		submit.addActionListener(submitText);
		south.add(submit);
		container.add(south, BorderLayout.SOUTH);
		server = new ServerForGui(area);

	}

	ActionListener submitText = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			area.append(text.getText() + "\n");
			PrintWriter writer = server.getSocketThread().getOut();
			writer.println(text.getText() + "\n");
			writer.flush();
			text.setText("");

		}
	};

	public static void main(String[] args) {

		GuiForServer frame;
		try {
			frame = new GuiForServer();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
