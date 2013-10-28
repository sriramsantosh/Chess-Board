package com.app.chessboard;

/**
 * @param args
 * Main.java
 * Purpose : Starting point of the application.
 * @author srirama
 */

public class Main {

	public static void main(String[] args) {
		Integer size = Integer.parseInt(args[0]);
		Integer x = Integer.parseInt(args[1]);
		Integer y = Integer.parseInt(args[2]);
		ChessBoard chessBoard = new ChessBoard(size,x,y);  //Passing size of Chess board, and initial position of the knight.
		Knight knight = new Knight(chessBoard);
		try {
			knight.move();  // Start moving the knight.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		knight.printPath();  //Print the Knight's path (if any).
	}

}
