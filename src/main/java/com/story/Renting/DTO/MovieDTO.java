package com.story.Renting.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDTO {

    @JsonProperty("movie_name")
    private String movieName;

    @JsonProperty("price_per_day")
    private Integer pricePerDay;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Integer pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    
}
