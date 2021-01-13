package lydia.games;
//vector graphics - drawing stuff with algorithms

import javax.swing.JPanel;
//import each class independent
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension; //a vector = 2 points on a grid(coordinates)
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;//blurred or straight
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Arc2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.Image;
import javax.swing.ImageIcon;


//import java.awt.geom.
public class Board extends JPanel { //this is a JPanel
	Image img;
	//String location = "src/res/image/yellowFlower.jpg";be sure to write in the file extension; png's most flexible
	String location = "src/res/image/sunrise.jpg";
	
	private void loadImage() {//method
		ImageIcon ii = new ImageIcon(location); //load
		img = ii.getImage(); //stores
	}
	private void initBoard() {//constructor/init
		loadImage();
		int w = img.getWidth(this);
		int h = img.getHeight(this);
		setPreferredSize(new Dimension(w, h));
		
	}
	
	
	@Override 
	public void paintComponent(Graphics g){ //pass in graphic object
	//	super.paintComponent(g);
	//	drawShape(g);
		g.drawImage(img,0,0,null);
	}
	private void drawShape(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //antialiasing: SMOOTHS IT OUT to look better
		rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2D.setRenderingHints(rh);
		
		
		Dimension size = getSize();
		double w = size.getWidth();
		double h = size.getHeight();
		
		Ellipse2D e = new Ellipse2D.Double(0,0,200,150);
		Rectangle2D r = new Rectangle2D.Double(-20,-20,50,150);
		Arc2D a = new Arc2D.Double(-40,-30,10,50,400,330,Arc2D.OPEN);
	//	RoundRectangle2D rr = new RoundRectangle2D.Double(150,150,200,200);
		
		g2D.setStroke(new BasicStroke(1));
		g2D.setColor(Color.PINK);
	//	AffineTransform at = AffineTransform.getTranslateInstance(w/2,h/2);
	//	AffineTransform at1 = AffineTransform.getTranslateInstance(w/2,h/2);
	//	AffineTransform at2 = AffineTransform.getTranslateInstance(w/2,h/2);
	//	AffineTransform at3 = AffineTransform.getTranslateInstance(w/2,h/2);
	//	g2D.draw(at.createTransformedShape(e));
//		g2D.draw(at.createTransformedShape(r));
//		g2D.draw(at.createTransformedShape(a));
		
		
		for(double deg = 0; deg<360; deg+=5) {
			AffineTransform at = AffineTransform.getTranslateInstance(w/2, h/2);
			at.rotate(Math.toRadians(deg));
			g2D.draw(at.createTransformedShape(e));
		}
		
	}
	
	public Board() {
		initBoard();
	}

}
