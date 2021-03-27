package solver;

import tictactoeFX.Coordinate;
import tictactoeFX.Game;
import tictactoeFX.Game.Turn;

public class RudimentarySolver implements TicTacToeSolver{

	@Override
	public Coordinate getMove(char p, Turn turn, Character[][] board) {
		Coordinate move = null;
		for(int row = 0; row < 3; row++)
			for(int col = 0; col < 3; col++)
				if(board[row][col] == ' ')
					return new Coordinate (row, col);
		return move;
	}

	@Override
	public boolean checkForVictory(char p, Character[][] board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Coordinate[] getVictoryCoords() {
		// TODO Auto-generated method stub
		return null;
	}

}
