package tictactoeFX;

import tictactoeFX.Game.Turn;

public interface Move {

	  // return the row number of the space occupied in the move
	  public int getRow();

	  // return the column number of the space occupied in the move
	  public int getCol();

	  //return the identity of the player who made the move.  Turn is an enum defined in the Game class.
	  public Turn getPlayer();

	}