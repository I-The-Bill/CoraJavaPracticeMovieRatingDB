package com.movieRater.cognixia.utility;

public class ColorsUtility 
{
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_WHITE = "\u001B[37m";
	private static final String ANSI_BLACK = "\u001B[30m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_PURPLE = "\u001B[35m";
	private static final String ANSI_CYAN = "\u001B[36m";

	public String white(String x)
	{
		return ANSI_WHITE + x + ANSI_RESET; 
	}
	
	public String black(String x)
	{
		return ANSI_BLACK + x + ANSI_RESET; 
	}
	
	public String red(String x)
	{
		return ANSI_RED + x + ANSI_RESET; 
	}
	
	public String green(String x)
	{
		return ANSI_GREEN + x + ANSI_RESET; 
	}
	
	public String yellow(String x)
	{
		return ANSI_YELLOW + x + ANSI_RESET; 
	}
	
	public String blue(String x)
	{
		return ANSI_BLUE + x + ANSI_RESET; 
	}
	
	public String purple(String x)
	{
		return ANSI_PURPLE + x + ANSI_RESET; 
	}
	
	public String cyan(String x)
	{
		return ANSI_CYAN + x + ANSI_RESET; 
	}
}
