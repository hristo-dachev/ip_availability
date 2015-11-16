package ip_availability;

import java.net.Socket;




public class CommandHandler {
	private Socket socket;
	
	public CommandHandler(Socket socket) {
		this.socket = socket;
	}
	
	public void start(){
		//switch
	}
		
	public String[] parse(String input) {
		return input.split(":");
	}
	
	public String login(){
		
	}
	
	public String logout(){
		
	}
	
	public String info(){
		
	}
	
	public String listavaliable(){
		
	}
}
