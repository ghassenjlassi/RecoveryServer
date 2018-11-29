package messages;

import java.net.Socket;
import java.security.PrivateKey;

import beans.Data;
import beans.FileDesc;
import beans.FileStored;
import beans.User;
import command.Command;
import command.RecoverCommand;
import command.SendFileToTcellCommand;
import cryptoTools.AsymmetricDecryption;
import cryptoTools.KeyGenerator;
import cryptoTools.KeyManager;
import tools.Constants;
import tools.IOStreams;
import tools.Tools;

import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * Une classe avec deux méthode une méthode de recover from server et une autre méthode pour envoyer les données à untcell
 * spécifique
  * */
public class Recovery {
	public static void recover_from_server(String PKPath, User user){
		try {	
			
			System.out.println("Recovery in progress.");

			Socket socket = new Socket("127.0.0.1",Constants.PORT);
			IOStreams stream = new IOStreams( socket );
			int USER_ID = user.getUserGID();	
			//Command recover = new Command		
		Command recover = new RecoverCommand(Constants.CMD_RESTORE, USER_ID);
		stream.getOutputStream().writeObject(recover);
		
		Data data = (Data) stream.getInputStream().readObject();
		
		send_to_tcell(data, PKPath, user);
		System.out.println("Recovery ended succesfully.");			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erreur recovering"+ e.getMessage());
		}
		
		
	}
	//saving file to be sent to the tcell
	public static void send_to_tcell(Data data, String PKPath, User user) {
		
		try {
		
			KeyGenerator keyGenarator = new KeyGenerator();
			PrivateKey privKey1 = keyGenarator.LoadPrivateKey(PKPath, Constants.RSA_ALG);
			
			KeyManager keyManager = new KeyManager();
			String privKeyString = keyManager.PrivateKeyToString(privKey1);
			
			PrivateKey privateKey = keyManager.StringToPrivateKey(privKeyString, Constants.RSA_ALG);

			for(int i =0; i< data.getFiles().size() ; i++) {
				

				String encryptedSkey = data.getFiles().get(i).getFileDesc().sKey; 
				String encryptedIv = data.getFiles().get(i).getFileDesc().iv;
				byte[] decSKey = AsymmetricDecryption.decryptBlockByBlock(Base64.decode(encryptedSkey),privateKey);
				byte[] decIv = AsymmetricDecryption.decryptBlockByBlock(Base64.decode(encryptedIv),privateKey);
				String DecryptSkey= Base64.encode(decSKey);
				String DecryptIv= Base64.encode(decIv);
				FileDesc fc = new FileDesc(data.getFiles().get(i).getFileDesc().fileID, DecryptSkey, DecryptIv, data.getFiles().get(i).getFileDesc().descr);
				FileStored fs = new FileStored(fc, data.getFiles().get(i).getFile());
				/**fonction afin d'envoyer les fichiers au tcell
				 * @param user
		         * @param fichier
				 * */
				SendFileToTcell(user,fs);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erreur saving file to be sent to the tcell " + e.getMessage());
		}
		
		
		//Send the table User et MYINFO
		int userGID = data.getUser().getMyGid();
		int	listenPort =data.getUser().getMyTcellPort();
		String	TcellIP=data.getUser().getMyTcellIp();
		String	pubkey =data.getUser().getMyPubKey();
	
		ServerGetUserData.sendUserInfo(userGID, TcellIP, listenPort, pubkey , data.getContacts());
		
	}

	private static void SendFileToTcell(User user, FileStored fs) {
		// TODO Auto-generated method stub

		try {
			Socket socket = new Socket(user.getTCellIP(), user.getPort());
			IOStreams stream = new IOStreams(socket);
			
			Command sendFileCommand = new SendFileToTcellCommand(Constants.CMD_SEND_FILE_TCELL, fs);
			stream.getOutputStream().writeObject(sendFileCommand);
			int status = stream.getInputStream().readInt();
			Tools.interpretStatus( status );

			stream.close();
			socket.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("erreur sending file to the tcell "+ex.getMessage());
		}
	}
	

}
