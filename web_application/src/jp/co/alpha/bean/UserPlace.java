package jp.co.alpha.bean;

public class UserPlace {
	private int id;
	private Users users;
	private CleanPlace cp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public CleanPlace getCp() {
		return cp;
	}

	public void setCp(CleanPlace cp) {
		this.cp = cp;
	}
}
