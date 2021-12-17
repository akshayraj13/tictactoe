package entity;

import exceptions.InvalidMoveException;

public class GameBoard {
	private int [][] grid = null;

	public GameBoard() {
		grid = new int[3][3];
		resetGameBoard();
	}
	
	private void resetGameBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				grid[i][j] = -1;
			}
		}
	}
	
	public void addNum(int i, int j, int val) throws InvalidMoveException {
		if(grid[i][j] == -1) {
			grid[i][j] = val;
		}
		else {
			throw new InvalidMoveException();
		}
	}
	
	public boolean gameWon(int i, int j, int val) {
		boolean temp = true;
		temp = checkRow(i,val) || checkCol(j,val);
		if((i == 0 && j == 0 ) || (i == 2 && j == 2 ))
			temp = temp || checkNegativeDiagonal(val);
		else if((i == 2 && j == 0 ) || (i == 0 && j == 2 ))
			temp = temp || checkPositiveDiagonal(val);
		else if(i==1 && j==1)
			temp = temp || checkPositiveDiagonal(val) || checkNegativeDiagonal(val);
		return temp;
	}
	private boolean checkRow(int row, int val) {
		if(grid[row][0] == val && grid[row][1] == val && grid[row][2] == val )
			return true;
		return false;
	}
	private boolean checkCol(int col, int val) {
		if(grid[0][col] == val && grid[1][col] == val && grid[2][col] == val )
			return true;
		return false;
	}
	private boolean checkNegativeDiagonal(int val) {
		if(grid[0][0] == val && grid[1][1] == val && grid[2][2] == val )
			return true;
		return false;
	}
	private boolean checkPositiveDiagonal(int val) {
		if(grid[2][0] == val && grid[1][1] == val && grid[0][2] == val )
			return true;
		return false;
	}
	
	public void printGameBoard() {
		System.out.println("*****************************");
		for(int i = 0; i < 3; i++) {
			System.out.print("|");
			for(int j = 0; j < 3; j++) {
				System.out.print(grid[i][j] + " | ");
				//grid[i][j] = -1;
			}
			System.out.println();
		}
		System.out.println("*****************************");
	}
	
}
