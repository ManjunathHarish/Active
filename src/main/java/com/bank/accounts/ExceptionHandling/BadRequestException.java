package com.bank.accounts.ExceptionHandling;

public class BadRequestException extends Exception {
	public BadRequestException(String message)
	{
		super(message);
	}
	
	public BadRequestException(Exception e) {
		super(e);
	}
}
