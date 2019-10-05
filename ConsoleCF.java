package Connect-Four;
import java.util.Random;
import java.util.Scanner;

public class ConsoleCF extends CFGame {
	CFPlayer one;
	CFPlayer two;
	//Does player one go first?
	boolean onefirst;
	
	//this was for debugging 
	/*
	public ConsoleCF() {
		one = new HumanPlayer();
		two = new HumanPlayer();
		Random rand = new Random();
		int i = rand.nextInt(2);
		if(i == 0) {
			onefirst = true;
		}
		else if(i == 1) {
			onefirst = false;
		}
	}
	*/
	public ConsoleCF(CFPlayer ai) {
		one = new HumanPlayer();
		two = ai;
		Random rand = new Random();
		int i = rand.nextInt(2);
		if(i == 0) {
			//one is red and two is black
			onefirst = true;
		}
		else if(i == 1) {
			//one is black and two is black
			onefirst = false;
		}
	}

	public ConsoleCF(CFPlayer ai1, CFPlayer ai2) {
		one = ai1;
		two = ai2;
		Random rand = new Random();
		int i = rand.nextInt(2);
		if(i == 0) {
			onefirst = true;
		}
		else if(i == 1) {
			onefirst = false;
		}
	}

	public void playOut() {
		boolean empty = true;
		int turn;
		if(onefirst == true) 
			turn = 0;
		else  
			turn = 1;
		//if the board is filled the main code is not executed
		while(empty == true) {
			//debugging code
			/*
			System.out.println("About to win: " + aboutToWin());
			System.out.println("Winner is: " + winner());
			*/

			if(winner() == 0 || winner() == -1 || winner() == 1) {
				/*
				int[][] state1 = getState();
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 7; j++) { 
						System.out.print(state1[i][j]);
						System.out.print("  ");
					}
					System.out.println(" ");
				}
				*/
				break;
			}
			
			//checks to see if board is empty at the beginning of each loop
			boolean check = false;
			int[][]state = getState();
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					if(state[i][j] == 0) 
						check = true;
				}
			}
			if(check == false) 
				empty = false;
			if(empty == false)
				break;
			if(turn == 0) {
				int onemove = one.nextMove(this);
				play(onemove);
				turn = 1;
			}
			else {
				int twomove = two.nextMove(this);
				play(twomove);
				turn = 0;
			}
		//
		}
		System.out.println("The winner is " + getWinner());
	//
	}

	public String getWinner() {
		if(winner() == 0) 
			return "draw";
		else if(onefirst == true && winner() == 1) 
			return one.getName();
		else if(onefirst == true && winner() == -1)	
			return two.getName();
		else if(onefirst == false && winner() == 1) 
			return two.getName();
		else if(onefirst == false && winner() == -1) 
			return one.getName();
		else 
			return "No Winner Yet.";
	}

	private class HumanPlayer implements CFPlayer {
		public int nextMove(CFGame g) {
			int[][]state = g.getState();
			boolean empty = false;
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					System.out.print(state[i][j]);
					System.out.print("  ");
				}
				System.out.println(" ");
			}

			System.out.println("What is your next move?");
			Scanner reader = new Scanner(System.in);
    		int j = reader.nextInt();
    		while(empty == false) {
    			//out of bounds
    			while (j < 0 || j > 6) {
    				System.out.println("Out of bounds.");
    				System.out.println("What is your next move?");
    				j = reader.nextInt();
    			}
    			for(int i = 0; i < 6; i++) {
					if(state[i][j] == 0) 
						empty = true;
				}
				//column is full
				if(empty == false) {
					System.out.println("Column is full.");
    				System.out.println("What is your next move?");
    				j = reader.nextInt();
				}
    		}
    		return j;
		}

		public String getName() {
			return "Human Player";
		}
	}

}
