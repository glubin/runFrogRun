package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Screens {



	public static void title() {		//title screen

		Frog firstFrog = new Frog(.1, .001, .05, .05, Color.GREEN, 3, .03, 0);		//creates two frogs
		Frog secondFrog = new Frog(.9, .001, .05, .05, Color.GREEN, 3, .03, 0);
		firstFrog.initialize();
		secondFrog.initialize();
		
		while (firstFrog.getPositionY() < 1){					//draws frogs moving up the screen
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledSquare(0.5, 0.5, 1.0);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(.5, .7, "Greg Lubin and Amy Wang");
			StdDraw.text(.5, .6, "present");
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.text(.5, .5, "RUN FROG RUN");
			firstFrog.moveUp();
			secondFrog.moveUp();
			firstFrog.initialize();
			secondFrog.initialize();
			StdDraw.show(100);
		}
	}

	public static void endScreen(Frog frog) {				//end screen
		Car carOne = new Car(0.0, 0.1, 0.0, 0.1, 0.05, 0.1, Color.RED, 0.032);		//creates cars and a frog
		Car carTwo = new Car(0.0, 0.9, 0.0, 0.9, 0.05, 0.1, Color.RED, 0.032);
		Frog firstFrog = new Frog(.5, .4, .05, .05, Color.GREEN, 3, .03, 0);


		while (carOne.getPositionX() < 1){
			StdDraw.setPenColor(StdDraw.BLACK);			//draws cars moving and frog in the middle of the screen
			StdDraw.filledSquare(0.5, 0.5, 1.0);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(.5, .6, "GAME OVER");
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.text(.5, .5, "Final Score: " + (int) frog.getScore());
			firstFrog.initialize();
			carOne.carMove();
			carTwo.carMove();
			StdDraw.show(100);
		}
	}

}
