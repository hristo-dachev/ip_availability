package ip_availability;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class User {
	private String username;
	private Integer loginCounter;
	private boolean isLogged;
	
	private List<Interval> loginInterval = new ArrayList<Interval>();
	
	public User(String username, Socket socket) {
		this.username = username;
		this.loginCounter = 0;
		this.isLogged = false;
	}
	
	public boolean getIsLogged() {
		return this.isLogged;
	}
	
	public String login(){
		if(this.isLogged) return "error:alreadylogged";
		this.isLogged = true;
		this.loginCounter++;
		this.loginInterval.add(new Interval(new Date()));
		return "ok";
	}
	
	public String logout(){
		if(!this.isLogged) return "error:notlogged";
		this.isLogged = false;
		this.loginInterval.get(this.loginInterval.size() - 1).setOut(new Date());
		return "ok";
	}
	
	public String info(){
		StringBuilder info = new StringBuilder();
		info.append("ok:" + this.username + ":"	+ this.isLogged	+ ":" + this.loginCounter);
		for (Interval temp_list: this.loginInterval) {
			info.append(":" + temp_list.from());
			if (temp_list.to() != null) info.append(":" + temp_list.to());
		}
		return info.toString();
	}
	
}
