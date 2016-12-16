import java.util.Scanner;

//Chase Nelson
//BowlerApp
//Genius Hour Project
//Carwile per. 4

public class Bowler {
	private String name;
	private int count, gameScore, avg;

	public Bowler(String nm) {
		name = nm;
		count = 0;
		gameScore = 0;
		avg = 0;
	}

	public void newGame() {
		//
		// Main
		// Menu
		Scanner keyIn = new Scanner(System.in);
		int frme[] = new int[10]; // Init Frame in a 1 dimension Array
		int allfrme[][] = new int[2][12]; // Init Frames with 2 Extra Pins in 2
											// dimension Array
		String s = null; // Input String

		System.out
				.println("\n\t  Welcome to Java Bowling Console Gaming Score Board ");
		for (int l1 = 0; l1 < 10; l1++)
			frme[l1] = 0;
		for (int l2 = 0; l2 < 12; l2++)
			allfrme[0][l2] = allfrme[1][l2] = 0;
		nxtfrme: // Init the arrays

		for (int i = 0; i < 10; i++) {
			boolean chk = false;
			int Pins = 0;

			while (!chk) { // Accepting string inputs and validating it
				System.out.printf("\n\t   FRAME %2d ",
						new Object[] { Integer.valueOf(i + 1) });

				System.out.printf("\n\t Ball 1: ");
				Pins = keyIn.nextInt();

				if (Pins <= 10 && Pins >= 0) {
					allfrme[0][i] = Pins;
					chk = true;
				}
			}
			if (Pins == 10) { // Displaying to user that he made a Strike
								// when equal to 10 pins
				System.out.println("\n\t\t\tExcelent, Strike!!");
				continue;

			}
			chk = false;

			// Calculating values
			// start
			if (allfrme[0][0] + allfrme[0][1] == 10)
				frme[0] = 10 + allfrme[0][1];
			else
				frme[0] = allfrme[0][0] + allfrme[1][0];

			// middle
			if (allfrme[0][0] == 10) {
				if (allfrme[0][1] == 10)
					frme[0] = 20 + allfrme[0][2];
				else
					frme[0] = 10 + allfrme[0][1] + allfrme[1][1];
			}

			// end
			for (int j = 1; j < 10; j++) {

				if (allfrme[0][j] == 10) {
					if (allfrme[0][j + 1] == 10)
						frme[j] = frme[j - 1] + 20 + allfrme[0][j + 2];
					else
						frme[j] = frme[j - 1] + 10 + allfrme[0][j + 1]
								+ allfrme[1][j + 1];
					continue;
				}

				if (allfrme[0][j] + allfrme[1][j] == 10)
					frme[j] = frme[j - 1] + 10 + allfrme[0][j + 1];
				else
					frme[j] = frme[j - 1] + allfrme[0][j] + allfrme[1][j];

			}

			// Printing Values
			System.out.print("\n\n\t  FRAME"); // Frame Heading
			// Init object loops to get and add values to the right address
			for (int k = 1; k < 11; k++)
				System.out.printf("%4d", new Object[] { Integer.valueOf(k) });

			if (allfrme[0][9] == 10) {
				if (allfrme[0][10] == 10)
					System.out.print("  XTR1 XTR2");
				else
					System.out.print("  EXTRA");

			} else if (allfrme[0][9] + allfrme[1][9] == 10)
				System.out.print("  XTRA");
			System.out.print("\n\n\tBall 1 ");

			for (int l = 0; l < 10; l++)
				System.out.printf("%4d",
						new Object[] { Integer.valueOf(allfrme[0][l]) });
			// Displaying the array addresses in each frame.
			if (allfrme[0][9] == 10) {
				if (allfrme[0][10] == 10)
					System.out.printf("%4d%4d",
							new Object[] { Integer.valueOf(allfrme[0][10]),
									Integer.valueOf(allfrme[0][11]) });
				else
					System.out.printf("%4d",
							new Object[] { Integer.valueOf(allfrme[0][10]) });

			} else if (allfrme[0][9] + allfrme[1][9] == 10)
				System.out.printf("%4d",
						new Object[] { Integer.valueOf(allfrme[0][10]) });
			System.out.print("\n\tBall 2 ");
			for (int i1 = 0; i1 < 10; i1++)
				System.out.printf("%4d",
						new Object[] { Integer.valueOf(allfrme[1][i1]) });

			if (allfrme[0][9] == 10 && allfrme[0][10] != 10)
				System.out.printf("%4d",
						new Object[] { Integer.valueOf(allfrme[1][10]) });

			System.out.print("\n\n\t  SCORE");
			for (int j1 = 0; j1 < 10; j1++)
				System.out.printf("%4d",
						new Object[] { Integer.valueOf(frme[j1]) });
			// Prompt to the user
			System.out.print("\n\n\t\t\tPlay more (Y/N)? ");
			s = keyIn.next();
			//String s1 = keyIn.nextLine();
		}
		while (s.toUpperCase().charAt(0) == 'Y')
			;
	}
	public static void main(String[] args){ }
}

