package hw4;
import java.util.Random;

public class JohnAI implements CFPlayer {
	public int aboutToWin(CFGame g) {
    //the commented out System.out.println(number) code was for debugging purposes
    //checks the abouttoWin conditions for red and if there is none, checks them for black
    //for red, it returns the column position + 7
    //for black, it returns the column position + 14
    if(g.isRedTurn() == true) {
      boolean iszero = false;
      int returnvalue = 0;
      int[][]state = g.getState();
      
      //System.out.println("5");
      //Vertical
    for(int j = 0; j < 7; j++) {
      for(int i = 5; i > 2; i--) {
         iszero = false;
         if(state[i][j] == 0 && state[i-1][j] == 1 && state[i-2][j] == 1 && state[i-3][j]== 1) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else if(state[i][j] == 1 && state[i-1][j] == 0 && state[i-2][j] == 1 && state[i-3][j] == 1) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else if(state[i][j] == 1 && state[i-1][j] == 1 && state[i-2][j] == 0 && state[i-3][j] == 1) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else if(state[i][j] == 1 && state[i-1][j] == 1 && state[i-2][j] == 1 && state[i-3][j] == 0) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else {

          }
      }
      if(iszero == true) 
        return returnvalue + 7;
    }
    
    //System.out.println("6");
    //Horizontal
    
    for(int i = 5; i >= 0; i--) {
      for(int j = 0; j < 4; j++) {
        iszero = false;
        if(state[i][j] == 0 && state[i][j+1] == 1 && state[i][j+2] == 1 && state[i][j+3] == 1) {
        	 iszero = true;
        	 returnvalue = j;
             break;
         } 
         else if(state[i][j] == 1 && state[i][j+1] == 0 && state[i][j+2] == 1 && state[i][j+3] == 1) {
        	 iszero = true;
        	 returnvalue = j+1;
             break;
         }
         else if(state[i][j] == 1 && state[i][j+1] == 1 && state[i][j+2] == 0 && state[i][j+3] == 1) {
        	 iszero = true;
        	 returnvalue = j+2;
             break;
         } 
         else if(state[i][j] == 1 && state[i][j+1] == 1 && state[i][j+2] == 1 && state[i][j+3] == 0) {
        	 iszero = true;
        	 returnvalue = j+3;
             break;
         } 
         else {

         }
      }
      if(iszero == true) 
        return returnvalue + 7;
      }
      


    
   //System.out.println("7");
    //Diagonal down to up
    for (int j = 0; j < 4; j++) {
      for(int i = 5; i > 2; i--) {
          iszero = false;
          if((state[i][j] == 0 && state[i-1][j+1] == 1 && state[i-2][j+2] == 1 && state[i-3][j+3] == 1)) {
              iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == 1 && state[i-1][j+1] == 0 && state[i-2][j+2] == 1 && state[i-3][j+3] == 1)) {
          	  iszero = true;
              returnvalue = j+1;
              break;
          }
          else if((state[i][j] == 1 && state[i-1][j+1] == 1 && state[i-2][j+2] == 0 && state[i-3][j+3] == 1)) {
          	  iszero = true;
              returnvalue = j+2;
              break;
          }
          else if((state[i][j] == 1 && state[i-1][j+1] == 1 && state[i-2][j+2] == 1 && state[i-3][j+3] == 0)) {
          	  iszero = true;
              returnvalue = j+3;
              break;
          }
          else {

          }
      }
      if(iszero == true) 
        return returnvalue + 7;
    }
    
    //System.out.println("8");
    //Diagonal up to down
    for (int j = 0; j < 4; j++) {
      for(int i = 0; i < 3; i++) {
         iszero = false;
         if((state[i][j] == 0 && state[i+1][j+1] == 1 && state[i+2][j+2] == 1 && state[i+3][j+3] == 1)) {
              iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == 1 && state[i+1][j+1] == 0 && state[i+2][j+2] == 1 && state[i+3][j+3] == 1)) {
          	  iszero = true;
              returnvalue = j+1;
              break;
          }
          else if((state[i][j] == 1 && state[i+1][j+1] == 1 && state[i+2][j+2] == 0 && state[i+3][j+3] == 1)) {
          	  iszero = true;
              returnvalue = j+2;
              break;
          }
          else if((state[i][j] == 1 && state[i+1][j+1] == 1 && state[i+2][j+2] == 1 && state[i+3][j+3] == 0)) {
          	  iszero = true;
              returnvalue = j+3;
              break;
          }
          else {

          }
      }
      if(iszero == true) 
        return returnvalue + 7;
    }  

