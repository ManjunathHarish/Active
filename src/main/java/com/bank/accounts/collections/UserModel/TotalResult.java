package com.bank.accounts.collections.UserModel;

import java.util.List;

public class TotalResult {
	private String status;
	private String description;
	private List<Object> data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "TotalResult [status=" + status + ", description=" + description + ", data=" + data + "]";
	} 
	
	
}
