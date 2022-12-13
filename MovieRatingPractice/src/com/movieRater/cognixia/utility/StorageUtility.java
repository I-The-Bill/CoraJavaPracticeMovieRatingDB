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
	
	
	public ArrayList<User> getUserDB() {
		return userDb;
	}

	public void addUser(User toAdd)
	{
		this.userDb.add(toAdd);
	}
	
	public int nextAvalibleUserId()
	{
		return userDb.size();
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
		for(int i = 0; i < userDb.size(); i++)
		{
			if (toFind.equalsIgnoreCase(userDb.get(i).getUsername()));
			{
				return userDb.get(i);
			}
		}
		return null;
	}
	
	public boolean isUsernameAvaliable(String x) 
	{
		User exist = findUser(x);

		if (exist == null)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
}
