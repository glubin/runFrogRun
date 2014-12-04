package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Lilypads {
	private double positionX;	//constructor
	private double positionY;
	private double radius;
	private Color color;
	private boolean land;

	public Lilypads (double x, double y, double r, Color color, boolean land){
		this.positionX = x;		//initializes
		this.positionY = y;
		this.radius = r;
		this.color = color;
		this.land = land;
	}

	public void setIsLand(){
		this.land = true;
	}

	public void setColor(){
		this.color =  Color.CYAN;
	}
	public double getPositionX() {
		return positionX;
	}
	public double getPositionY() {
		return positionY;
	}
	public double getRadius() {
		return radius;
	}
	public boolean isLand() {
		return land;
	}
	public Color getColor(){
		return color;
	}

	
	public void initialize(){		//draws the lilypad
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledRectangle(this.getPositionX(), this.getPositionY(), this.getRadius()/2, this.getRadius()/2);
	}

	public void setBack() {
		this.land = false;
	}

	public void setBackColor() {		//changes color if reached lilypad
		this.color = Color.PINK;
		
	}
	
}
