package com.example.app.model;
package com.example.weather.controller;

import com.example.weather.exception.DataNotFoundException;
import com.example.weather.model.Weather;
import com.example.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class WeatherController {

    @Autowired
    private WeatherRepository weatherRepository;

    @PostMapping("/user")
    Weather newUser(@RequestBody Weather newUser) {
        return weatherRepository.save(newUser);
    }

    @GetMapping("/users")
    List<Weather> getAllUsers() {
        return weatherRepository.findAll();
    }

    @GetMapping("/user/{id}")
    Weather getUserById(@PathVariable Long id) {
        return weatherRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(id));
    }.3

    @PutMapping("/user/{id}")
    Weather updateUser(@RequestBody Weather newUser, @PathVariable Long id) {
        return weatherRepository.findById(id)
                .map(user -> {
                    user.setTemperature(newUser.getTemperature());
                    user.setTime(newUser.getTime());
                    user.setWeather(newUser.getWeather());
                    user.setWind(newUser.getWind());
                    user.setPrecipitation(newUser.getPrecipitation());
                    return weatherRepository.save(user);
                }).orElseThrow(() -> new DataNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!weatherRepository.existsById(id)){
            throw new DataNotFoundException(id);
        }
        weatherRepository.deleteById(id);
        return  "Forecasting Data With Id "+id+" Has Been Deleted.";
    }


}