package Connect-Four;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class GUICF extends CFGame {
	private GameBoard this_board;
	CFPlayer one;
	CFPlayer two;
	boolean onefirst;
	GUICF recursive;
	JFrame frame = new JFrame("Connect 4");	
	Container pane = frame.getContentPane();
	int turn;

	public GUICF(CFPlayer ai) {
		//implementing GUI
		recursive = this;
		JPanel panel = new JPanel();
		pane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1,7));
		//implementing buttons
		JButton button0 = new JButton("\u2193");
		JButton button1 = new JButton("\u2193");
		JButton button2 = new JButton("\u2193");
		JButton button3 = new JButton("\u2193");
		JButton button4 = new JButton("\u2193");
		JButton button5 = new JButton("\u2193");
		JButton button6 = new JButton("\u2193");
		panel.add(button0);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		button0.addActionListener(new B0L());
		button1.addActionListener(new B1L());
		button2.addActionListener(new B2L());
		button3.addActionListener(new B3L());
		button4.addActionListener(new B4L());
		button5.addActionListener(new B5L());
		button6.addActionListener(new B6L());
		//rest of GUI
		this_board = new GameBoard();
		pane.add(this_board);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setVisible(true);

		//implementing game
		one = new HumanPlayer();
		two = ai;
		Random rand = new Random();
		int i = rand.nextInt(2);
		if(i == 0) {
			//one has the first turn and is red
			onefirst = true;
			turn = 0;
		}
		else if (i == 1) {
			//two has the first turn and is red
			onefirst = false;
			turn = 1;
		}
		//if two has the first turn, it plays the first move before any arrow button is pressed
		if(turn == 1) {
			int j = rand.nextInt(7);
			playGUI(j);
		}
	}

	public GUICF(CFPlayer ai1, CFPlayer ai2) {
		//implementing GUI
		recursive = this;
		JButton button = new JButton("Play");
		pane.add(button, BorderLayout.NORTH);
		button.addActionListener(new ActionClass());
		this_board = new GameBoard();
		pane.add(this_board);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setVisible(true);
		//implementing game
		one = ai1;
		two = ai2;
		Random rand = new Random();
		int i = rand.nextInt(2);
		if(i == 0) {
			onefirst = true;
			turn = 0;
		}
		else if (i == 1) {
			onefirst = false;
			turn = 1;
		}
	}
	
	private boolean playGUI(int c) {
		//out of bounds
		if(c < 0 || c > 6) {
      		return false;
    	}
		int[][] state = getState();
		int row = 0;
		boolean empty = false;
		for(int i = 5; i >= 0; i--) {
			if(state[i][c] == 0) {
				row = i;
				empty = true;
				break;
			}
		}
		//if the column has at least one empty spot
		if(empty == true) {
			if(isRedTurn() == true) {
				this_board.paint(row, c, 1);
			}
			else if(isRedTurn() == false) {
				this_board.paint(row, c, -1);
			}
			play(c);
			return true;
		}
		return false;
	}


	//separate classes
	private class HumanPlayer implements CFPlayer {
		public int nextMove(CFGame g) {
			return 99;
		}

		public String getName() {
			return "Human Player";
		}
	}

	private class GameBoard extends JPanel {
		private JLabel pieces[][];
		private GameBoard() {
			pieces = new JLabel[6][7];
			//implementing each individual spot in the board
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					pieces[i][j] = new JLabel();
					Border border = BorderFactory.createLineBorder(Color.black);
					pieces[i][j].setOpaque(true);
					pieces[i][j].setBorder(border);
				}
			}
			setLayout(new GridLayout(6,7));
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					add(pieces[i][j]);
				}
			}
		}//end of GameBoard()

		private void paint(int x, int y, int color) {
			if(color == 1) {
				pieces[x][y].setBackground(Color.red);
			}
			else if(color == -1) {
				pieces[x][y].setBackground(Color.black);
			}
		}
	}

	//play button actionlistener
	private class ActionClass implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			boolean check = false;
			int[][]state = getState();
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					if(state[i][j] == 0) {
						check = true;
					}
				}
			}
			//board is full
			if(check == false) {
				System.out.println("No empty slots left");
			}
			else if(winner() == 0 || winner() == -1 || winner() == 1) {
				if(winner() == 0) {
					System.out.println("draw");
				}
				else if(onefirst == true && winner() == 1) {
					System.out.println(one.getName());
				}
				else if(onefirst == true && winner() == -1)	{
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == 1) {
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == -1) {
					System.out.println(one.getName());
				}
				else {
					System.out.print("No winner yet.");
				}
			}
			else {
				System.out.println("Pressed button");
				//switches turn after each button press
				if(turn == 0) {
					int onemove = one.nextMove(recursive);
					playGUI(onemove);
					turn = 1;
				}
				else {
					int twomove = two.nextMove(recursive);
					playGUI(twomove);
					turn = 0;
				}
			}
		}//actionPerformed
	}//ActionClass

	private class B0L implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			boolean check = false;
			boolean empty = false;
			int[][]state = getState();
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					if(state[i][j] == 0) {
						check = true;
						break;
					}
				}
			}
			for(int i = 0; i < 6; i++) {
				if(state[i][0] == 0) {
					empty = true;
					break;
				}
			}
			if(check == false) {
				System.out.println("No empty slots left");
			}
			else if(empty == false) {
				System.out.println("Column is filled up");
			}
			else if(winner() == 0 || winner() == -1 || winner() == 1) {
				if(winner() == 0) {
					System.out.println("draw");
				}
				else if(onefirst == true && winner() == 1) {
					System.out.println(one.getName());
				}
				else if(onefirst == true && winner() == -1)	{
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == 1) {
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == -1) {
					System.out.println(one.getName());
				}
				else {
					System.out.print("idk");
				}
			}
			else {
					//the player goes first and then the AI goes 2nd
					playGUI(0);
					check = false;
					for(int i = 0; i < 6; i++) {
						for(int j = 0; j < 7; j++) {
							if(state[i][j] == 0) {
								check = true;
								break;
							}
						}
					}
					if(winner() != 0 && winner() != -1 && winner() != 1 && check != false) {
						int twomove = two.nextMove(recursive);
						playGUI(twomove);
					}
			}
		}//Lol
	}

	private class B1L implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			boolean check = false;
			boolean empty = false;
			int[][]state = getState();
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					if(state[i][j] == 0) {
						check = true;
						break;
					}
				}
			}
			for(int i = 0; i < 6; i++) {
				if(state[i][1] == 0) {
					empty = true;
					break;
				}
			}
			if(check == false) {
				System.out.println("No empty slots left");
			}
			else if(empty == false) {
				System.out.println("Column is filled up");
			}
			else if(winner() == 0 || winner() == -1 || winner() == 1) {
				if(winner() == 0) {
					System.out.println("draw");
				}
				else if(onefirst == true && winner() == 1) {
					System.out.println(one.getName());
				}
				else if(onefirst == true && winner() == -1)	{
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == 1) {
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == -1) {
					System.out.println(one.getName());
				}
				else {
					System.out.print("No winner.");
				}
			}
			else {
					playGUI(1);
					check = false;
					for(int i = 0; i < 6; i++) {
						for(int j = 0; j < 7; j++) {
							if(state[i][j] == 0) {
								check = true;
								break;
							}
						}
					}
					if(winner() != 0 && winner() != -1 && winner() != 1 && check != false) {
						int twomove = two.nextMove(recursive);
						playGUI(twomove);
					}
			}
		}
	}

	private class B2L implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			boolean check = false;
			boolean empty = false;
			int[][]state = getState();
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					if(state[i][j] == 0) {
						check = true;
						break;
					}
				}
			}
			for(int i = 0; i < 6; i++) {
				if(state[i][2] == 0) {
					empty = true;
					break;
				}
			}
			if(check == false) {
				System.out.println("No empty slots left");
			}
			else if(empty == false) {
				System.out.println("Column is filled up");
			}
			else if(winner() == 0 || winner() == -1 || winner() == 1) {
				if(winner() == 0) {
					System.out.println("draw");
				}
				else if(onefirst == true && winner() == 1) {
					System.out.println(one.getName());
				}
				else if(onefirst == true && winner() == -1)	{
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == 1) {
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == -1) {
					System.out.println(one.getName());
				}
				else {
					System.out.print("No winner.");
				}
			}
			else {
					playGUI(2);
					check = false;
					for(int i = 0; i < 6; i++) {
						for(int j = 0; j < 7; j++) {
							if(state[i][j] == 0) {
								check = true;
								break;
							}
						}
					}
					if(winner() != 0 && winner() != -1 && winner() != 1 && check != false) {
						int twomove = two.nextMove(recursive);
						playGUI(twomove);
					}
			}
		}
	}

	private class B3L implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			boolean check = false;
			boolean empty = false;
			int[][]state = getState();
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					if(state[i][j] == 0) {
						check = true;
						break;
					}
				}
			}
			for(int i = 0; i < 6; i++) {
				if(state[i][3] == 0) {
					empty = true;
					break;
				}
			}
			if(check == false) {
				System.out.println("No empty slots left");
			}
			else if(empty == false) {
				System.out.println("Column is filled up");
			}
			else if(winner() == 0 || winner() == -1 || winner() == 1) {
				if(winner() == 0) {
					System.out.println("draw");
				}
				else if(onefirst == true && winner() == 1) {
					System.out.println(one.getName());
				}
				else if(onefirst == true && winner() == -1)	{
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == 1) {
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == -1) {
					System.out.println(one.getName());
				}
				else {
					System.out.print("No winner.");
				}
			}
			else {
					playGUI(3);
					check = false;
					for(int i = 0; i < 6; i++) {
						for(int j = 0; j < 7; j++) {
							if(state[i][j] == 0) {
								check = true;
								break;
							}
						}
					}
					if(winner() != 0 && winner() != -1 && winner() != 1 && check != false) {
						int twomove = two.nextMove(recursive);
						playGUI(twomove);
					}
			}
		}
	}

	private class B4L implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			boolean check = false;
			boolean empty = false;
			int[][]state = getState();
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					if(state[i][j] == 0) {
						check = true;
						break;
					}
				}
			}
			for(int i = 0; i < 6; i++) {
				if(state[i][4] == 0) {
					empty = true;
					break;
				}
			}
			if(check == false) {
				System.out.println("No empty slots left");
			}
			else if(empty == false) {
				System.out.println("Column is filled up");
			}
			else if(winner() == 0 || winner() == -1 || winner() == 1) {
				if(winner() == 0) {
					System.out.println("draw");
				}
				else if(onefirst == true && winner() == 1) {
					System.out.println(one.getName());
				}
				else if(onefirst == true && winner() == -1)	{
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == 1) {
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == -1) {
					System.out.println(one.getName());
				}
				else {
					System.out.print("No winner.");
				}
			}
			else {
					playGUI(4);
					check = false;
					for(int i = 0; i < 6; i++) {
						for(int j = 0; j < 7; j++) {
							if(state[i][j] == 0) {
								check = true;
								break;
							}
						}
					}
					if(winner() != 0 && winner() != -1 && winner() != 1 && check != false) {
						int twomove = two.nextMove(recursive);
						playGUI(twomove);
					}
			}
		}
	}

	private class B5L implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			boolean check = false;
			boolean empty = false;
			int[][]state = getState();
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					if(state[i][j] == 0) {
						check = true;
						break;
					}
				}
			}
			for(int i = 0; i < 6; i++) {
				if(state[i][5] == 0) {
					empty = true;
					break;
				}
			}
			if(check == false) {
				System.out.println("No empty slots left");
			}
			else if(empty == false) {
				System.out.println("Column is filled up");
			}
			else if(winner() == 0 || winner() == -1 || winner() == 1) {
				if(winner() == 0) {
					System.out.println("draw");
				}
				else if(onefirst == true && winner() == 1) {
					System.out.println(one.getName());
				}
				else if(onefirst == true && winner() == -1)	{
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == 1) {
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == -1) {
					System.out.println(one.getName());
				}
				else {
					System.out.print("No winner.");
				}
			}
			else {
				playGUI(5);
				check = false;
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 7; j++) {
						if(state[i][j] == 0) {
							check = true;
							break;
						}
					}
				}
				if(winner() != 0 && winner() != -1 && winner() != 1 && check != false) {
					int twomove = two.nextMove(recursive);
					playGUI(twomove);
				}
			}
		}
	}

	private class B6L implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			boolean check = false;
			boolean empty = false;
			int[][]state = getState();
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					if(state[i][j] == 0) {
						check = true;
						break;
					}
				}
			}
			for(int i = 0; i < 6; i++) {
				if(state[i][6] == 0) {
					empty = true;
					break;
				}
			}
			if(check == false) {
				System.out.println("No empty slots left");
			}
			else if(empty == false) {
				System.out.println("Column is filled up");
			}
			else if(winner() == 0 || winner() == -1 || winner() == 1) {
				if(winner() == 0) {
					System.out.println("draw");
				}
				else if(onefirst == true && winner() == 1) {
					System.out.println(one.getName());
				}
				else if(onefirst == true && winner() == -1)	{
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == 1) {
					System.out.println(two.getName());
				}
				else if(onefirst == false && winner() == -1) {
					System.out.println(one.getName());
				}
				else {
					System.out.print("No winner.");
				}
			}
			else {
				playGUI(6);
					check = false;
					for(int i = 0; i < 6; i++) {
						for(int j = 0; j < 7; j++) {
							if(state[i][j] == 0) {
								check = true;
								break;
							}
						}
					}
					if(winner() != 0 && winner() != -1 && winner() != 1 && check != false) {
						int twomove = two.nextMove(recursive);
						playGUI(twomove);
					}
			}
		}
	}
}
