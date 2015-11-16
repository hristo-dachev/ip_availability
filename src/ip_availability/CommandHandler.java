package ip_availability;

import java.net.Socket;



public class CommandHandler {
	private Socket socket;
	
	public CommandHandler(Socket socket) {
		this.socket = socket;
	}
	
	public String[] parse(String input) {
		return input.split(":");
	}
	
}
