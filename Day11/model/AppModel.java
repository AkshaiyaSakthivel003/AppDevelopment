package com.example.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class AppModel {

    @Id
    @GeneratedValue
    private Long id;
    private String temperature;
    private String time;
    private String weather;
    private String wind;
    private String precipitation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }
    public void setTemperature(String temperature) {
    	this.temperature = temperature;
    }
    
    public String getTime() {
    	return time;
    }
    public void setTime(String time) {
    	this.time = time;
    }

   	public String getWeather() {
    	return weather;
   	}
   	public void setWeather(String weather) {
    	this.weather = weather;
   	}
   	
 	public String getWind() {
    	return wind;
   	}
   	public void setWind(String wind) {
    	this.wind = wind;
   	}
   	
   	public String getPrecipitation() {
    	return precipitation;
   	}	
   	public void setPrecipitation(String precipitation) {
    	this.precipitation = precipitation;
   	}

}
