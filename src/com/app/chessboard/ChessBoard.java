package com.app.chessboard;

import java.util.Arrays;
import java.util.List;

/**
 * ChessBoard.java
 * Purpose : Define and set size, position, destination
 * @author srirama
 *
 */
public class ChessBoard {
	
	private int xPosition;  				// x-position of player.
	private int yPosition;					// y-position of player.
	private int size;						// Size of the Chess Board.
	private List<Integer> destination;		// Final desired destination.
	private List<Integer> initialPosition;  // Starting point of the player.

	/**
	 * Constructor for ChessBoard class.
	 * @param size : The size of the board.
	 * @param x : The x position of the knight.
	 * @param y : The y position of the knight.
	 */
	public ChessBoard(int size, int x, int y ){
		this.size =size;
		this.xPosition = x;
		this.yPosition = y;
		destination = Arrays.asList(this.size, this.size);
		initialPosition = Arrays.asList(this.xPosition,this.yPosition);
	}

	/**
	 * This method returns the size of the Chess board.
	 * @return size as integer value.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * This method returns the desired destination for the player.
	 * @return destination as an list of integers.
	 */
	public List<Integer> getDestination() {
		return destination;
	}

	/**
	 * This method returns current x position of the player.
	 * @return position of x as integer value.
	 */
	public int getxPosition() {
		return xPosition;
	}

	/**
	 * This method sets the x position for a player
	 * @param x_position
	 */
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * This method returns current y position of the player. 
	 * @return position of y as integer value.
	 */
	public int getyPosition() {
		return yPosition;
	}

	/**
	 * This method is a setter for the Y_position of the player.
	 * @param yPosition : The Y position of the player.	
	 */
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	/**
	 * This method gives the starting position for the player.
	 * @return the initial position as an integer.
	 */
	public List<Integer> getInitialPosition() {
		return initialPosition;
	}

	/**
	 * This method sets the initial position.
	 * @param initialPosition
	 */
	public void setInitialPosition(List<Integer> initialPosition) {
		this.initialPosition = initialPosition;
	}

	/**
	 * This method checks if a given position is same as the destination
	 * @param position : List of integers with x and y position.
	 * @return true if given position and destination are same.
	 */
	public boolean isDestination(List<Integer> position){
		return position.equals(destination);
	}
}
