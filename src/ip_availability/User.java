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
	
	public boolean getIsLogged() {
		return this.isLogged;
	}
	
	public String login(){
		this.isLogged = true;
		this.loginCounter++;
		return "ok";
	}
	
	public String logout(){
		this.isLogged = false;
		return "ok";
	}
	
	public String info(){
		StringBuilder info = new StringBuilder();
		info.append("ok:" + this.username + ":"	+ this.isLogged	+ ":" + this.loginCounter);
		return info.toString();
	}
	
}
