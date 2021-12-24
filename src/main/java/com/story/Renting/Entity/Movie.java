package com.story.Renting.Entity;

import com.story.Renting.Enum.MovieStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize =  1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_sequence")
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "movie_name", nullable = false)
    private String movieName;

    @Column(name = "price_per_day", nullable = false)
    private Integer pricePerDay;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private MovieStatus status;

    public Movie() {
        // Do Nothing
    }

    public Movie(Long movieId, String movieName, Integer pricePerDay, MovieStatus status) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.pricePerDay = pricePerDay;
        this.status = status;
    }

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

    @Override
    public boolean equals(Object m) {
        if (this == m) return true;
        if (m == null || getClass() != m.getClass()) return false;
        Movie that = (Movie) m;
        return Objects.equals(movieId, that.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", status=" + status +
                '}';
    }
}
