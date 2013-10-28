package com.app.chessboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Knight.java
 * Purpose : 
 * @author srirama
 *
 */

public class Knight implements Player {
	
	public ChessBoard chessBoard;                 // ChessBoard object.
	private int count = Integer.MAX_VALUE;        // Variable for storing least count from Starting to Ending position.
	private static int currentCount = 0; 
	private	List<List<Integer>> traverse = new ArrayList<List<Integer>>(); 
	private	List<List<Integer>> leastMovesPath = new ArrayList<List<Integer>>();  //List of ArrayList to store the path with least moves.
	private static List<List<Integer>> visited = new ArrayList<List<Integer>>();  //Store the list of visited positions.

	/**
	 * Constructor for Knight class
	 * @param cb
	 */
	public Knight (ChessBoard cb){
		this.chessBoard =cb;
	}
	
	/**
	 * This method is used to store the path in which Knight can reach destination in least number of moves.
	 * @param leastMovesPath
	 */
	private void setPath(List<List<Integer>> leastMovesPath) {
		this.leastMovesPath = leastMovesPath;
	}
	
	/**
	 * This method returns the least moves path to destination.
	 * @return least moves route to destination as a list of arraylist of integers.
	 */
	public List<List<Integer>> getLeastMovesPath() {
		return leastMovesPath;
	}
	

	/**
	 *  This method checks if a given position is already visited.
	 * @param position : List of x and y positions.
	 * @return true if a position is already visited, else false.
	 */
	private boolean isVisited(List<Integer> position){
		return visited.contains(position);
	}
	
	 /**
	  * This method is used to check if user input is beyond the size of the Chess board.
	 * @return true if the user input is within the limitations of Chess board, else false.
	 */
	private boolean isInvalid(){
		if(  chessBoard.getxPosition() > chessBoard.getSize() || chessBoard.getyPosition() > chessBoard.getSize()   
		  || chessBoard.getxPosition() < 0   || chessBoard.getyPosition() <0 )
			return true;
		return false;
	}
	
	/**
	 * This method adds a given position to the visited list.
	 * @param position : List of x and y positions that was visited by the player.
	 */
	private void addToVisited(List<Integer> position){		
		visited.add(position);
	}
	
	/**
	 * This method is used to find the least number of steps to reach destination from the starting point.
	 * return nothing.
	 */
	private void setLeastCountPath(){

		List<List<Integer>> validPositions = new ArrayList<List<Integer>>() ;
		validPositions = getValidPositions();

		for(List<Integer> position : validPositions){
			
			 if(chessBoard.isDestination(position)){
				 currentCount++;
				 traverse.add(position);
				 if(currentCount<count){
				 count = currentCount;
				 setPath(new ArrayList<List<Integer>>(traverse));
				 traverse.clear();
				 currentCount=0;
				 return;
				 }
			 }
		}		
		for(List<Integer> position : validPositions){
			
			if(!isVisited(position)){
			setNewPosition(position.get(0), position.get(1));
			currentCount++;
			traverse.add(position);
			addToVisited(position);
			setLeastCountPath();				 
			}						
		}
}

	/**
	 * This method is used to set the new position of the player.
	 * @param newX : New x position of the player.
	 * @param newY : New y position of the player.
	 */
	private void setNewPosition(int newX, int newY) {
		chessBoard.setxPosition(newX);
		chessBoard.setyPosition(newY);
	}