    //System.out.println("9");
    //Vertical
     for(int j = 0; j < 7; j++) {
      for(int i = 5; i > 2; i--) {
         iszero = false;
         if(state[i][j] == 0 && state[i-1][j] == -1 && state[i-2][j] == -1 && state[i-3][j]== -1) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else if(state[i][j] == -1 && state[i-1][j] == 0 && state[i-2][j] == -1 && state[i-3][j] == -1) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else if(state[i][j] == -1 && state[i-1][j] == -1 && state[i-2][j] == 0 && state[i-3][j] == -1) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else if(state[i][j] == -1 && state[i-1][j] == -1 && state[i-2][j] == -1 && state[i-3][j] == 0) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else {

          }
      }
      if(iszero == true) 
        return returnvalue + 14;
    }

      //System.out.println("10");
      //Horizontal
    for(int i = 5; i >= 0; i--) {
      for(int j = 0; j < 4; j++) {
        iszero = false;
        if(state[i][j] == 0 && state[i][j+1] == -1 && state[i][j+2] == -1 && state[i][j+3] == -1) {
        	 iszero = true;
        	 returnvalue = j;
             break;
         } 
         else if(state[i][j] == -1 && state[i][j+1] == 0 && state[i][j+2] == -1 && state[i][j+3] == -1) {
        	 iszero = true;
        	 returnvalue = j+1;
             break;
         }
         else if(state[i][j] == -1 && state[i][j+1] == -1 && state[i][j+2] == 0 && state[i][j+3] == -1) {
        	 iszero = true;
        	 returnvalue = j+2;
             break;
         } 
         else if(state[i][j] == -1 && state[i][j+1] == -1 && state[i][j+2] == -1 && state[i][j+3] == 0) {
        	 iszero = true;
        	 returnvalue = j+3;
             break;
         } 
         else {

         }
      }
      if(iszero == true) 
        return returnvalue + 14;
      }


