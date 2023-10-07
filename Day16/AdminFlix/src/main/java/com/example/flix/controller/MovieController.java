package com.example.flix.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flix.model.Flix;
import com.example.flix.service.FlixService;


@CrossOrigin
@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	private FlixService movieService;

//	@Autowired
//	private LoginService userService;
	
// get all remainder
	@GetMapping("/get")
	public List<Flix> getAllMovies(){
		return movieService.getAllMovies();
	}		
	
	
	@PostMapping("/post")
	public Flix createMovie(@RequestBody Flix movie) {
		return movieService.createMovie(movie);
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Flix> getMovieById(@PathVariable int id) {
		
		return ResponseEntity.ok(movieService.getMovieById(id));
	}
	
	
	@PutMapping("/put/{id}")
	public ResponseEntity<Flix> updateMovie(@PathVariable Integer id, @RequestBody Flix movieDetails){
		
		return ResponseEntity.ok(movieService.updateMovie(id, movieDetails));
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteMovie(@PathVariable int id){
		movieService.deleteMovie(id);
		// return "Deleted";
	}
	

//	//login
//
//	@PostMapping("/login")
//	public boolean verifyUser(@RequestBody Login user){
//		return userService.verifyUser(user);
//	}
//	
//	@PostMapping("/signup")
//	public boolean postUser(@RequestBody Login user){
//		return userService.postUser(user);
//	}
}
