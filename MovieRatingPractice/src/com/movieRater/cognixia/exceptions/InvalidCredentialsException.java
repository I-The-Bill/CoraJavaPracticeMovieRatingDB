package com.movieRater.cognixia.exceptions;

public class InvalidCredentialsException extends Exception
{
	public InvalidCredentialsException()
	{
		super();
	}
	
	public InvalidCredentialsException(String x)
	{
		super(x);
	}
}
