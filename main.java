package Connect-Four;

//main page of the app
public class main {
	public static void main(String args[]) {
		//implements a game with the smart AI
		GUICF gui = new GUICF(new JohnAI());

		//implements a game with the random AI
		//GUICF gui = new GUICF(new Random());
	}
}
