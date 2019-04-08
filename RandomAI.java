package hw4;
import java.util.Random;

public class RandomAI implements CFPlayer {
	public int nextMove(CFGame g) {
		int[][]state = g.getState();
		Random rand = new Random();
		int j = rand.nextInt(7);
		boolean empty = false;
		while (empty == false) {
			for(int i = 0; i < 6; i++) {
				if(state[i][j] == 0) 
					empty = true;
			}
			if(empty == false)
				j = rand.nextInt(7);
		}
		return j;
	}
	public String getName() {
		return "Random Player";
	}
}