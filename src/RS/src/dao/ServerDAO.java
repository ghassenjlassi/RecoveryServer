package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beans.EncryptContact;
import beans.FileDesc;
import beans.MyInfo;
import beans.User;
import command.StoreFileServerCommand;
import test.jdbc.Tools;
import tools.Constants;



/**
 * 
 * @author Ghassen Jlassi , Adam Laarif
 * 
 *  * the RS DB Manager.

 */
public class ServerDAO extends Tools{
	//private static int fileIdGlobal=0;
	int idFile = 0;
	int idUSERSINFO = 0;
	int idUserContacts = 0;
	private static ServerDAO instance = null;
	Connection cnx = null;
	
public ServerDAO() {
		
		try {
			Class.forName("org.sqlite.JDBC");
	        cnx = (Connection) DriverManager.getConnection("jdbc:sqlite:server_database.db");
	        System.out.println("ServerDatabase opned successfully ");
		} catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
	}
	
	// Renvoyer une instance de ServerDAOToken
		public static ServerDAO getInstance() {
			/**
			 * Server Creates a TCELL_DB instance
			 */

			if (instance == null) {
				synchronized (ServerDAO.class) {
					if (instance == null) {
						instance = new ServerDAO();
					}
				}
			}
			return instance;
		}

		public void CreateTables() {
			System.out.println("Create the tables RS");
			Statement statement = null;
			try {
				statement = cnx.createStatement();
				String sql = "CREATE TABLE FILE " +
		        		"(ID INT PRIMARY KEY     NOT NULL," +
	                    " UserID         INT     NOT NULL, "+
	                    " GID            TEXT    NOT NULL, "+ 
	                    " SKey           TEXT    NOT NULL, "+ //encrypted
	                    " IV             TEXT    NOT NULL, "+ //encrypted
	                    " COMMAND        TEXT    NOT NULL);"+
	                     "CREATE TABLE USERSINFO " +
	                     "(ID INT PRIMARY KEY     NOT NULL, " +
	                     " UserID         INT     NOT NULL, " + 
	                     " TcellIP        TEXT    NOT NULL, " + 
	                     " Port           INT     NOT NULL, " + 
	                     " PubKey         TEXT    NOT NULL);" + 
	                     "CREATE TABLE USERCONTACTS " +
	                     "(ID INT PRIMARY KEY     NOT NULL, " +
	                     " UserID         INT     NOT NULL, " + 
	                     " CUserID        TEXT    NOT NULL, " + 
	                     " CTcellIP       TEXT    NOT NULL, " + 
	                     " CPort          TEXT    NOT NULL, " + 
	                     " CPubKey        TEXT    NOT NULL);"  ;
		        
		        statement.executeUpdate(sql);
		        
		        System.out.println("Executing query : " + sql);	
		        
		        statement.close();
		        

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

	
			public void DropTables() throws SQLException {
				System.out.println("Drop the tables RS");
				Statement stmt = null;
				
				stmt = cnx.createStatement();
		        String sql = "DROP TABLE IF EXISTS FILE; DROP TABLE IF EXISTS USERSINFO; DROP TABLE IF EXISTS USERCONTACTS";
		        stmt.executeUpdate(sql);
		        
		        System.out.println("Executing query : " + sql);	
		        
		        stmt.close();
			}


	/**
	 * Inserts a file's description
	 * 
	 * @param string
	 *            the global id of the file
	 * @param fileID
	 *            the file id of the file
	 * @param sKey
	 *            the secret key used to encrypt the file
	 * @param iv
	 *            the initialization vector
	 * @param type
	 *            the type of the file (store or share)
	 * @param descr
	 *            the description of the file
	 * @throws Exception
	 */

	/**
	 * Inserts a user in the User table
	 * @param UserGID the user id
	 * @param TCellIP the TC's IP of the user
	 * @param PubKey the public key of the user
	 * @param tcellPort the TC's PORT of user
	 * @throws Exception
	 */

	
	/**
	 * Deletes a file in the db
	 * @param fileGID the fileGID of the file
	 * @throws Exception
	 */
	
	/**
	 * Deletes a user from the db
	 * @param userGID the userGID of the removed user
	 * @throws Exception
	 */
	/**
	 * check a file exist
	 * @param fileGID the fileGID of the file to check
	 * @throws Exception
	 */
	public boolean isFileExists(String gid) {
		boolean result = false;

		Statement stmt = null;
		
		try {
			stmt = (Statement) ((java.sql.Connection) cnx).createStatement();
			String query = "SELECT ID, GID FROM FILE WHERE GID = '" + gid +"'";
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Executing query : " + query);			
			if (rs.next()) {
				result = true;
			} else {
				result = false;
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

	/**********************************************Log data****************************************************************/

	
	




	/*************************************************************************************************************/

	/**********************************************************************************************/
	public ArrayList<String> getGidByUserID(int userID) {
		System.out.println("je suis entrer dans GET GID USER BY ID");
		ArrayList<String> result = new ArrayList<String>();
		Statement stmt = null;
		try {
			stmt = cnx.createStatement();	
			String query = "SELECT GID FROM FILE WHERE UserID = '"+ userID +"'";
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println("Executing query : " + query);			

			
			while (rs.next()) {
				String gid = rs.getString("gid");
				result.add(gid);
			}
			
			rs.close();
			stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
System.out.println("resultat = "+result);
		return result;
	}

	public void deleteByGID(String gid) {
		// TODO Auto-generated method stub		
			Statement stmt = null;
			
			try {
				stmt = cnx.createStatement();
				
				String query = "DELETE FROM FILE WHERE GID = '"+ gid + "'";
				stmt.executeUpdate(query);
				
				System.out.println("Executing query : " + query);		

				stmt.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	public void insertFile(int userID, String gid, String strEncryptedSkey, String encrIv, String command) {
		// TODO Auto-generated method stub
		
			Statement stmt = null;
			try {

				stmt = cnx.createStatement();
				String sql = "INSERT INTO FILE VALUES ("+idFile+", "+userID+", '"+gid+"', '"+strEncryptedSkey+"', '"+encrIv+"', '"+command+"')";
				stmt.executeUpdate(sql);
				
				System.out.println("Executing query : " + sql);	
				
				stmt.close();
			    idFile++;

			} catch (Exception e) {
				e.printStackTrace();
		}
	}
	


public FileDesc getFileDescByGid(String fileGID) {
		
		FileDesc result = null;
		Statement stmt = null;
		
		try {
			stmt = cnx.createStatement();

			String query = "SELECT SKey, IV FROM FILE WHERE GID ='"+ fileGID +"'";
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println("Executing query : " + query);
			
			String fileID = Constants.SERVER_Files_PATH + fileGID;
			
			while (rs.next()) {
				String SKey = rs.getString(1);
				String iv = rs.getString(2);
				result = new FileDesc(fileGID,fileID, SKey, iv,"","");
			}	
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

public MyInfo getUserByID(int userID_F) {
	// TODO Auto-generated method stub
	
	MyInfo res ;
	Statement stmt;
	try {
		stmt = cnx.createStatement();
		String query = "SELECT TcellIP, Port, PubKey FROM USERSINFO WHERE UserID = '"+userID_F+"';";
		ResultSet rs = stmt.executeQuery(query)
;			System.out.println("Executing query : " + query);			
	while (rs.next()) {
	String tcellIP = rs.getString("TcellIP");
	int port = rs.getInt("Port");
	String pubKey = rs.getString("PubKey");
	res = new MyInfo(userID_F, tcellIP, port, pubKey, null);
						}
	rs.close();
	stmt.close();
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
	}
	

	return null;
}

//list des contact
public List<EncryptContact> getContactsByUserID(int userID) {

	List<EncryptContact> result = new ArrayList<>();
	
	Statement stmt = null;
	
	try {
		stmt = cnx.createStatement();
		String query = "SELECT CUserID, CTcellIP, CPort, CPubKey FROM USERCONTACTS WHERE UserID = '"+ userID +"';";
		ResultSet rs = stmt.executeQuery(query);
		
		System.out.println("Executing query : " + query);			

		
		while (rs.next()) {
			String cUserID = rs.getString("CUserID");
			String cTcellIP = rs.getString("CTcellIP");
			String cPort = rs.getString("CPort");
			String cPubKey = rs.getString("CPubKey");
			
			EncryptContact EncryptedUser = new EncryptContact(cUserID, cTcellIP, cPort, cPubKey);
			result.add(EncryptedUser);
		}
		
		rs.close();
		stmt.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	return result;
}



//tester si l'utilsateur est dans notre base ou pas
public boolean isUserExists(int userid) {
	boolean result = false;
	Statement stmt = null;
	try {
		stmt = cnx.createStatement();
		String query = "SELECT ID, USERID FROM USERSINFO WHERE USERID = '" + userid +"'";
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("Executing query : " + query);				
		if (rs.next()) {
			result = true;
		} else {
			result = false;
		}		
		rs.close();
		stmt.close();	
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
}



//ajouter les information du client
public void insertUserInfo(int userGID, String TcellIP, int listenPort, String pubkey) {
	Statement stmt = null;
	try {

		
		
		stmt = cnx.createStatement();
		String sql = "INSERT INTO USERSINFO VALUES ("+idUSERSINFO+", "+userGID+", '"+TcellIP+"', "+listenPort+", '"+pubkey+"')";
		stmt.executeUpdate(sql);
		
		System.out.println("Executing query : " + sql);	
		
		stmt.close();
	    idUSERSINFO++;

	} catch (Exception e) {
		e.printStackTrace();
	}
}


public boolean isUserContactsExists(int userid, String cUserid) {
	boolean result = false;

	Statement stmt = null;
	
	try {
		stmt = cnx.createStatement();
		String query = "SELECT ID, USERID, CUSERID FROM USERCONTACTS WHERE USERID = '" + userid +"' AND CUSERID = '" + cUserid +"'";
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("Executing query : " + query);			
		if (rs.next()) {
			result = true;
		} else {
			result = false;
		}
		rs.close();
		stmt.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
}

//Insert les contact du client
public void insertUserContacts(int userID, EncryptContact encryptedUser) {
	Statement stmt = null;
	try {	 
		String cUserID = encryptedUser.getEncryptedGID(); 
		String cTcellIP = encryptedUser.getEncryptedTCellIP();
		String cPort = encryptedUser.getEncryptedPort();
		String cPubKey = encryptedUser.getEncryptedPKey();
		stmt = cnx.createStatement();
		String sql = "INSERT INTO USERCONTACTS VALUES ("+idUserContacts+", "+userID+", '"+cUserID+"', '"+cTcellIP+"', '"+cPort+"', '"+cPubKey+"')";
		stmt.executeUpdate(sql);
		System.out.println("Executing query : " + sql);	
		stmt.close();
	    idUserContacts++;
	} catch (Exception e) {
		e.printStackTrace();
	}
}


}
