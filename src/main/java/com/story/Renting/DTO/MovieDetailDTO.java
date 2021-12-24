package com.story.Renting.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.story.Renting.Enum.MovieStatus;

public class MovieDetailDTO {

    @JsonProperty("movie_id")
    private Long movieId;

    @JsonProperty("movie_name")
    private String movieName;

    @JsonProperty("price_per_day")
    private Integer pricePerDay;

    @JsonProperty("status")
    private MovieStatus status;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

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

    public MovieStatus getStatus() {
        return status;
    }

    public void setStatus(MovieStatus status) {
        this.status = status;
    }
}
