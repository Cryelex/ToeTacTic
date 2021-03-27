package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import solver.SolverImpl;
import tictactoeFX.Coordinate;
import tictactoeFX.Game.Turn;

public class SolverTest {

	@Test
	public final void testFirstMoveToCenterIfAvailable() {
		SolverImpl solver = new SolverImpl();
		Character[][] board = {{' ', ' ', 'X'}, {' ', ' ', ' '}, {' ', ' ', ' '}};
		Coordinate c = solver.getMove('O', Turn.O, board);
		assertEquals(c.getRow(), 1);
		assertEquals(c.getCol(), 1);
	}
	
	@Test
	public final void testTakeRowVictory() {
		SolverImpl solver = new SolverImpl();
		Character[][] board = {{'X', ' ', 'X'}, {' ', ' ', 'X'} ,{'O', ' ', 'O'}};
		Coordinate c = solver.getMove('O', Turn.O, board);
		assertEquals(c.getRow(), 2);
		assertEquals(c.getCol(), 1);
	}
	
	@Test
	public final void testTakeColVictory() {
		SolverImpl solver = new SolverImpl();
		Character[][] board = {{'O', 'X', ' '}, {'O', 'X', ' '}, {' ', ' ', 'X'}};
		Coordinate c = solver.getMove('O', Turn.O, board);
		assertEquals(c.getRow(), 2);
		assertEquals(c.getCol(), 0);
	}
	
	@Test
	public final void testTakeDiagVictory() {
		SolverImpl solver = new SolverImpl();
		Character[][] board = {{'O', 'X', 'O'}, {'X', 'O', ' '}, {' ', ' ', ' '}};
		Coordinate c = solver.getMove('O', Turn.O, board);
		assertEquals(c.getRow(), 2);
		assertEquals(c.getCol(), 0);
	}
	
	@Test
	public final void testPreventEnemyRowVictory() {
		SolverImpl solver = new SolverImpl();
		Character[][] board = {{' ', ' ', ' '}, {'O', ' ', ' '} ,{'X', ' ', 'X'}};
		Coordinate c = solver.getMove('O', Turn.O, board);
		assertEquals(c.getRow(), 2);
		assertEquals(c.getCol(), 1);
	}
	
	@Test
	public final void testPreventEnemyColVictory() {
		SolverImpl solver = new SolverImpl();
		Character[][] board = {{'X', ' ', 'O'}, {' ', ' ', 'X'} ,{'X', ' ', 'O'}};
		Coordinate c = solver.getMove('O', Turn.O, board);
		assertEquals(c.getRow(), 1);
		assertEquals(c.getCol(), 0);
	}
	
	@Test
	public final void testPreventEnemyDiagVictory() {
		SolverImpl solver = new SolverImpl();
		Character[][] board = {{'X', ' ', 'O'}, {'O', ' ', ' '} ,{'X', ' ', 'X'}};
		Coordinate c = solver.getMove('O', Turn.O, board);
		assertEquals(c.getRow(), 1);
		assertEquals(c.getCol(), 1);
	}
}