/*
 * private String name; private int finalScore, frame, ball, avg, count; private
 * int[][] ballScore; private int[] frameScore;
 * 
 * public Bowler() { // default constructor name = ""; finalScore = 0; frame =
 * 0; ball = 0; avg = 0; count = 0; ballScore = new int[3][10]; frameScore = new
 * int[10]; }
 * 
 * public Bowler(String nm) { // name constructor name = nm; finalScore = 0;
 * frame = 0; ball = 0; avg = 0; count = 0; ballScore = new int[3][10];
 * frameScore = new int[10]; }
 * 
 * public void newGame() { while (frame < 9) { this.setBallScore();
 * this.nextBall();
 * 
 * } }
 * 
 * public void calScore() { frame = 0; ball = 0; while (frame < 9) {
 * this.setFrameScore(); } this.setFinalScore(); this.toString(); }
 * 
 * public void setBallScore() { Scanner reader = new Scanner(System.in); int
 * pinsDown; System.out.println("How many pins did you knock down?"); pinsDown =
 * reader.nextInt(); if (pinsDown > 10) {
 * System.out.println("ERROR! More than 10 pins hit."); System.exit(1); }
 * ballScore[this.getBallNumber()][this.getFrameNumber()] = pinsDown; }
 * 
 * public void nextBall() { if (this.getBallNumber() == 0) // next ball if
 * (ballScore[0][this.getFrameNumber()] == 10) //strike frame++; else ball = 1;
 * else if (this.getFrameNumber() >= 8) // next frame frame++; else if
 * (this.getFrameNumber() == 9 && ballScore[0][9] + ballScore[1][9] >= 10) //
 * tenth frame // strike/spare ball = 2; }
 * 
 * public void setFrameScore() { if (ballScore[0][this.getFrameNumber()] == 10)
 * { // strike System.out.println("Strike"); if
 * (ballScore[0][this.getFrameNumber() + 1] == 10) // if double
 * frameScore[this.getFrameNumber()] = 10 + ballScore[0][this.getFrameNumber() +
 * 1] + ballScore[0][this.getFrameNumber() + 1]; else
 * frameScore[this.getFrameNumber()] = 10 + ballScore[0][this.getFrameNumber() +
 * 1] + ballScore[1][this.getFrameNumber() + 1]; } else if
 * (ballScore[0][this.getFrameNumber()] + ballScore[1][this.getFrameNumber()] ==
 * 10) { // spare System.out.println("Spare"); frameScore[this.getFrameNumber()]
 * = 10 + ballScore[0][this .getFrameNumber() + 1]; } else
 * frameScore[this.getFrameNumber()] = ballScore[0][this .getFrameNumber()] +
 * ballScore[1][this.getFrameNumber()]; }
 * 
 * public int getFrameNumber() { // frame number return frame; }
 * 
 * public int getBallNumber() { return ball; }
 * 
 * public void setFinalScore() { for (int i = 0; i < frameScore.length; i++)
 * finalScore += frameScore[i]; count++; this.setAVG(); }
 * 
 * public void setAVG() { avg = (finalScore + avg) / count; }
 * 
 * public String toString() { String str; str = "Bowler:  " + name +
 * "\nFinal Score:  " + finalScore + "\nAverage:  " + avg; return str; }
 */
