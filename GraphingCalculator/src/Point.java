package src;

public class Point {
	public static double x;
	public static double y;
	public Point (double x, double y){
		this.x = x;
		this.y = y;
	}
	public static Point toImageCoordinates(){
		return new Point(x + grapher.image.getWidth() / 2.0, grapher.image.getHeight() / 2.0 - 1 - y);
	}
	public static Point toCartesianCoordinates(){
		return new Point(x - grapher.image.getWidth() / 2.0, grapher.image.getHeight() / 2.0 - 1 - y);
	}
}
