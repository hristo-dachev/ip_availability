package ip_availability;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class Client implements Runnable {
	private Socket socket;
	private Server Server;
	private CommandHandler commandLine;
	
	public Client(Socket socket, Server Server) {
		this.socket = socket;
		this.Server = Server;
		this.commandLine = new CommandHandler(socket);
	}
	
	@Override
	public void run() {
		try {
			final PrintStream out = new PrintStream(socket.getOutputStream());
			final Scanner scanner = new Scanner(socket.getInputStream());
			
			while(scanner.hasNextLine()){
				out.println(commandLine.start(commandLine.parse(scanner.nextLine()), Server));
			}
			scanner.close();
			out.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} finally {
			Server.onClientStopped(this);
		}
	}
	
	public void stopClient() throws IOException {
		socket.close();
	}
	
}
