package green.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JComponent;

public class SnakeScreen2 extends JComponent {

	SnakeBody body;
	public SnakeBody getBody() {
		return body;
	}

	public Food getFood() {
		return food;
	}

	Food food;

	public SnakeScreen2() {

		body = new SnakeBody();
		Random random = new Random();
		int x = random.nextInt(75) * 10;
		int y = random.nextInt(53) * 10;
		food = new Food(x, y, 10);
		System.out.println ("new food " + food.getX() + " " +food.getY());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(10, 10, 760, 540);
		
//		Food foodB = newFood();
//		foodB.paint(g);
//		body.paint(g);
		
		

		g.drawRect(10, 10, 760, 540);

		Iterator<SnakePiece> piece = body.iterator();
		while (piece.hasNext()) {

			SnakePiece p = piece.next();
			if (p.equals(body.getHead())) {
				g.setColor(Color.GREEN);
				g.fillRect(p.getX(), p.getY(), 10, 10);
				if (p.getX() == food.getX() && p.getY() == food.getY()){
					System.out.println("made it in");
					Random random = new Random();
					int x = random.nextInt(75) * 10;
					int y = random.nextInt(53) * 10;
					this.food = new Food(x, y, 10);
					System.out.println ("new food " + food.getX() + " " +food.getY());
					
					
				}
			}
			g.fillRect(p.getX(), p.getY(), 10, 10);
			System.out.println(p.getX() + " " + p.getY() + " " + p.getPieceSize());
		}
		


		g.setColor(Color.RED);
		food.paint(g);
		//g.fillRect(food.getX(), food.getY(), 10, 10);


	}
	
	public Food newFood(){
		 if (body.getHead().getX() == food.getX() && body.getHead().getY() == food.getY()){
		 Random random = new Random();
		 int x = random.nextInt(75) * 10;
		 int y = random.nextInt(53) * 10;
		 Food newFood = new Food(x, y, 10);
		 return newFood;
		 }
		 else {
			 return food;
		 }
		
	}

}
