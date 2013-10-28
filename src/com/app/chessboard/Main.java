package com.app.chessboard;

/**
 * @param args
 * Main.java
 * Purpose : Starting point of the application.
 * @author srirama
 */

public class Main {

	public static void main(String[] args) {
		Integer x = Integer.parseInt(args[0]);
		Integer y = Integer.parseInt(args[1]);
		ChessBoard chessBoard = new ChessBoard(5,x,y);  //Fixing the size of the board to 3 and passing x and y positions of Knight.
		Knight knight = new Knight(chessBoard);
		try {
			knight.move();  // Start moving the knight.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		knight.printPath();  //Print the Knight's path (if any).
	}

}
