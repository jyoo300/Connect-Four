package ConnectFour;

public class CFGame {
  //state[i][j]= 0 means the i,j slot is empty
  //state[i][j]= 1 means the i,j slot has red
  //state[i][j]=-1 means the i,j slot has black
  private final int[][] state;
  private boolean isRedTurn;
  
  {
    state = new int[6][7];
    for (int i = 0; i < 6; i++)
      for (int j = 0; j < 7; j++)
        state[i][j] = 0;
    isRedTurn = true; //red goes first
  }

  public int[][] getState() {
    int[][] ret_arr = new int[6][7];
    for (int i = 0; i < 6; i++)
      for (int j = 0; j < 7; j++)
        ret_arr[i][j] = state[i][j];
    return ret_arr;
  }
  
  public boolean isRedTurn() {
    return isRedTurn;
  }
  
  public boolean play(int column) {
    //outofbounds
    if(column < 0 || column > 6) {
      return false;
    }
    boolean empty = false;
    int count = 0;
    for (int i = 5; i >= 0; i--) {
      if(state[i][column] == 0) {
        count = i;
        empty = true;
        break;
      }
    } 
    //if column has at least one empty spot
    if(empty == true) {
      if(isRedTurn == true) {
        state[count][column] = 1;
        isRedTurn = false;
      }
      else if (isRedTurn == false) {
        state[count][column] = -1;
        isRedTurn = true;
      }
    }  
    if(empty == false) {
        return false;
    } 
    return true;     
  }
  
  public boolean isGameOver() {
    if(winner() == 0 || winner() == -1 || winner() == 1) 
      return true;
    return false;
  }
  
  public int winner() {
    int redcount = 0;
    int blackcount = 0;
    //Vertical winning position
    for(int j = 0; j < 7; j++) {
      for(int i = 5; i > 2; i--) {
         if(state[i][j] == 1 && state[i-1][j] == 1 && state[i-2][j] == 1 && state[i-3][j] == 1) {
              redcount = 4;
              break;
          }
          else if(state[i][j] == -1 && state[i-1][j] == -1 && state[i-2][j] == -1 && state[i-3][j] == -1) {
              blackcount = 4;
              break;
          }
      }
      if(redcount == 4) 
        return 1;
      if(blackcount == 4) 
        return -1;
    }
    
    //Horizontal winning position
    for(int i = 5; i >= 0; i--) {
      for(int j = 0; j < 4; j++) {
        if(state[i][j] == 1 && state[i][j+1] == 1 && state[i][j+2] == 1 && state[i][j+3] == 1) {
              redcount = 4;
              break;
          }
          else if(state[i][j] == -1 && state[i][j+1] == -1 && state[i][j+2] == -1 && state[i][j+3] == -1) {
              blackcount = 4;
              break;
          }
      }
      if(redcount == 4) 
        return 1;
      if(blackcount == 4) 
        return -1;
      }
  
    
    //Diagonal down to up winning position
    blackcount = 0;
    redcount = 0;
    for (int j = 0; j < 4; j++) {
      for(int i = 5; i > 2; i--) {
          if(state[i][j] == 1 && state[i-1][j+1] == 1 && state[i-2][j+2] == 1 && state[i-3][j+3] == 1) {
              redcount = 4;
              break;
          }
          else if(state[i][j] == -1 && state[i-1][j+1] == -1 && state[i-2][j+2] == -1 && state[i-3][j+3] == -1) {
              blackcount = 4;
              break;
          }
      }
      if(redcount == 4) 
        return 1;
      if(blackcount == 4) 
        return -1;
    }

    //Diagonal up to down winning position
    blackcount = 0;
    redcount = 0;
    for (int j = 0; j < 4; j++) {
      for(int i = 0; i < 3; i++) {
          if(state[i][j] == 1 && state[i+1][j+1] == 1 && state[i+2][j+2] == 1 && state[i+3][j+3] == 1) {
              redcount = 4;
              break;
          }
          else if(state[i][j] == -1 && state[i+1][j+1] == -1 && state[i+2][j+2] == -1 && state[i+3][j+3] == -1) {
              blackcount = 4;
              break;
          }
      }
      if(redcount == 4) 
        return 1;
      if(blackcount == 4) 
        return -1;
    }
    
    boolean empty = false;
    for(int i = 0; i < 6; i++) {
      for(int j = 0; j < 7; j++) {
        if(state[i][j] == 0) 
          empty = true;
      }
    }
    //if not all the spots on the board have been filled
    if(empty == true) {
      return 99;
    }
    //draw
    return 0;
  }

}
