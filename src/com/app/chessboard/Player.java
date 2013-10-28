package com.app.chessboard;

import java.util.List;

/**
 * Player.java
 * Purpose : Template that can serve for players like Knight, Queen etc.
 * @author srirama
 *
 */
public interface Player {

	/**
	 * Abstract method to get valid moves for a given player.
	 * @return list of integers.
	 */
	public List<List<Integer>> getValidPositions();
	
	
	/**
	 * Abstract method to provide moves for a player.
	 * @throws Exception
	 */
	public void move() throws Exception;
}
