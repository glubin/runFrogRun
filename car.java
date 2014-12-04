package lab10;
import java.awt.Color;

import sedgewick.StdDraw;


public class Car{
	private double initialX;		//constructor
	private double initialY;
	private double positionX;
	private double positionY;
	private double length;
	private double width;
	private Color color;
	private double speed;

	public Car (double firstX, double firstY, double x, double y, double l, double w, Color color, double speed){ 
		this.initialX = firstX;			//initializes
		this.initialY = firstY;
		this.positionX = x;
		this.positionY = y;
		this.length = l;
		this.width = w;
		this.color = color;
		this.speed = speed;
	}

	public double getInitX(){
		return initialX;
	}
	public double getInitY(){
		return initialY;
	}
	public double getPositionX() {
		return positionX;
	}
	public double getPositionY(){
		return positionY;
	}
	public double getLength(){
		return length;
	}
	public double getWidth(){
		return width;
	}
	public Color getColor(){
		return color;
	}
	public double getSpeed(){
		return speed;
	}
	public void increaseSpeed(){
		this.speed = speed*1.3;
	}
	
	public void initialize(){						//creates a car and lane
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledRectangle(this.getInitX(), this.getInitY(), this.getWidth()/2, this.getLength()/2);
		StdDraw.setPenColor(Color.GRAY);
		StdDraw.filledRectangle(this.getInitX(), this.getInitY(), 1.4, .06);
	}
	
	public void carMove(){							//moves the car to the right
		if(this.positionX + speed < 1 + this.length*3){
			this.positionX = this.positionX + speed;
		} else {
			this.positionX = this.initialX;
			this.initialize();
		}
		
		StdDraw.setPenColor(Color.GRAY);
		StdDraw.filledRectangle(this.getInitX(), this.getInitY(), 1.4, .06);
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledRectangle(this.getPositionX(), this.getPositionY(), this.getWidth()/2, this.getLength()/2);
	}


}