package solver;

import tictactoeFX.Coordinate;
import tictactoeFX.Game;
import tictactoeFX.Game.Turn;

public interface TicTacToeSolver {
	public Coordinate getMove(char p, Turn turn, Character[][] board);
	public Coordinate[] getVictoryCoords();
	public boolean checkForVictory(char p, Character[][] board);
}
