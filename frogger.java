package lab10;
import java.awt.Color;

import sedgewick.StdDraw;

//Gregory Lubin, Amy Wang
//glubin, 424128 -- amycwang 423547
//Frogger Lab 10
//Main Method
	//Creates frogger game "Run Frog Run" with three lives and a score of zero. Cake (bonus points) are worth 5 points,
	//reaching a lilypad gets 50 points. There are 2 cars to start, a third if you reach level 2. Cars speed up
	//with every level. You can only go to each lilypad once per level
	//You level when you reach all four lilypads.

//Extra Credit = 50 points:
	//Requires a player to cross a stream -- 20 points
	//Includes a title screen and game over screen -- 10 points
	//Difficulty increased every level -- 10 points
	//Extra points from a cake -- 10 points (David M approves)

public class Frogger implements FroggerGame {

	private Frog frog;			//constructor
	private Stream stream;
	private int lives = 3;

	public Frogger(){			//initialize frog and stream
		frog = new Frog(.5, .001, .05, .05, Color.GREEN, 3, .01, 0);
		stream = new Stream(-0.1, 0.2, -0.1, 0.2, 0.1, 0.15, Color.ORANGE, 0.005);
		
	}
	/**
	 * 
	 * @return lives of frog
	 */
	public int getLives(){
		return this.lives;
	}	

	@Override
	public String getGameName() {
		return "Run Frog Run";
	}
	@Override
	public String[] getTeamMembers() {
		String[] members = { "Greg Lubin", "Amy Wang" };
		return members;
	}
	
	public static void gameOver(){
		System.out.println("game over");
	}
	
	public void playGame(){
		Screens.title();															//calls the title screen
		Car carOne = new Car(0.0, 0.4, 0.0, 0.4, 0.05, 0.1, Color.RED, 0.022);		//creates first car
		Car carTwo = new Car(0.0, 0.6, 0.0, 0.6, 0.05, 0.1, Color.RED, 0.011);		//creates second car
		Car carThree = new Car(-.2, 0.8, -.2, 0.8, 0.05, 0.1, Color.RED, 0.03);		//creates third car (which starts after first level)
		Cake cakeOne = new Cake(Math.random(), Math.random()/2+.3);
																					//creates lilypad goals
		Lilypads padOne = new Lilypads(.2,.94,.09,Color.PINK,false);
		Lilypads padTwo = new Lilypads(.4,.94,.09,Color.PINK,false);
		Lilypads padThree = new Lilypads(.6,.94,.09,Color.PINK,false);
		Lilypads padFour = new Lilypads(.8,.94,.09,Color.PINK,false);
		
		frog.initialize();															//initializes all elements (frog, car, stream, lilypad)
		carOne.initialize();
		carTwo.initialize();
		carThree.initialize();
		stream.initialize();
		padOne.initialize();
		padTwo.initialize();
		padThree.initialize();
		padFour.initialize();
		cakeOne.appear();
		StdDraw.setPenColor(Color.BLACK);										//displays text of live and score
		StdDraw.text(.15, .001, "Lives: " + String.valueOf(frog.getLives()));
		StdDraw.text(.8, .001, "Score: " + String.valueOf(frog.getScore()));
		boolean spawned = false;
		
		while(true){														//throughout the game updates

			StdDraw.setPenColor(Color.BLACK);		
			StdDraw.text(.15, .001, "Lives: " + String.valueOf(frog.getLives()));
			StdDraw.text(.8, .001, "Score: " + String.valueOf((int)frog.getScore()));
			
			carOne.carMove();												//moves the cars and raft
			carTwo.carMove();
			stream.streamMove();
			padOne.initialize();											//draws the lilypads
			padTwo.initialize();
			padThree.initialize();
			padFour.initialize();
			
			if (spawned == true){
				carThree.carMove();											//if completed level one
			}
			cakeOne.appear();												//draws cake randomly
			
			if(frog.getLives() != 0){
				frog.frogMove();
			}
			if(frog.getLives() == 0){										//ends game if no lives left
				Screens.endScreen(frog);
				frog.setLives(3);
				playGame();
			}
			
			frog.collide(carOne);										//checks for collision with different elements
			frog.collide(carTwo);
			frog.collide(carThree);
			frog.drowning(stream);
			frog.landed(padOne);
			frog.landed(padTwo);
			frog.landed(padThree);
			frog.landed(padFour);
			frog.bonus(cakeOne);
	
																	//levels up if all of the pads are reached
			if(padOne.isLand() == true && padTwo.isLand() == true && padThree.isLand() == true && padFour.isLand() == true){
				padOne.setBackColor();
				padTwo.setBackColor();
				padThree.setBackColor();
				padFour.setBackColor();
				padOne.setBack();
				padTwo.setBack();
				padThree.setBack();
				padFour.setBack();
				carOne.increaseSpeed();
				carTwo.increaseSpeed();
				carThree.increaseSpeed();
				spawned = true;
				
			}
			
			
			StdDraw.show(20);
			StdDraw.clear();

		}
	}

}