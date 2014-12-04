package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Cake {
	private double positionX;	//constructor
	private double positionY;
	private double radius;
	private Color color;


	public Cake(double x, double y){
		this.positionX = x;			//initializes
		this.positionY = y;
		this.radius = .04;
		this.color = Color.magenta;
	}

	public double getPositionX(){
		return positionX;
	}
	public double getPositionY(){
		return positionY;
	}
	public double getRadius(){
		return radius;
	}
	public Color getColor(){
		return color;
	}

	public void appear(){						//prints out the cake
		StdDraw.setPenColor(this.getColor());
		//StdDraw.filledRectangle(this.getPositionX(), this.getPositionY(), this.getRadius()/2, this.getRadius()/2);
		StdDraw.filledCircle(this.getPositionX(), this.getPositionY(), this.getRadius()/2);
	}

	public void reset(){						//resets the cake with new coordinates randomly
		this.positionY = Math.random();
		this.positionX = Math.random()/2+.3;
		this.appear();
//		StdDraw.setPenColor(this.getColor());
//		StdDraw.filledRectangle(this.getPositionX(), this.getPositionY(), this.getRadius()/2, this.getRadius()/2);
	}


}




