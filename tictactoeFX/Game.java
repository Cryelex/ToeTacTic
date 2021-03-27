package tictactoeFX;

import java.util.Stack;

import solver.SolverImpl;
import solver.TicTacToeSolver;

public class Game {
	private TicTacToeSolver oPlayer;
	boolean victoryExists = false;
	Stack<MoveImpl> mstackF = new Stack<MoveImpl>();
	Stack<MoveImpl> mstackB = new Stack<MoveImpl>();

	public enum Turn {
		X, O
	};

	private Turn turn;
	private Character[][] board;
	
	public Character[][] getboard(){
		return board;
	}
	
	public boolean undo() {
		if (mstackF.empty() == false && getTurn() == Turn.X) {
			MoveImpl oMove = mstackF.pop();
			MoveImpl myMove = mstackF.pop(); //remove text in the box and u r good future ted
			board[oMove.getRow()][oMove.getCol()] = ' ';
			board[myMove.getRow()][myMove.getCol()] = ' ';
			mstackB.add(oMove);
			mstackB.add(myMove);
			victoryExists=false;
		}
		
		if (mstackF.empty() == false && getTurn() == Turn.O) {
			MoveImpl myMove = mstackF.pop();
			board[myMove.getRow()][myMove.getCol()] = ' ';
			mstackB.add(myMove);
			victoryExists=false;
			turn=Turn.X;
		}
		
		return false;
	}
	
	public boolean redo() {
		System.out.print(mstackB.size());
		if (mstackB.empty() == false && mstackB.size()%2 == 0) {
			MoveImpl myMove = mstackB.pop();
			MoveImpl oMove = mstackB.pop();
			makePlayerMove(myMove.getRow(),myMove.getCol());
			makeForceMove(oMove.getRow(),oMove.getCol());
			
		} else if (mstackB.empty() == false && mstackB.size()%2 == 1) {	
			MoveImpl myMove = mstackB.pop();
			makePlayerMove(myMove.getRow(),myMove.getCol());
			turn =Turn.X;
		}
		return false;
	}

	public Game() {
		oPlayer = new SolverImpl();
		turn = Turn.X;
		board = new Character[3][3];
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				board[row][col] = ' ';
	}

	public boolean makePlayerMove(int row, int col) {
		if (board[row][col] == ' ') {
			board[row][col] = 'X';
			mstackF.add(new MoveImpl(row,col,turn));
			turn = Turn.O;
			return true;
		}
		return false;
	}

	public Coordinate makeAutoMove() {
		Coordinate oSquare = oPlayer.getMove('O', turn, board);
		int row = oSquare.getRow();
		int col = oSquare.getCol();
		board[row][col] = 'O';
		mstackF.add(new MoveImpl(row,col,turn));
		turn = Turn.X;
		mstackB.clear();
		if (!oPlayer.checkForVictory('O', board)) {
		}
		return oSquare;
	}
	
	public Coordinate makeForceMove(int row, int col) {
		Coordinate oSquare = new Coordinate(row,col);
		board[row][col] = 'O';
		mstackF.add(new MoveImpl(row,col,turn));
		turn = Turn.X;
		if (!oPlayer.checkForVictory('O', board)) {
			turn = Turn.X;
		}
		return oSquare;
	}

	public boolean boardFull() {
		for (int rowCounter = 0; rowCounter < board.length; rowCounter++)
			for (int colCounter = 0; colCounter < board[0].length; colCounter++)
				if (board[rowCounter][colCounter] == ' ')
					return false;
		return true;
	}

	public boolean gameOver() {
		if (oPlayer.checkForVictory('O', board) || oPlayer.checkForVictory('X', board)) {
			victoryExists = true;
			return true;
		}
		if (boardFull())
			return true;
		return false;

	}

	public boolean getVictoryExists() {
		return victoryExists;
	}

	public Coordinate[] getVictoryCoords() {
		return oPlayer.getVictoryCoords();
	}

	public Turn getTurn() {
		return turn;
	}
}
