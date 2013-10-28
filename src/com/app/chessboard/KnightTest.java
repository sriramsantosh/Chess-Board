package com.app.chessboard;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
/**
 * KnightTest.java
 * Purpose : To test the core functionalities and some boundary conditions.
 * @author srirama
 *
 */
public class KnightTest {
	
	public ChessBoard chessBoard;   // ChessBoard object.
	public Knight knight;			// Knight object.
		
    @Rule  
    public ExpectedException thrown = ExpectedException.none(); 
    
    /**
     * This method tests the move method if Knight class by passing a general input.
     * @throws Exception
     */
    @Test
    public void testSimple() throws Exception{
    		int x = 1;
    		int y = 1;
    		int leastMoves = 4;
    		chessBoard = new ChessBoard(3,x,y);
    		knight = new Knight(chessBoard);
    		knight.move();
    		assertTrue(knight.getLeastMovesPath().size() == leastMoves);
    	}
    		
	/**
	 * This test method checks if InValidPositionException is thrown for an invalid position input.
	 * @throws Exception
	 */
	@Test
	public void testInvalidPosition() throws Exception{
		chessBoard = new ChessBoard(3,1,5);
		thrown.expect(InvalidPositionException.class);
		knight = new Knight(chessBoard);	
		knight.move();
	}
	
	/**
	 * This test method checks if NoValidMethodException is thrown for a "no valid moves" input.
	 * @throws Exception
	 */
	@Test
	public void testNoMovesPosition() throws Exception{
		chessBoard = new ChessBoard(3,2,2);
		thrown.expect(NoValidMovesException.class);
		knight = new Knight(chessBoard);	
		knight.move();
	}

}
