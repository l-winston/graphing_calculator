package src;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class grapher {

	static JFrame frame = new JFrame("graph");
	static BufferedImage image = new BufferedImage(750, 750, BufferedImage.TYPE_INT_RGB);
	static final double HORIZONTAL_STRETCH = 50;
	static final double VERTICAL_STRETCH = 100;

	static final int TICK_MARK_LENGTH = 5;

	public static void main(String[] args) {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.getContentPane().add(new JLabel(new ImageIcon(image)));

		setWhite();
		drawAxes();

		for (double x = image.getWidth() / -2.0; x < image.getWidth() / 2.0; x += 0.01) {
			double y = function(x / HORIZONTAL_STRETCH) * VERTICAL_STRETCH;
			if (y < image.getHeight() / 2.0 && y >= image.getHeight() / -2.0) {

				Point p = new Point(x, y).toImageCoordinates();
				paintPoint(p.x, p.y);
				//System.out.println(x + " " + y);
				try {
					paintPoint(p.x - 1, p.y);
					paintPoint(p.x + 1, p.y);
					paintPoint(p.x, p.y - 1);
					paintPoint(p.x, p.y);
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}

		frame.repaint();
		frame.pack();
	}

	public static void paintPoint(double x, double y) {
		try {
			image.setRGB((int) Math.round(x), (int) Math.round(y), new Color(0, 0, 0).getRGB());
		} catch (ArrayIndexOutOfBoundsException e) {
		}
	}

	public static void drawAxes() {
		for (double i = 0; i < image.getWidth(); i += 0.1) {
			paintPoint(i, image.getHeight() / 2);
		}
		for (double j = 0; j < image.getHeight(); j += 0.1) {
			paintPoint(image.getWidth() / 2, j);
		}
		drawTickMarks();
	}

	public static void drawTickMarks() {
		for (double i = image.getWidth()/2; i < image.getWidth(); i += HORIZONTAL_STRETCH) {
			for (int j = image.getHeight() / 2 - TICK_MARK_LENGTH; j < image.getHeight() / 2 + TICK_MARK_LENGTH; j++) {
				paintPoint(i, j);
			}
		}
		for (double i = image.getWidth()/2; i >= 0; i -= HORIZONTAL_STRETCH) {
			for (int j = image.getHeight() / 2 - TICK_MARK_LENGTH; j < image.getHeight() / 2 + TICK_MARK_LENGTH; j++) {
				paintPoint(i, j);
			}
		}
		
		
		for (double i = image.getHeight()/2; i < image.getHeight(); i += VERTICAL_STRETCH) {
			for (int j = image.getWidth() / 2 - TICK_MARK_LENGTH; j < image.getWidth() / 2 + TICK_MARK_LENGTH; j++) {
				paintPoint(j, i);
			}
		}
		for (double i = image.getHeight()/2; i >= 0; i -= VERTICAL_STRETCH) {
			for (int j = image.getWidth() / 2 - TICK_MARK_LENGTH; j < image.getWidth() / 2 + TICK_MARK_LENGTH; j++) {
				paintPoint(j, i);
			}
		}
	}

	public static void setWhite() {
		for (int i = 0; i < image.getHeight(); i++) {
			for (int j = 0; j < image.getWidth(); j++) {
				image.setRGB(i, j, new Color(255, 255, 255).getRGB());
			}
		}
	}

	public static double function(double x) {

		return 1 / (1 + Math.pow(Math.E, -x));
	}

	public static void drawLine(Point a, Point b) {

	}
}
