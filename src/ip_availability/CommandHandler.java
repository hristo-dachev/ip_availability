package ip_availability;

import java.net.Socket;




public class CommandHandler {
	private Socket socket;
	
	public CommandHandler(Socket socket) {
		this.socket = socket;
	}
	
	public String start(String[] line){
		//switch
		switch (line[0]) {
		case "login":
			return this.login(line);
			break;
		case "logout":
			return this.logout(line);
			break;
		case "info":
			return this.info(line);
			break;
		case "listavaliable":
			return this.listavaliable(line);
			break;
		case "shutdown":
			//stop server
			break;
		default:
			return "error:unknown command";
			break;
		}
	}
		
	public String[] parse(String input) {
		return input.split(":");
	}
	
	public String login(String[] line){
		
	}
	
	public String logout(String[] line){
		
	}
	
	public String info(String[] line){
		
	}
	
	public String listavaliable(String[] line){
		
	}
}
