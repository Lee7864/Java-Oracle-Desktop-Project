package project2;

public class MemberBean {
	private int idx;
	private String userID;
	private String userPassword;
	private String userName;
	
	MemberMgr mgr = new MemberMgr();
	DBConnectionMgr pool = new DBConnectionMgr();
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
