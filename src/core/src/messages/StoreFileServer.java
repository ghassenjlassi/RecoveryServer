package messages;

import java.net.Socket;
import java.security.PublicKey;

import javax.crypto.SecretKey;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import beans.User;
import command.StoreFileCommand;
import command.StoreFileServerCommand;
import configuration.Configuration;
import cryptoTools.AsymmetricEncryption;
import tools.Constants;
import tools.IOStreams;
import tools.SymKeyTools;
import tools.Tools;

public class StoreFileServer {
	


		public static void storeFileServer(String file, String fileName, String skey, String iv, User user, String command){

			/**
			 * Establishes the connection with the TCELL and send to file with the store message.
			 * @param fileToSendPath the path of the file to send
			 * @param user the addressee user
			 */
			try {
				/* The socket used to send the file and the messages */
				Socket socket;

				/* Extract the fileName from the path */
				//String fileName = Tools.getFileName(fileToSendPath);

				System.out.println("File is being sent to TCell...");

				/* Creates a stream socket and connects it to the specified port number at the specified IP address */
				socket = new Socket("127.0.0.1", Constants.PORT);

				/* Creation of the stream */
				IOStreams stream = new IOStreams( socket );
				
				int userID = user.getUserGID();
				String gid = userID + "|" + fileName;

				StoreFileServerCommand serverSaveFileCmd= new StoreFileServerCommand(Constants.CMD_STORE_FILE_SERVER, file, gid, skey, iv, userID, command);

				//send command
				stream.getOutputStream().writeObject(serverSaveFileCmd);
				
				//recieve status from the server
				int status = stream.getInputStream().readInt();
				Tools.interpretStatus( status );

				stream.close();
				socket.close();

			} catch (Exception ex) {
				System.err.println("ERROR : store file has failed");
			}
		}

}
