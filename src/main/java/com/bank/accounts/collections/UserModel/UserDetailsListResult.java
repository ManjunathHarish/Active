package com.bank.accounts.collections.UserModel;

import java.util.List;

public class UserDetailsListResult {
	private String status;
	private String description;
	private List<UserDetails> data;
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
	public List<UserDetails> getData() {
		return data;
	}
	public void setData(List<UserDetails> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "[status=" + status + ", description=" + description + ", data=" + data + "]";
	}
}
