package ip_availability;

import java.io.IOException;
import java.net.Socket;




public class CommandHandler {
	private Socket socket;
	
	public CommandHandler(Socket socket) {
		this.socket = socket;
	}
	
	public String start(String[] line, Server server) throws IOException{
		//switch
		switch (line[0]) {
		case "login":
			return this.login(line);
		case "logout":
			return this.logout(line);
		case "info":
			return this.info(line);
		case "listavaliable":
			return this.listavaliable(line);
		case "shutdown":
			server.stopServer();
		default:
			return "error:unknown command";
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
