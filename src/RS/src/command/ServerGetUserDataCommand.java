package command;

import beans.MyInfo;

import java.util.List;

import beans.EncryptContact;

public class ServerGetUserDataCommand extends Command {
	private MyInfo myInfo;
	private List<EncryptContact> EncryptedUsers;
	private int userGID;
	private String TcellIP; 
	private int listenPort; 
	private String pubkey ;
	public ServerGetUserDataCommand(int numCommand, int userGID, String TcellIP,int listenPort, String pubkey , List<EncryptContact> EncryptedUsers) {
		super(numCommand);
		this.userGID=userGID;
		this.TcellIP=TcellIP;
		this.listenPort=listenPort;
		this.pubkey=pubkey;
		this.EncryptedUsers = EncryptedUsers;

	}

	
	public int getUserGID() {
		return userGID;
	}


	public void setUserGID(int userGID) {
		this.userGID = userGID;
	}


	public String getTcellIP() {
		return TcellIP;
	}


	public void setTcellIP(String tcellIP) {
		TcellIP = tcellIP;
	}


	public int getListenPort() {
		return listenPort;
	}


	public void setListenPort(int listenPort) {
		this.listenPort = listenPort;
	}


	public String getPubkey() {
		return pubkey;
	}


	public void setPubkey(String pubkey) {
		this.pubkey = pubkey;
	}


	public MyInfo getMyInfo() {
		return myInfo;
	}


	public void setMyInfo(MyInfo myInfo) {
		this.myInfo = myInfo;
	}


	public List<EncryptContact> getEncryptedUsers() {
		return EncryptedUsers;
	}


	public void setEncryptedUsers(List<EncryptContact> EncryptedUsers) {
		this.EncryptedUsers = EncryptedUsers;
	}
}
