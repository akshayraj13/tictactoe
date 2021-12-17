package service;

import java.util.Scanner;

import data.Data;
import entity.Player;
import entity.User;

public class GameService implements GameValidation, GamePlay {
	Scanner sc = new Scanner(System.in);
	
	@Override
	public Player[] getPlayerDetails() {
		String p1Id, p2Id;
		System.out.println("Enter player details");
		System.out.println("Enter player1 id: ");
		p1Id = sc.nextLine();
		System.out.println("Enter player2 id: ");
		p2Id = sc.nextLine();
		Player[] players = new Player[2];
		
		
		players = checkPlayerValidity(p1Id,p2Id);
		
		return players;
	}

	@Override
	public Player[] checkPlayerValidity(String p1Id, String p2Id) {
		// TODO Auto-generated method stub
		System.out.println("Checking player details..");
		Data data = Data.getData();
		Player[] players = null;
		User u1 = data.getUser(p1Id);
		User u2 = data.getUser(p2Id);
		
		if( u1!= null && u2!= null) {
			players = new Player[2];
			players[0] = new Player(0, u1);
			players[1] = new Player(1, u2);
			System.out.println("Details are valid.. Game ready to start");
		}else {
			System.out.println("Validation failed, please enter the palyer details again...");
			getPlayerDetails();
		}
		return players;
	}

	@Override
	public int[] getMove() {
		int [] moves = new int[2];
		System.out.println("i: ");
		moves[0] = sc.nextInt();
		System.out.println("j: ");
		moves[1] = sc.nextInt();
		return moves;
	}
	
	
	

}
