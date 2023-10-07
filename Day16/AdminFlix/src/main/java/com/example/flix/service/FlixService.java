package com.example.flix.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.flix.exception.ResourceNotFoundException;
import com.example.flix.model.Flix;
import com.example.flix.repository.FlixRepository;


@Service
public class FlixService {
    
    @Autowired
    private FlixRepository movieRepository;

    public List<Flix> getAllMovies(){
		return movieRepository.findAll();
	}

    public Flix createMovie(@RequestBody Flix movie) {
		return movieRepository.save(movie);
	}

    public Flix getMovieById(@PathVariable int id) {
		Flix movie = movieRepository.findById((long) id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie not exist with id :" + id));
		return movie;
	}

    public Flix updateMovie(@PathVariable Integer id, @RequestBody Flix movieDetails){
		Flix movie = movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie not exist with id :" + id));
		
		movie.setName(movieDetails.getName());
		movie.setDate(movieDetails.getDate());
		// movie.setGenre(movieDetails.getGenre());
		movie.setRating(movieDetails.getRating());
		movie.setTime(movieDetails.getTime());
		
		Flix updatedMovie = movieRepository.save(movie);
		return updatedMovie;
	}

    public void deleteMovie(@PathVariable int id){
		movieRepository.deleteById((long) id);
	}
}

