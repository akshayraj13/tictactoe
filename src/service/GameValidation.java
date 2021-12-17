package service;

import entity.Player;

public interface GameValidation {
	public Player[] getPlayerDetails();
	public Player[] checkPlayerValidity(String p1Id, String p2Id);
}
