package com.movieRater.cognixia.utility;

import java.util.ArrayList;

import com.movieRater.cognixia.exceptions.ResourceNotFoundException;
import com.movieRater.cognixia.model.Movie;
import com.movieRater.cognixia.model.Rating;
import com.movieRater.cognixia.model.User;

public class StorageUtility 
{
	
	private ArrayList<Rating> RatingTracker = new ArrayList<Rating>();
	private ArrayList<Movie> MovieDb = new ArrayList<Movie>();
	private ArrayList<User> userDb = new ArrayList<User>();
	private ConsolePrinterUtility cpu = new ConsolePrinterUtility();
	
	public ArrayList<Rating> getRatingTracker() {
		return RatingTracker;
	}
	
	public ArrayList<Movie> getMovieDB() {
		return MovieDb;
	}
	
	public void addMovie(Movie toAdd)
	{
		this.MovieDb.add(toAdd);
	}
	
	public void addRating(Rating toAdd)
	{
		this.RatingTracker.add(toAdd);
	}
	public ArrayList<User> getUserDB() {
		return userDb;
	}

	public void addUser(User toAdd)
	{
		this.userDb.add(toAdd);
	}
	
	public int nextAvalibleUserId()
	{
		int toRet = 0;
		for (int i = 0; i < userDb.size(); i++)
		{
			if (userDb.get(i) != null)
			{
				toRet++;
			}
			else
			{
				return toRet;
			}
		}
		return toRet;
	}
	
	public int nextAvalibleMovieId()
	{
		int toRet = 0;
		for (int i = 0; i < MovieDb.size(); i++)
		{
			if (MovieDb.get(i) != null)
			{
				toRet++;
			}
			else
			{
				return toRet;
			}
		}
		return toRet+1;
	}
	
	public int nextAvalibleRatingId()
	{
		int toRet = 1;
		for (int i = 0; i < RatingTracker.size(); i++)
		{
			if (RatingTracker.get(i) != null)
			{
				toRet++;
			}
			else
			{
				return toRet;
			}
		}
		return toRet;
	}
	/*public void setRatingTracker(ArrayList<Rating> ratingTracker) {
		RatingTracker = ratingTracker;
	}
	
	public void setMovieDB(ArrayList<Movie> movieDB) {
		MovieDB = movieDB;
	} 
	*/
	
	public User findUser(String toFind) 
	{
		for (User x : userDb)
		{
			if (toFind.equalsIgnoreCase(x.getUsername()))
			{
				return x;
			}
		}
		return null;
	}
	
	public boolean isUsernameAvaliable(String isOpen) 
	{
		for (User x : userDb)
		{   
			if (x.getUsername().equalsIgnoreCase(isOpen))
			{
				return false;
			}
		}
		return true;
		
	}
	
	private double getMovieAvgRating(int movieId)
	{
		double avg = 0;
		double movieRating = 0;
		for (int i = 0; i < RatingTracker.size(); i++)
		{
			if(RatingTracker.get(i).getMovieId() == movieId)
			{
				avg += RatingTracker.get(i).getRating();
				movieRating++;
			}
		}
		if(movieRating == 0 )
		{
			movieRating =1;
		}
		avg = avg/movieRating;
		return avg;
	}
	
	public void printMovieList()
	{
		
		System.out.println("");
		String movieList = String.format("%-38s%-18s%s ", "__Movie Title__", "__Movie id__", "__Avg Rating/10__");
		movieList += ",";
		for (Movie x : getMovieDB())
		{
			
			String id = x.getId()+"";
			if(getMovieAvgRating(x.getId()) != 0.0)
			{
				movieList += String.format("%-43s%-20s%s  ", x.getName(), id, getMovieAvgRating(x.getId()));
			}
			else
			{
				movieList += String.format("%-43s%-17s%s  ", x.getName(), id,"No Ratings");
			}
			movieList += ",";
		}
		cpu.println(cpu.MultiLineinABox(movieList));
	}
	
}
