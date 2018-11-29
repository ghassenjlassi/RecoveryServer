package daemon;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import tools.Constants;

/**
 * Daemon in Server
 * 
 * @author Ghassen Jlassi, Adam Laarif
 */
public class ServerDaemon{
	public static void main(String[] args) throws IOException{

	ServerSocket server = null;
	try{
	server = new ServerSocket(Constants.PORT);
	System.out.println("Server Lisetining");
	while(1==1){
		System.out.println("waiting for connection");
		Socket clientSocket = server.accept();
		ServerConnectionManager  DSM= new ServerConnectionManager(clientSocket);
		DSM.start();
		
	}
	}catch (Exception ex) {
		ex.printStackTrace();
		server.close();
	}
	}
}