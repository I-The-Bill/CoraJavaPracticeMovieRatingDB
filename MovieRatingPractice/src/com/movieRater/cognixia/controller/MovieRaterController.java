package com.movieRater.cognixia.controller;


import java.util.Scanner;

import com.movieRater.cognixia.exceptions.InvalidCredentialsException;
import com.movieRater.cognixia.exceptions.ResourceNotFoundException;
import com.movieRater.cognixia.model.Movie;
import com.movieRater.cognixia.model.Rating;
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
		su.addUser(new User(su.nextAvalibleUserId(),"Admin","password"));
		su.addMovie(new Movie(su.nextAvalibleMovieId(), "Star Wars: The Phantom Mence", "2 Jedi Knights seek to end the Blockade of the Planet Naboo and end up on a journey."));
		su.addMovie(new Movie(su.nextAvalibleMovieId(), "Star Wars: Revenge of the Sith", "The final stages of the Clone Wars. Will Jedi Knight Anakin Skywalker stay with jedi or become the fearsome Darth Vader"));
		su.addMovie(new Movie(su.nextAvalibleMovieId(), "Kung Fu Panda", "A Kung Fu fantic Panda messes around and finds out"));
		boolean makeSelection = true;
		User currentUser = null;
		
		while(makeSelection)
		{
			cpu.printlnYellow(cpu.MultiLineinABox("1. Register,2. Login,3. View Movies,4. Rate a Movie,5. Logout,0. Exit"));
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
					cpu.println("Please enter a username");
					String username = in.nextLine();
					if(su.isUsernameAvaliable(username) == false)
					{
						cpu.println(cpu.inABox("Username is taken"));
						continue;
					}
					cpu.println("Please enter a password");
					String password = in.nextLine();
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
							cpu.printlnBlue(found.getPassword());
							throw new InvalidCredentialsException("Your password is incorrect");
						}
					}
					else
					{
						throw new ResourceNotFoundException("User not found");
					}
				}
				
				
				else if (choice1 == 3)
				{
					su.printMovieList();
				}
				
				
				else if (choice1 == 4)
				{
					if(currentUser == null)
					{
						cpu.printlnRed(cpu.inABox("Please Login in to rate a movie"));
					}
					else
					{
						su.printMovieList();
						boolean ratingTheMovie = true;
						while (ratingTheMovie)
						try
						{
							
							cpu.println("Please enter the id of ther movie you'd like to rate or type 0 to go back");
							int movieChoice = Integer.parseInt(in.nextLine());
							if(movieChoice == 0)
							{
								break;
							}
							Movie doesMovieExist = su.getMovieDB().get(movieChoice);
							cpu.println("How would rate the move between 1-10 (Only whole Numbers accepted)");
							int userRating = Integer.parseInt(in.nextLine());
							if (userRating < 0 || userRating > 10)
							{
								cpu.printlnRed(cpu.inABox("Invalid Rating.  Returning to main menu"));
								break;
							}
							Rating toAdd = new Rating(su.nextAvalibleRatingId(),currentUser.getUserId(),movieChoice,userRating);
							su.addRating(toAdd);
							ratingTheMovie = false;
							
						}
						catch(Exception e)
						{
							cpu.printlnRed(cpu.inABox("Please enter a valid id or type 0 to go back"));
						}
					}
				}
				
				
				else if (choice1 == 5)
				{
					if (currentUser != null)
					{
						currentUser = null;
						cpu.printlnGreen(cpu.inABox("Log Out Successful"));
					}
					else
					{
						cpu.printlnRed(cpu.inABox("Not Logged in"));
					}
				}
				else if (choice1 == 0)
				{
					makeSelection = false;
				}
				
				else
				{
					cpu.printlnRed(cpu.inABox("Please Enter a Valid choice"));
				}
			}
			catch(NumberFormatException e)
			{
				cpu.printlnRed(cpu.inABox("Please Enter a Valid choice"));
			}
			catch(Exception e)
			{
				//cpu.printlnRed(e.getStackTrace()[0].toString());
				e.printStackTrace();
			}
		}
	}
}