    //System.out.println("11");
    //Diagonal down to up
    for (int j = 0; j < 4; j++) {
      for(int i = 5; i > 2; i--) {
          iszero = false;
          if((state[i][j] == 0 && state[i-1][j+1] == -1 && state[i-2][j+2] == -1 && state[i-3][j+3] == -1)) {
              iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == -1 && state[i-1][j+1] == 0 && state[i-2][j+2] == -1 && state[i-3][j+3] == -1)) {
          	  iszero = true;
              returnvalue = j+1;
              break;
          }
          else if((state[i][j] == -1 && state[i-1][j+1] == -1 && state[i-2][j+2] == 0 && state[i-3][j+3] == -1)) {
          	  iszero = true;
              returnvalue = j+2;
              break;
          }
          else if((state[i][j] == -1 && state[i-1][j+1] == -1 && state[i-2][j+2] == -1 && state[i-3][j+3] == 0)) {
          	  iszero = true;
              returnvalue = j+3;
              break;
          }
          else {

          }
      }
      if(iszero == true) 
        return returnvalue + 14;
    }
    
    //System.out.println("12");
    //Diagonal up to down
     for (int j = 0; j < 4; j++) {
      for(int i = 0; i < 3; i++) {
          iszero = false;
          if((state[i][j] == 0 && state[i+1][j+1] == -1 && state[i+2][j+2] == -1 && state[i+3][j+3] == -1)) {
              iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == -1 && state[i+1][j+1] == 0 && state[i+2][j+2] == -1 && state[i+3][j+3] == -1)) {
          	  iszero = true;
              returnvalue = j+1;
              break;
          }
          else if((state[i][j] == -1 && state[i+1][j+1] == -1 && state[i+2][j+2] == 0 && state[i+3][j+3] == -1)) {
          	  iszero = true;
              returnvalue = j+2;
              break;
          }
          else if((state[i][j] == -1 && state[i+1][j+1] == -1 && state[i+2][j+2] == -1 && state[i+3][j+3] == 0)) {
          	  iszero = true;
              returnvalue = j+3;
              break;
          }
          else {

          }
      }
      if(iszero == true) 
        return returnvalue + 14;
    }  
     
    }//first what if

  //checks the abouttoWin conditions for black and if there is none, checks them for red
  else if(g.isRedTurn() == false) {
      boolean iszero = false;
      int returnvalue = 0;
       int[][]state = g.getState();
      //System.out.println("13");
      //Vertical
      for(int j = 0; j < 7; j++) {
      	for(int i = 5; i > 2; i--) {
         iszero = false;
         if(state[i][j] == 0 && state[i-1][j] == -1 && state[i-2][j] == -1 && state[i-3][j]== -1) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else if(state[i][j] == -1 && state[i-1][j] == 0 && state[i-2][j] == -1 && state[i-3][j] == -1) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else if(state[i][j] == -1 && state[i-1][j] == -1 && state[i-2][j] == 0 && state[i-3][j] == -1) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else if(state[i][j] == -1 && state[i-1][j] == -1 && state[i-2][j] == -1 && state[i-3][j] == 0) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else {

          }
      	}
      if(iszero == true) 
        return returnvalue + 14;
    }

      //System.out.println("14");
      //Horizontal
    for(int i = 5; i >= 0; i--) {
      for(int j = 0; j < 4; j++) {
        iszero = false;
        if(state[i][j] == 0 && state[i][j+1] == -1 && state[i][j+2] == -1 && state[i][j+3] == -1) {
        	 iszero = true;
        	 returnvalue = j;
             break;
         } 
         else if(state[i][j] == -1 && state[i][j+1] == 0 && state[i][j+2] == -1 && state[i][j+3] == -1) {
        	 iszero = true;
        	 returnvalue = j+1;
             break;
         }
         else if(state[i][j] == -1 && state[i][j+1] == -1 && state[i][j+2] == 0 && state[i][j+3] == -1) {
        	 iszero = true;
        	 returnvalue = j+2;
             break;
         } 
         else if(state[i][j] == -1 && state[i][j+1] == -1 && state[i][j+2] == -1 && state[i][j+3] == 0) {
        	 iszero = true;
        	 returnvalue = j+3;
             break;
         } 
         else {

         }
      }
      if(iszero == true) 
        return returnvalue + 14;
      }

    //System.out.println("15");
    //Diagonal down to up
    for (int j = 0; j < 4; j++) {
      for(int i = 5; i > 2; i--) {
          iszero = false;
          if((state[i][j] == 0 && state[i-1][j+1] == -1 && state[i-2][j+2] == -1 && state[i-3][j+3] == -1)) {
              iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == -1 && state[i-1][j+1] == 0 && state[i-2][j+2] == -1 && state[i-3][j+3] == -1)) {
          	  iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == -1 && state[i-1][j+1] == -1 && state[i-2][j+2] == 0 && state[i-3][j+3] == -1)) {
          	  iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == -1 && state[i-1][j+1] == -1 && state[i-2][j+2] == -1 && state[i-3][j+3] == 0)) {
          	  iszero = true;
              returnvalue = j;
              break;
          }
          else {

          }
      }
      if(iszero == true) 
        return returnvalue + 14;
    }
    
    //System.out.println("16");
    //Diagonal up to down
    for (int j = 0; j < 4; j++) {
      for(int i = 0; i < 3; i++) {
          iszero = false;
          if((state[i][j] == 0 && state[i+1][j+1] == -1 && state[i+2][j+2] == -1 && state[i+3][j+3] == -1)) {
              iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == -1 && state[i+1][j+1] == 0 && state[i+2][j+2] == -1 && state[i+3][j+3] == -1)) {
          	  iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == -1 && state[i+1][j+1] == -1 && state[i+2][j+2] == 0 && state[i+3][j+3] == -1)) {
          	  iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == -1 && state[i+1][j+1] == -1 && state[i+2][j+2] == -1 && state[i+3][j+3] == 0)) {
          	  iszero = true;
              returnvalue = j;
              break;
          }
          else {

          }
      }
      if(iszero == true) 
        return returnvalue + 14;
    }  

    //System.out.println("17");
    //Vertical
    for(int j = 0; j < 7; j++) {
      for(int i = 5; i > 2; i--) {
         iszero = false;
         if(state[i][j] == 0 && state[i-1][j] == 1 && state[i-2][j] == 1 && state[i-3][j]== 1) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else if(state[i][j] == 1 && state[i-1][j] == 0 && state[i-2][j] == 1 && state[i-3][j] == 1) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else if(state[i][j] == 1 && state[i-1][j] == 1 && state[i-2][j] == 0 && state[i-3][j] == 1) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else if(state[i][j] == 1 && state[i-1][j] == 1 && state[i-2][j] == 1 && state[i-3][j] == 0) {
         	  returnvalue = j;
         	  iszero = true;
	          break;
          }
          else {

          }
      }
      if(iszero == true) 
        return returnvalue + 7;
    }
    
    //System.out.println("18");
    //Horizontal
    for(int i = 5; i >= 0; i--) {
      for(int j = 0; j < 4; j++) {
        iszero = false;
        if(state[i][j] == 0 && state[i][j+1] == 1 && state[i][j+2] == 1 && state[i][j+3] == 1) {
        	 iszero = true;
        	 returnvalue = j;
             break;
         } 
         else if(state[i][j] == 1 && state[i][j+1] == 0 && state[i][j+2] == 1 && state[i][j+3] == 1) {
        	 iszero = true;
        	 returnvalue = j+1;
             break;
         }
         else if(state[i][j] == 1 && state[i][j+1] == 1 && state[i][j+2] == 0 && state[i][j+3] == 1) {
        	 iszero = true;
        	 returnvalue = j+2;
             break;
         } 
         else if(state[i][j] == 1 && state[i][j+1] == 1 && state[i][j+2] == 1 && state[i][j+3] == 0) {
        	 iszero = true;
        	 returnvalue = j+3;
             break;
         } 
         else {

         }
      }
      if(iszero == true) 
        return returnvalue + 7;
      }

    //System.out.println("19");
    //Diagonal down to up
    for (int j = 0; j < 4; j++) {
      for(int i = 5; i > 2; i--) {
          iszero = false;
          if((state[i][j] == 0 && state[i-1][j+1] == 1 && state[i-2][j+2] == 1 && state[i-3][j+3] == 1)) {
              iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == 1 && state[i-1][j+1] == 0 && state[i-2][j+2] == 1 && state[i-3][j+3] == 1)) {
          	  iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == 1 && state[i-1][j+1] == 1 && state[i-2][j+2] == 0 && state[i-3][j+3] == 1)) {
          	  iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == 1 && state[i-1][j+1] == 1 && state[i-2][j+2] == 1 && state[i-3][j+3] == 0)) {
          	  iszero = true;
              returnvalue = j;
              break;
          }
          else {

          }
      }
      if(iszero == true) 
        return returnvalue + 7;
    }

    //System.out.println("20");
    //Diagonal up to down
    for (int j = 0; j < 4; j++) {
      for(int i = 0; i < 3; i++) {
          iszero = false;
          if((state[i][j] == 0 && state[i+1][j+1] == 1 && state[i+2][j+2] == 1 && state[i+3][j+3] == 1)) {
              iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == 1 && state[i+1][j+1] == 0 && state[i+2][j+2] == 1 && state[i+3][j+3] == 1)) {
          	  iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == 1 && state[i+1][j+1] == 1 && state[i+2][j+2] == 0 && state[i+3][j+3] == 1)) {
          	  iszero = true;
              returnvalue = j;
              break;
          }
          else if((state[i][j] == 1 && state[i+1][j+1] == 1 && state[i+2][j+2] == 1 && state[i+3][j+3] == 0)) {
          	  iszero = true;
              returnvalue = j;
              break;
          }
          else {

          }
      }
      if(iszero == true) 
        return returnvalue + 7;
    } 

  }//2nd what if
    //if there is no player about to win
    return 99;

  }


	public int nextMove(CFGame g) {
		if(g.isRedTurn() == true) {
			//if red is about to win
			if(aboutToWin(g) == 7 || aboutToWin(g) == 8 || aboutToWin(g) == 9 || aboutToWin(g) == 10 || aboutToWin(g) == 11 || aboutToWin(g) == 12 || aboutToWin(g) == 13) {
				int returnvalue = aboutToWin(g);
				return returnvalue - 7;
			}
			//if black is about to win
			else if(aboutToWin(g) == 14 || aboutToWin(g) == 15 || aboutToWin(g) == 16 || aboutToWin(g) == 17 || aboutToWin(g) == 18 || aboutToWin(g) == 19 || aboutToWin(g) == 20) {
				int returnvalue = aboutToWin(g);
				return returnvalue - 14;
			}
			else {
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
		}
		else {
			//if black is allowed to win
			if(aboutToWin(g) == 14 || aboutToWin(g) == 15 || aboutToWin(g) == 16 || aboutToWin(g) == 17 || aboutToWin(g) == 18 || aboutToWin(g) == 19 || aboutToWin(g) == 20) {
				int returnvalue = aboutToWin(g);
				return returnvalue - 14;
			}
			//if red is allowed to win
			else if(aboutToWin(g) == 7 || aboutToWin(g) == 8 || aboutToWin(g) == 9 || aboutToWin(g) == 10 || aboutToWin(g) == 11 || aboutToWin(g) == 12 || aboutToWin(g) == 13) {
				int returnvalue = aboutToWin(g);
				return returnvalue - 7;
			}
			else {
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
		}
		
	}

	public String getName() {
		return "John's AI";
	}
}