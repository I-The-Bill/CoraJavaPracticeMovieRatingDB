package com.movieRater.cognixia.model;

public class Rating 
{
	private int ratingId;
	private int movieId;
	private int UserId;
	private int rating;
	
	public Rating(int ratingId, int movieId, int rating) {
		super();
		this.ratingId = ratingId;
		this.movieId = movieId;
		this.rating = rating;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", movieId=" + movieId + ", rating=" + rating + "]";
	}
	
	
	
}
