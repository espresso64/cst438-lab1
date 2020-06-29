package cst438;
//Domain object

import javax.persistence.Entity;
import java.sql.Timestamp;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Entity will persist in database
@Entity

public class Movie {
	@Id
	@GeneratedValue
	private long id;

	//Instance variables
	@NotNull
	@Size(min=3, max=25)
	private String userName;

	@NotNull
	@Size(min=3, max=25)
	private String movieTitle;

	@NotNull
	@Min(value = 1)
	@Max(value = 5)
	private int movieRating;

	@Basic
	private Timestamp date;

	//No-arg constructor
	public Movie() {

	}

	//Constructor
	public Movie(long id, String userName, String movieTitle, int movieRating, Timestamp date) {
		super();
		this.id = id;
		this.userName = userName;
		this.movieTitle = movieTitle;
		this.movieRating = movieRating;
		this.date = date;
	}

	//Getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}
