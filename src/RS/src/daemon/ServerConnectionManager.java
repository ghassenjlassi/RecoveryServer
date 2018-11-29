/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daemon;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import beans.Data;
import beans.EncryptContact;
import beans.FileDesc;
import beans.FileRead;
import beans.FileStored;
import beans.MyInfo;
import beans.User;
import command.Command;
import command.GetFileToShareCommand;
import command.GetUserCommand;

import command.StoreFileServerCommand;
import configuration.Configuration;
import cryptoTools.AsymmetricDecryption;
import cryptoTools.SymmetricDecryption;
import dao.ServerDAO;
import tools.Constants;
import tools.IOStreams;
import tools.SymKeyTools;
import tools.Tools;
import command.RecoverCommand;
import command.ServerGetUserDataCommand;


/**
 * ThreadServer in Server. It receives commands from clients and executes the
 * associated actions.
 *
 * @author Ghassen Jlassi , Adam laarif 
 *
 */
public class ServerConnectionManager extends Thread {
	Socket socket;
//	int userGID;

	public ServerConnectionManager(Socket s) {
		/**
		 * Creates a ThreadServer instance
		 * @param socket the client socket
		 * @param userGID the userGID of the TC
		 */
		this.socket = s;
		//this.userGID = userGID;
	}
	
