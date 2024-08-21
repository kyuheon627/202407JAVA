package com.board.db;

public class AccountDto {

	private String id = "";
	private String name = "";
	private String pwd = "";
	
	public AccountDto(String id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	
	
	
	public AccountDto() {
		super();
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "AccountDto [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
	
	
}
