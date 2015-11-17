package ip_availability;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;







public class CommandHandler {
	private Socket socket;
	private Map<String, User> users = new HashMap<String, User>();
	
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
		if(!users.containsKey(line[1])){
			users.put(line[1], new User(line[1], socket));
		}
		return users.get(line[1]).login();
	}
	
	public String logout(String[] line){
		if(users.containsKey(line[1])){
			return users.get(line[1]).logout();
		}else return "error:notlogged";
	}
	
	public String info(String[] line){
		if(users.containsKey(line[1])){
			return users.get(line[1]).info();
		}else return "error:noinfo";
	}
	
	public String listavaliable(String[] line){
		if(users.containsKey(line[1])) {
			String string = "ok";
			for (Entry<String, User> entry : users.entrySet()) {
			    if(entry.getValue().getIsLogged()) 
			    	string += ":" + entry.getKey();
			}
			return string;
		} return "error:notlogged";
	}
}
