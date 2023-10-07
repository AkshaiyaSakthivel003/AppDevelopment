package com.example.flix.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.OneToOne;

@Entity
@Table(name = "admin")
public class Flix {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "movie_name")
	private String movie_name;

	@Column(name = "movie_date")
	private String movie_date;
	
	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "movie_genre")
	// private Genre genre;

	@Column(name = "movie_rating")
	private String movie_rating;

	@Column(name = "movie_time")
	private String movie_time;
	
	public Flix(int id, String name, String date, String rating, String time) 
	{
		this.id = id;
		this.movie_name = name;
		this.movie_date = date;
		// this.genre = genre;
		this.movie_rating = rating;
		this.movie_time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return movie_name;
	}

	public void setName(String name) {
		this.movie_name = name;
	}

	public String getDate() {
		return movie_date;
	}

	public void setDate(String date) {
		this.movie_date = date;
	}

	// public Genre getGenre() {
	// 	return genre;
	// }

	// public void setGenre(Genre genre) {
	// 	this.genre = genre;
	// }

	public String getRating() {
		return movie_rating;
	}

	public void setRating(String rating) {
		this.movie_rating = rating;
	}

	public String getTime() {
		return movie_time;
	}

	public void setTime(String time) {
		this.movie_time = time;
	}

	
}