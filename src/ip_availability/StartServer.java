package ip_availability;

import java.io.IOException;


public class StartServer {
	private static final Integer SERVER_PORT = 65535;
	
	public static void main(String[] args) throws IOException {
		final Server server = new Server(SERVER_PORT);
		server.startServer();
	}
}
