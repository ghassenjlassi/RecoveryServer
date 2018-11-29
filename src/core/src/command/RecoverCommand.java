package command;

public class RecoverCommand extends Command{
	private int USER_ID;
	public RecoverCommand(int numCommand, int USER_ID) {
		super(numCommand);
		// TODO Auto-generated constructor stub
		this.USER_ID = USER_ID;
		
	}
	
	public int getUserID() {
		return USER_ID;
	}

	public void setUserID(int USER_ID) {
		this.USER_ID = USER_ID;
	}

}
