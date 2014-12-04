package lab10;
import java.awt.Color;

import sedgewick.StdDraw;

public class Frog {
	double positionX;		//constructor
	double positionY;
	double width;
	double length;
	Color color;
	int lives;
	double speed;
	int score;

	public Frog(double x, double y, double w, double l, Color color, int lives, double speed, int score){
		this.positionX = x;			//initialize
		this.positionY = y;
		this.width = w;
		this.length = l;
		this.color = color;
		this.lives = lives;
		this.speed = speed;
		this.score = score;
	}

	public void setLives(int lives){
		this.lives = lives;
	}
	public double getScore() {
		return score;
	}
	public double getPositionX() {
		return positionX;
	}
	public double getPositionY() {
		return positionY;
	}
	public double getWidth() {
		return width;
	}
	public double getLength() {
		return length;
	}
	public Color getColor() {
		return color;
	}
	public int getLives() {
		return lives;
	}
	public double getSpeed() {
		return speed;
	}

	//moves frog up
	public void moveUp(){
		this.positionY = this.positionY + this.speed;
	}
	//moves frog left
	public void moveLeft(){
		this.positionX = this.positionX - this.speed;
	}
	//moves frog right
	public void moveRight(){
		this.positionX = this.positionX + this.speed;
	}
	//moves frog down
	public void moveDown(){
		this.positionY = this.positionY - this.speed;
	}

	public void initialize(){		//prints out the frog at the start
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledRectangle(this.getPositionX(), this.getPositionY(), this.getWidth()/2, this.getLength()/2);
	}

	public void frogMove(){			//coordinates key presses with frog movements
		if (positionY<1 && ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_UP)){
			this.moveUp();
		}
		else if (positionX>0 && ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_LEFT)){
			this.moveLeft();
		}
		else if (positionY>0 && ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_DOWN)){
			this.moveDown();
		}
		else if (positionX<1 && ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_RIGHT)){
			this.moveRight();
		}
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledRectangle(this.getPositionX(), this.getPositionY(), this.getWidth()/2, this.getLength()/2);
	}

	//checks collision with the cars
	public void collide(Car car){
		if(this.positionY + this.length/2 >= car.getPositionY() - car.getLength()/2 
				&& this.positionY - this.length/2 <= car.getPositionY() + car.getLength()/2
				&& this.positionX - this.width/2 <= car.getPositionX() + car.getWidth()/2
				&& this.positionX + this.width/2 >= car.getPositionX() - car.getWidth()/2){
			deadFrog();
		}
	}

	//checks the collision with the stream
	public void drowning(Stream stream){
		if(this.positionY + this.length/2 >= stream.getPositionY() - stream.getLength()/2 			//checks if on the raft
				&& this.positionY - this.length/2 <= stream.getPositionY() + stream.getLength()/2
				&& this.positionX - this.width/2 <= stream.getPositionX() + stream.getWidth()/2
				&& this.positionX + this.width/2 >= stream.getPositionX() - stream.getWidth()/2){
			//moves frog right if on the raft
			this.positionX = this.positionX + stream.getSpeed();
		} else {
			if (this.positionY + this.length/2 >= .18 && this.positionY-this.length/2 <= .22){		//checks if in the stream
				deadFrog();
			}
		}
	}

	//checks if frog has reached the lilypad
	public void landed(Lilypads pad){
		if(this.positionY + this.length/2 <= pad.getPositionY() + pad.getRadius()/2
				&& this.positionY - this.length/2 >= pad.getPositionY() - pad.getRadius()/2
				&& this.positionX + this.width/2 <= pad.getPositionX() + pad.getRadius()/2
				&& this.positionX - this.width/2 >= pad.getPositionX() - pad.getRadius()/2){

			pad.setColor();
			if(pad.isLand() == false){
				this.positionX = .5;
				this.positionY = .001;
				this.score = this.score + 50;
			}
			pad.setIsLand();


		}
	}
	
	//checks collision with bonus cake
	public void bonus(Cake cake){
		double a = Math.abs(cake.getPositionX()-this.positionX);
		double b = Math.abs(cake.getPositionY()-this.positionY);
		double c = 	Math.sqrt(a*a+b*b);
		if(c < this.length){
			this.score = this.score + 5;
			cake.reset();
		}
	}
	
	//on death decrease lives and reinitialize frog
	public void deadFrog(){
		this.lives = this.lives - 1;
		this.positionX = 0.5;
		this.positionY = .001;
	}

	


}