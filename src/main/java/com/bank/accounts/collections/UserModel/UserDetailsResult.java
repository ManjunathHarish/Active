package com.bank.accounts.collections.UserModel;

public class UserDetailsResult {
	private String status;
	private String description;
	private UserDetails data;
	public String getStatus() {
		return status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserDetails getData() {
		return data;
	}
	public void setData(UserDetails data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "[status=" + status + ", description=" + description + ", data=" + data + "]";
	}
}
