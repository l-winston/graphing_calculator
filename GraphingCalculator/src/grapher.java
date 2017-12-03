package src;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class grapher {

	static JFrame frame = new JFrame("graph");
	static BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
	static final double HORIZONTAL_STRETCH = 5;
	static final double VERTICAL_STRETCH = 5;
	public static void main(String[] args) {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.getContentPane().add(new JLabel(new ImageIcon(image)));

		setWhite(image);

		for (double x = image.getWidth() / -2.0; x < image.getWidth() / 2.0; x+= 0.1) {
			double y = function(x/HORIZONTAL_STRETCH);
			if (y < image.getHeight() / 2.0 && y >= image.getHeight() / -2.0) {
				
				Point p = new Point(x*VERTICAL_STRETCH, y).toImageCoordinates();
				paintPoint(p.x, p.y);
				System.out.println(x + " " + y);
				try {
					paintPoint(p.x-1, p.y);
					paintPoint(p.x+1, p.y);
					paintPoint(p.x, p.y-1);
					paintPoint(p.x, p.y);
				} catch (ArrayIndexOutOfBoundsException e) {}
			}
		}

		frame.repaint();
		frame.pack();
	}
	
	public static void paintPoint(double x, double y){
		try{
			image.setRGB((int) Math.round(x), (int) Math.round(y), new Color(0, 0, 0).getRGB());
		} catch (ArrayIndexOutOfBoundsException e) {}
		}
	
	public static void setWhite(BufferedImage image) {
		for (int i = 0; i < image.getHeight(); i++) {
			for (int j = 0; j < image.getWidth(); j++) {
				image.setRGB(i, j, new Color(255, 255, 255).getRGB());
			}
		}
	}

	public static double function(double x) {

		return Math.pow(x, 3);
	}
	
	public static void drawLine(Point a, Point b){
		
	}
}
