package green.paint;

import java.awt.Graphics;

public class RectangleListener extends BrushListener{

	public RectangleListener(Canvas canvas) {
		super(canvas);
	}

	@Override
	public void draw(Graphics g) {
		//g.drawRect(startX, startY, endX-startX, endY - startY);
		int x = Math.min(mousePressed.x, mouseDragged.x);
		int y = Math.min(mousePressed.y, mouseDragged.y);
		int width = Math.abs(mousePressed.x - mouseDragged.x);
		int height = Math.abs(mousePressed.y - mouseDragged.y);
		int location = x+ width;
		if (location > 600){
			int over = location -600;
			width -=over;
		}
		location = y + height;
		if (location > 600){
			int over = location - 600;
			height -=over;
		}
		
		
		//g.setColor(color);
		g.drawRect(x, y, width, height);
		
	}

}