	/* 
	 * For the current position of the player, returns the list of valid positions/moves within the Chess Board. 
	 * 
	 * returns List of List of the valid possible positions.
	 */
	@Override
	public List<List<Integer>> getValidPositions() {
        List<List<Integer>> positions = new ArrayList<List<Integer>>();
		
		if( (chessBoard.getxPosition()+1 <= chessBoard.getSize()) && (chessBoard.getyPosition()+2 <= chessBoard.getSize()) )
			positions.add(Arrays.asList(chessBoard.getxPosition()+1,chessBoard.getyPosition()+2));
		
		if( (chessBoard.getxPosition()+2 <= chessBoard.getSize()) && (chessBoard.getyPosition()+1 <= chessBoard.getSize()) )
			positions.add(Arrays.asList(chessBoard.getxPosition()+2,chessBoard.getyPosition()+1));
		
		if( (chessBoard.getxPosition()-1 > 0)  && (chessBoard.getyPosition()-2 > 0) )			
			positions.add(Arrays.asList(chessBoard.getxPosition()-1,chessBoard.getyPosition()-2));
		
		if( (chessBoard.getxPosition()-2 > 0)  && (chessBoard.getyPosition()-1 > 0) )
			positions.add(Arrays.asList(chessBoard.getxPosition()-2,chessBoard.getyPosition()-1));

		if( (chessBoard.getxPosition()+2 <= chessBoard.getSize()) && (chessBoard.getyPosition()-1 > 0) )
			positions.add( Arrays.asList(chessBoard.getxPosition()+2,chessBoard.getyPosition()-1));

		if( (chessBoard.getxPosition()-2 > 0) && (chessBoard.getyPosition()+1 <= chessBoard.getSize()) )			
			positions.add(Arrays.asList(chessBoard.getxPosition()-2,chessBoard.getyPosition()+1));

		if( (chessBoard.getxPosition()+1 <= chessBoard.getSize()) && (chessBoard.getyPosition()-2 > 0) )
			positions.add(Arrays.asList(chessBoard.getxPosition()+1,chessBoard.getyPosition()-2));

		if( (chessBoard.getxPosition()-1 > 0)  && (chessBoard.getyPosition()+2 <= chessBoard.getSize()) )			
			positions.add(Arrays.asList(chessBoard.getxPosition()-1,chessBoard.getyPosition()+2));
		
		return positions;
	}
	
	/**
	 * This methods prints the least moves path from Starting point to destination. This method also prints the count of
	 * least moves.
	 * 
	 */
	public void printPath(){
		
		if(chessBoard.isDestination(chessBoard.getInitialPosition()) || getValidPositions().size() == 0 || isInvalid() )
			return;
		
		System.out.println("The path in which knight starting at " + chessBoard.getInitialPosition() + " can reach " 
							+ "[" +chessBoard.getSize() + "," + chessBoard.getSize()+ "]" + " is" );
		
		System.out.println("--------------------------------------------------------------");
		
		System.out.print(chessBoard.getInitialPosition() + "-->");
		for(int i=0;i<leastMovesPath.size();i++){
			System.out.print(leastMovesPath.get(i));
			
			if(i!= leastMovesPath.size()-1)
				System.out.print("-->");
		}
		System.out.println();
		System.out.println("--------------------------------------------------------------");
		System.out.println("The count of moves is " + count);
	}

	/*
	 *  This methods throws 
	 *  InvalidPositionException : If the starting position is beyond the limits of Chess Board.
	 *  NoValidMovesException    : If the starting position has no valid moves within the boundaries of Chess Board.
	 *  
	 *  Move the player from starting position to the destination. 
	 */
	@Override
	public void move() throws Exception {
		
		if(isInvalid())
			throw new InvalidPositionException("(" + chessBoard.getxPosition()+"," +
												chessBoard.getyPosition() +")" + " is an invalid position for a " + 
												chessBoard.getSize() + " X " + chessBoard.getSize() + " Chess board.");
		
		if(getValidPositions().size() == 0)
			throw new NoValidMovesException("From " + "(" +chessBoard.getxPosition()+"," + 
											 chessBoard.getyPosition() +")" + " there are no valid moves and the " +
											 "destination cannot be reached.");

		if(chessBoard.isDestination(chessBoard.getInitialPosition())){
			count =0;
			System.out.println("Initial position and the destination are same, so number of moves is " + count);		
			return;
		}
			
		addToVisited(chessBoard.getInitialPosition());
		setLeastCountPath();
	}

}
