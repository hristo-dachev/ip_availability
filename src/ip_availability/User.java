package ip_availability;

import java.net.Socket;

public class User {
	private String username;
	private Integer loginCounter;
	private boolean isLogged;
	private Socket usedSocket;
	
	public User(String username, Socket socket) {
		this.username = username;
		this.loginCounter = 0;
		this.isLogged = false;
		this.usedSocket = socket;
	}
	
	public String login(){
		
	}
	
	public String logout(){
		
	}
	
}