	@Override
	public void run() {
		try {
			
			IOStreams ioStreams = new IOStreams(socket);
			Command cmd = readCommand(ioStreams);
			System.out.println("j'ai passé ");
			switch (cmd.getNumCommand()) {
			
			case Constants.CMD_STORE_FILE_SERVER:	

				byte[] receivedFile = Base64.decode(((StoreFileServerCommand) cmd).getFile());
				String gid = ((StoreFileServerCommand) cmd).getGid();
				writeReceivedFile(gid , receivedFile);
				if (ServerDAO.getInstance().isFileExists(gid))
					ServerDAO.getInstance().deleteByGID(gid);
				insertReceivedMetaData(cmd);
				//Send status
				ioStreams.getOutputStream().writeInt(Constants.OK);
				break;
				
			/******************GetUSERDATA*************************/	
				/****
				 * Ici censé faire un objet Myinfo mais je sais pas pourquoi ça pas passé et la socket le bloque donc 
				 * j'ai eu recour a décomposer l'objet myInfo
				 * 
				 * ********/
			case Constants.CMD_Server_Get_User_Data:
				
			//	MyInfo receivedUser = ((SendUserInfoCommand) cmd).getMyInfo();
				 int userGID = ((ServerGetUserDataCommand) cmd).getUserGID();
				 String TcellIP = ((ServerGetUserDataCommand) cmd).getTcellIP();
				 int listenPort = ((ServerGetUserDataCommand) cmd).getListenPort();
			     String pubkey = ((ServerGetUserDataCommand) cmd).getPubkey();
				List<EncryptContact> users = ((ServerGetUserDataCommand) cmd).getEncryptedUsers();
								
				if (!ServerDAO.getInstance().isUserExists(userGID))
					ServerDAO.getInstance().insertUserInfo(userGID, TcellIP, listenPort, pubkey);
			 	
				
				for (EncryptContact u : users){
					if (!ServerDAO.getInstance().isUserContactsExists(userGID, u.getEncryptedGID()))
						ServerDAO.getInstance().insertUserContacts(userGID, u);
				}
			
				ioStreams.getOutputStream().writeInt(Constants.OK_USER);
		 break;
				
				
				
				
				
				
			/***********************RESTORE ALL******************************/	
			 case Constants.CMD_RESTORE:
				 //get the user id
				 	int userID_F = ((RecoverCommand ) cmd).getUserID();				 	
					ArrayList<String> userFiles_F = ServerDAO.getInstance().getGidByUserID(userID_F);
					
					ArrayList<FileStored> files = new ArrayList<FileStored>();
					System.out.println("userfile.size = "+ userFiles_F.size() );
					for (int i = 0 ; i < userFiles_F.size() ; i++){
					//	System.out.println("boucle for j'ai entrer");
						//get files from the server
						files.add(getFileFromServer(userFiles_F.get(i)));
						System.out.println("j'ai ajouté le fichier");
					}
					MyInfo user = ServerDAO.getInstance().getUserByID(userID_F);
					List<EncryptContact> contact = ServerDAO.getInstance().getContactsByUserID(userID_F);

					
					
					
					Data data = new Data(files,contact,user);
					//System.out.println("data file "+files);
					ioStreams.getOutputStream().writeObject(data);
					


				 
			 break;
			 
			 
			 /*******************************share*******************************/
			 case Constants.CMD_GET_FILE_TO_SHARE:
				 	sendFileToShare(((GetFileToShareCommand) cmd).getFileGID(),ioStreams);
				 
				 	break;
				default: 	
				System.out.println("unknown command");
				break;
			}
			
			ioStreams.close();
			socket.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	

	
	
	/**
	 * Get the file from the server
	 * 
	 * @param the GID of the file
	 * @return IOException un objet de type FileStored qui contient la description du fichier et le path
	 */
	
	private FileStored getFileFromServer(String fileGID) {
		// TODO Auto-generated method stub
		FileStored FileToRecover = null;
		try {
			FileDesc fileDesc = ServerDAO.getInstance().getFileDescByGid(fileGID);
			Path path = Paths.get(fileDesc.fileID);
			byte[] file = Files.readAllBytes(path);	
			FileToRecover = new FileStored(fileDesc, Base64.encode(file)); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FileToRecover;
	}

	private void insertReceivedMetaData(Command cmd) {

		try {
			/**String strPrivKey = ServerDAO.getInstance(false).getMyInfo().getMyPrivKey();
			PrivateKey privKey = Tools.stringToPrivateKey(strPrivKey);
			String filePath = ((StoreFileCommand) cmd).getFilePath();
			String type = "STORE";
			String iv = ((StoreFileCommand) cmd).getIv();
			String sKey = ((StoreFileCommand) cmd).getsKey();
			byte[] encrSKey = Base64.decode(sKey);
			byte[] decSKey = AsymmetricDecryption.decryptBlockByBlock(encrSKey,privKey);
			String strDecryptSkey= Base64.encode(decSKey);
			String fileGID = userGID + "|" + filePath;
			String fileID = Configuration.getConfiguration().getProperty("tcellPath")+ Tools.getFileName(fileGID);
			//chemin absolut
			//fileID = new File(fileID).getAbsolutePath();*/
			int userID = ((StoreFileServerCommand) cmd).getUserID();
			String gid = ((StoreFileServerCommand) cmd).getGid();
			String command = ((StoreFileServerCommand) cmd).getCommand();
			String type = "STORE";
			String encrIv = ((StoreFileServerCommand) cmd).getIv();
			String StrEncryptedSkey =  ((StoreFileServerCommand) cmd).getSkey();

			ServerDAO.getInstance().insertFile(userID, gid, StrEncryptedSkey, encrIv, command);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void writeReceivedFile(String filePath, byte[] file) {
		 /**
		   * Writes the received file.
		   * @param 
		   * 		filePath the file's path
		   * @param 	
		   * 		file the file itself
		   */
		FileOutputStream fos;
		try {
			/* Creation of the received folder */
			String Serverpath = Constants.SERVER_Files_PATH;
			if (!Tools.createDir(Serverpath))
				return;

			/* Extract the file name from the path */
			String fileID = new File(filePath).getName();

			/* Write the file in the received folder */
			fos = new FileOutputStream(Serverpath+ fileID);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write(file);
			System.out.println("The file '" + Serverpath  + fileID + "' (" + file.length + " bytes) has been received successfully!");
			bos.close();
			fos.close();

		} catch (FileNotFoundException ex) {
			System.err.println("ERROR : file " + filePath + " not found");
			return;
		} catch (IOException ex) {
			System.err.println("ERROR : can not write the file " + filePath);
			return;
		}
	}
	
	public Command readCommand(IOStreams stream) {
		 /**
		   * readCommand Receives Command.
		   * @param ioStreams
		   * 				 an IOStreams object
		   */
		
		Command cmd = null;
		try {
		//	System.out.println(stream.getInputStream().readObject());
			cmd = (Command) stream.getInputStream().readObject();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cmd;
	}
	private void sendFileToShare(String fileGID, IOStreams ioStreams) {
		try {
			FileDesc fileDesc = ServerDAO.getInstance().getFileDescByGid(fileGID);
			Path path = Paths.get(fileDesc.fileID);
			byte[] file = Files.readAllBytes(path);
			FileStored fileToShare = new FileStored(fileDesc, Base64.encode(file)); 
			
			ioStreams.getOutputStream().writeObject(fileToShare);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
