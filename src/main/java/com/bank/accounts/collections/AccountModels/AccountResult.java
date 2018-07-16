package com.bank.accounts.collections.AccountModels;

import java.util.List;
public class AccountResult {
	private String status;
	private String description;
	private List<AccountDetails> data;
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
	public List<AccountDetails> getData() {
		return data;
	}
	public void setData(List<AccountDetails> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "[status=" + status + ", description=" + description + ", data=" + data + "]";
	}
}

