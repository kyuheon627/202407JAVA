package account;

public class AccountDTO {
	private int num;
	private String username;
	private String password;
	
	public AccountDTO(int num, String username, String password) {
		super();
		this.num = num;
		this.username = username;
		this.password = password;
	}

	public int getNum() {
		return num;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "AccountDTO [num=" + num + ", username=" + username + ", password=" + password + "]";
	}
	
}
