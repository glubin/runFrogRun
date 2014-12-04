package lab10;
import java.awt.Color;

import sedgewick.StdDraw;


public class Stream{
	private double initialX;		//constructor
	private double initialY;
	private double positionX;
	private double positionY;
	private double length;
	private double width;
	private Color color;
	private double speed;

	public Stream (double firstX, double firstY, double x, double y, double l, double w, Color color, double speed){ 
		this.initialX = firstX;		//initializes
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
	
	
	public void initialize(){				//draws the stream and boat
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledRectangle(this.getInitX()-.2, this.getInitY(), this.getWidth()/2, this.getLength()/2);
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledRectangle(this.getInitX(), this.getInitY(), 1.3, this.length/2);
	}
	
	public void streamMove(){				//moves the raft to the right
		if(this.positionX + speed < 1 + this.length*3){
			this.positionX = this.positionX + speed;
		} else {
			this.positionX = this.initialX;
			this.initialize();
		}
		
		StdDraw.setPenColor(Color.BLUE);		//redraws the stream and boat
		StdDraw.filledRectangle(this.getInitX(), this.getInitY(), 1.3, this.length/2);
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledRectangle(this.getPositionX(), this.getPositionY(), this.getWidth()/2, this.getLength()/2);
	}

}