package data;

import java.util.HashMap;
import java.util.Map;

import entity.User;

public class Data {
	private static Data data;
	private Map<String, User> userDB = new HashMap<String, User>();

	private Data() {

	}
	
	public static Data getData() {
		if(data == null)
			data = new Data();
		return data;
	}
	public void addUser(User user) {
		userDB.put(user.getId(), user);
	}
	
	public User getUser(String id) {
		return userDB.get(id);
	}
	
	
}
