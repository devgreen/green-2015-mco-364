package green.paint;

import javax.swing.JButton;

public class ModeButton extends JButton{
	
	private BrushListener listener;

	public ModeButton (String text,BrushListener listener){
		this.listener = listener;
		setText(text);
	}
	
	public BrushListener getListener() {
		return listener;
	}

}
