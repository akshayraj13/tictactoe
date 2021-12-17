import java.util.Scanner;

import data.Data;
import entity.Game;
import entity.User;

public class Demo {
	Scanner sc = new Scanner(System.in);
	Data data = Data.getData();
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.registerUsers();
		Game game = new Game();
		game.startGame();

	}
	private void registerUsers() {
		while(true) {
			System.out.println("Enter 1 to add user, else press 0");
			int val = sc.nextInt();
			if(val == 0)
				break;
			registerUser();
		}
	}
	private void registerUser() {
		System.out.println("Enter user details: ");
		System.out.println("Enter User Name: ");
		String name = sc.next();
		User user = new User(name);
		System.out.println("User " + name + " is created with this id: " + user.getId());
		System.out.println("Remember the id to play the game");
		data.addUser(user);
	}

}
