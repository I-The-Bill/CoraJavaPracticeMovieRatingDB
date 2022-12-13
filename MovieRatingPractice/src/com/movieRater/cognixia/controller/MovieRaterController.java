package com.movieRater.cognixia.controller;

import java.util.Scanner;

import com.movieRater.cognixia.exceptions.InvalidCredentialsException;
import com.movieRater.cognixia.exceptions.ResourceNotFoundException;
import com.movieRater.cognixia.model.User;
import com.movieRater.cognixia.utility.ConsolePrinterUtility;
import com.movieRater.cognixia.utility.StorageUtility;

public class MovieRaterController 
{
	private Scanner in = new Scanner(System.in);
	private ConsolePrinterUtility cpu = new ConsolePrinterUtility();
	private StorageUtility su = new StorageUtility();
	
	public void mainRan()
	{
		User admin = new User(su.nextAvalibleUserId(),"Admin","password");
		su.addUser(admin);
		boolean makeSelection = true;
		User currentUser = null;
		while(makeSelection)
		{
			cpu.printlnYellow(cpu.MultiLineinABox("1. Register,2. Login,3. View Movies,4. Rate a Movie,5. Exit"));
			cpu.println("Please enter the number of the choice you'd like to do");
			try
			{
				int choice1 = Integer.parseInt(in.nextLine());
				if (choice1 == 1 )
				{
					if(currentUser != null)
					{
						cpu.println(cpu.inABox("Already Logged in"));
						continue;
					}
					String username, password;
					cpu.println("Please enter a username");
					username = in.nextLine();
					if(su.isUsernameAvaliable(username) == false)
					{
						cpu.println(cpu.inABox("Username is taken"));
						continue;
					}
					cpu.println("Please enter a password");
					password = in.nextLine();
					int id = su.nextAvalibleUserId();
					cpu.println("You're User Id # is: " + id);
					User toAdd = new User(id,username,password);
					su.addUser(toAdd);
				}
				else if (choice1 == 2)
				{
					if(currentUser != null)
					{
						cpu.println(cpu.inABox("Already Logged in"));
						continue;
					}
					cpu.println("Please enter a username");
					String search = in.nextLine();
					User found = su.findUser(search);
					if(found != null)
					{	
						cpu.println("Please enter your password");
						String pass = in.nextLine();
						if (pass.equals(found.getPassword()))
						{
							currentUser = found;
							cpu.printlnGreen(cpu.inABox("Login Successful"));
						}
						else
						{
							throw new InvalidCredentialsException("Your password is inccorect");
						}
					}
					else
					{
						throw new ResourceNotFoundException("User not found");
					}
				}
				else if (choice1 == 3)
				{
					
				}
				else if (choice1 == 4)
				{
					if(currentUser == null)
					{
						cpu.println("Please Login in to rate a movie");
					}
					else
					{
						
					}
				}
				else if (choice1 == 5)
				{
					makeSelection = false;
				}
				else
				{
					
				}
			}
			catch(Exception e)
			{
				cpu.printlnRed(cpu.inABox(e.getMessage()));
			}
		}
	}
}
