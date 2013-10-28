package com.app.chessboard;

/**
 * InvalidPositionException.java
 * Purpose : Custom exception used when the starting point is invalid or beyond the limits of Chess Board.
 * @author srirama
 */

@SuppressWarnings("serial")
public class InvalidPositionException extends Exception{
	
	  public InvalidPositionException(String message){
		     super(message);
		  }
}
