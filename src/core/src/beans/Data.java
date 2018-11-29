package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Une classe afin de récupérer tout les informations pour pouvoirs les envoyés aux tcells
 * 
 * */
public class Data implements Serializable {

	private ArrayList<FileStored> files;
	private List<EncryptContact> contacts;
	private MyInfo user;
	
	public ArrayList<FileStored> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<FileStored> files) {
		this.files = files;
	}
	
	public List<EncryptContact> getContacts() {
		return contacts;
	}

	public void setContacts(List<EncryptContact> contacts) {
		this.contacts = contacts;
	}

	public MyInfo getUser() {
		return user;
	}

	public void setUser(MyInfo user) {
		this.user = user;
	}

	public Data(ArrayList<FileStored> files, List<EncryptContact> contacts, MyInfo user) {
		super();
		this.files = files;
		this.contacts = contacts;
		this.user = user;
	}
}
