package tictactoeFX;

import tictactoeFX.Game.Turn;

public class MoveImpl implements Move{
	int row;
	int col;
	Turn player;
	
	MoveImpl(int a, int b, Turn c){
		row = a;
		col = b;
		player = c;
	}
	
	@Override
	public int getRow() {
		return row;
	}

	@Override
	public int getCol() {
		return col;
	}

	@Override
	public Turn getPlayer() {
		return player;
	}

}
