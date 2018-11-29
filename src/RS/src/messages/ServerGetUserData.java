package messages;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

import beans.EncryptContact;
import beans.MyInfo;
import command.Command;
import command.ServerGetUserDataCommand;
import tools.Constants;
import tools.IOStreams;
import tools.Tools;
/**
 * Class afin d'envoyer les informations de user
 *
 * @authorGhassen Jlassi, Adam Laarif
 *
 */
public class ServerGetUserData {
	public static void sendUserInfo(int userGID, String TcellIP,int listenPort, String pubkey , List<EncryptContact> EncryptedUsers){

		try {
			
			// socket connection to the RS
			Socket socketServer = new Socket("127.0.0.1", Constants.PORT);
			IOStreams streamServer = new IOStreams(socketServer);
			
			Command sendUserInfoCommand = new ServerGetUserDataCommand(Constants.CMD_Server_Get_User_Data, userGID, TcellIP, listenPort, pubkey , EncryptedUsers);
		
			System.out.println(sendUserInfoCommand);
			streamServer.getOutputStream().writeObject(sendUserInfoCommand);
			

			int statusServer = streamServer.getInputStream().readInt();
			Tools.interpretStatusServer( statusServer );
			streamServer.close();
			socketServer.close();
									
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("Error sendUserInfo to the RS ..");
		} 
	}
}
