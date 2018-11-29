package apps;

import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

import tools.Constants;
import api.ClientAPI;
import beans.User;
import configuration.Configuration;
import cryptoTools.KeyManager;



public class AppMain 
{
	/**
	 * APP Main
	 * 
	 * @author Majdi Ben Fredj
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		int userGID = Integer.parseInt(Configuration.getConfiguration().getProperty("myGID"));
		String tCellIP = Configuration.getConfiguration().getProperty("myIP");
		int port = Integer.parseInt(Configuration.getConfiguration().getProperty("myPort"));
		Scanner sc = new Scanner(System.in);
		User user= null;

		// load user PubKey
		try {
			String KeyPath = Configuration.getConfiguration().getProperty("keyPath");
			KeyManager keygen = new KeyManager();
			String publicKeyPath = KeyPath + Constants.PUB_KEY_PREFIX + userGID + Constants.KEY_EXT;
			PublicKey pubKey = keygen.LoadPublicKey(publicKeyPath, Constants.RSA_ALG);
			String pubkey = keygen.PublicKeyToString(pubKey);

			user = new User(userGID, tCellIP, port, pubkey);
			
		} catch (Exception e) {
			e.printStackTrace();
		}


		//ClientAPI.storeFile("/home/user/SIPD/machines/Client10/Image.jpg", user);
		//System.out.println(userGID);
		// TEST GETFILEDESC
	//	ClientAPI.getFileDesc(user);
		// TEST READFILE
		ClientAPI.readFile("10|/home/user/SIPD/machines/Client10/TMP/Encrypted_Image.jpg", user);
		//TEST SHAREFILE
		//if(userGID==10)
		//	ClientAPI.shareFile("10|/home/user/SIPD/machines/Client10/TMP/Encrypted_Image.jpg", 11, user);
	//	System.out.println("Dooooone");
	//System.out.println("donner le path de la clé");
	 // String str = sc.nextLine();      
	  //ClientAPI.recover(str, user);
		
	}
}