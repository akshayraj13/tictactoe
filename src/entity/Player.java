package entity;

import exceptions.InvalidMoveException;

public class Player{
	
	private final int num;
	private User user;

	public Player( int num, User user) {
		this.num = num;
		this.user = user;
	}

	public int getNum() {
		return num;
	}
	
	public void makeMove(int i, int j, GameBoard gb) throws InvalidMoveException {
		gb.addNum(i, j, num);
	}

	public User getUser() {
		return user;
	}

}
