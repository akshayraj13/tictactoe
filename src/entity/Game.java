package entity;

import exceptions.InvalidMoveException;
import service.GameService;

public class Game {
	private Player p1, p2, winningPlayer = null;
	GameBoard gameboard;
	private int count;
	private int minMoveToWin = 5;
	GameService gs = new GameService();

	public Game() {
		this.count = 0;
	}

	public void startGame() {
		gameboard = new GameBoard();
		Player[] players = gs.getPlayerDetails();
		p1 = players[0];
		p2 = players[1];
		startPlaying();
	}

	public void startPlaying() {
		System.out.println("Welcome " + p1.getUser().getName() + ", " + p2.getUser().getName() +" to the game!!");
		Player player = null;
		try {
			while (count < 9) {
				gameboard.printGameBoard();
				System.out.println("Count: " + count);
				player = count % 2 == 0 ? p1 : p2;
				
				count++;
				System.out.println(player.getUser().getName() + " make your move: ");
				int[] moves = gs.getMove();

				player.makeMove(moves[0], moves[1], gameboard);
				if(count >= minMoveToWin) {
					if(gameboard.gameWon(moves[0], moves[1], player.getNum())) {
						winningPlayer = player;
						break;
					}
				}
				
			}
			if(winningPlayer == null) {
				System.out.println("Game Drawn!!");
			}
			else {
				System.out.println("Yooo: " + winningPlayer.getUser().getName() + " won !!");
			}
		} catch (InvalidMoveException ex) {
			count--;
			startPlaying();
			System.out.println(ex);

		}
	}

}
