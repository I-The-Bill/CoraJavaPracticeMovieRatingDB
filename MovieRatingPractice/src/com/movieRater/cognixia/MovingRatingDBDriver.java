package com.movieRater.cognixia;

import java.util.Scanner;

import com.movieRater.cognixia.controller.MovieRaterController;
import com.movieRater.cognixia.utility.ConsolePrinterUtility;

public class MovingRatingDBDriver 
{
	public static void main(String[] args)
	{
		ConsolePrinterUtility cpu = new ConsolePrinterUtility();
		MovieRaterController MRC = new MovieRaterController();
		cpu.printlnGreen("\n+__Welcome to the Movie Rater__+\n");
		MRC.mainRan();
	}
}
