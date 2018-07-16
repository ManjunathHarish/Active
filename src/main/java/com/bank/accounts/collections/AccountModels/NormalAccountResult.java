package com.bank.accounts.collections.AccountModels;

public class NormalAccountResult {
	private String status;
	private String description;
	private AccountDetails data;
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
	public AccountDetails getData() {
		return data;
	}
	public void setData(AccountDetails data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "[status=" + status + ", description=" + description + ", data=" + data + "]";
	}
}
