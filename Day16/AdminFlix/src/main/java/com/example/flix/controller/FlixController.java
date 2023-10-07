package com.example.flix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.flix.exception.DataNotFoundException;
import com.example.flix.model.Flix;
import com.example.flix.repository.FlixRepository;

import java.util.List;


@RestController
// @RequestMapping("/movies")
@CrossOrigin("http://localhost:3000")
public class FlixController {

    @Autowired
    private FlixRepository flix;

    @PostMapping("/post")
    Flix newUser(@RequestBody Flix newUser) {
        return flix.save(newUser);
    }

    @GetMapping("/get")
    List<Flix> getAllUsers() {
        return flix.findAll();
    }

    @GetMapping("/get/{id}")
    Flix getUserById(@PathVariable Long id) {
        return flix.findById(id)
                .orElseThrow(() -> new DataNotFoundException(id));
    }

    @PutMapping("/put/{id}")
    Flix updateUser(@RequestBody Flix newUser, @PathVariable Long id) {
        return flix.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setDate(newUser.getDate());
                    // user.setGenre(newUser.getGenre());
                    user.setRating(newUser.getRating());
                    user.setTime(newUser.getTime());
                    return flix.save(user);
                }).orElseThrow(() -> new DataNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!flix.existsById(id)){
            throw new DataNotFoundException(id);
        }
        flix.deleteById(id);
        return  "Movie Data With Id "+id+" Has Been Deleted.";
    }


}