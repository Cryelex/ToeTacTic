package tictactoeFX;

public class Coordinate {
	int row;
	int col;
	
	public Coordinate(int rowIn, int colIn){
		row = rowIn;
		col = colIn;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;		
	}
}
