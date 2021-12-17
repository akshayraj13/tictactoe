package entity;

import java.util.UUID;

public class User {
	
	private String id;
	private String name;
	
	public User(String name) {
		this.name = name;
		this.id = UUID.randomUUID().toString();
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	
	
}
