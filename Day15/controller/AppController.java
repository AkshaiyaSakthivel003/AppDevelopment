package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.app.exception.DataNotFoundException;
import com.example.app.model.App;
import com.example.app.repository.AppRepository;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class AppController {

    @Autowired
    private AppRepository appRepository;

    @PostMapping("/user")
    App newUser(@RequestBody App newUser) {
        return appRepository.save(newUser);
    }

    @GetMapping("/users")
    List<App> getAllUsers() {
        return appRepository.findAll();
    }

    @GetMapping("/user/{id}")
    App getUserById(@PathVariable Long id) {
        return appRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    App updateUser(@RequestBody App newUser, @PathVariable Long id) {
        return appRepository.findById(id)
                .map(user -> {
                    user.setMovieName(newUser.getMovieName());
                    user.setYear(newUser.getYear());
                    return appRepository.save(user);
                }).orElseThrow(() -> new DataNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!appRepository.existsById(id)){
            throw new DataNotFoundException(id);
        }
        appRepository.deleteById(id);
        return  "Forecasting Data With Id "+id+" Has Been Deleted.";
    }


}