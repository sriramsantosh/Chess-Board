package com.app.chessboard;

/**
 * NoValidMovesException.java
 * Purpose : Custom exception used when there are 0 valid moves.
 * @author srirama
 *
 */
@SuppressWarnings("serial")
public class NoValidMovesException extends Exception {

	  public NoValidMovesException(String message){
		     super(message);
		  }
}
