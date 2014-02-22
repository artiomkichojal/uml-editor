package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
//		 g.drawLine(0, 0, 100, 100);
//		 g.drawRect(10, 10, 100, 100);

		Graphics2D g2 = (Graphics2D) g;
		//g2.translate(100, 500);
		AffineTransform at = new AffineTransform();
	//	at.translate(600, 300);
		g2.setTransform(at);
//		g2.rotate(3.14, 1, 0);
//		g2.rotate(3.14, 0, 1);
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		System.out.println("h" + height);
		 double x = 0;
		 double y = 1;
		 double t = 3;
		 while(t <= 10) {
			
			g2.draw(new  Ellipse2D.Double(x, y,0,0));
			 //g.drawOval(x, y, 1, 1);
			 x = ((((t-3)/7) * ((t-3)/7) *((t-3)/7))*100 / 6);
			 y = 700 - (((10*(t-3)/7)) + 10);
			 System.out.println("x " + x);
			 System.out.println("y " + y);
			 t += 0.1;
			 
		 }
		 
		 
	}
	

}
