package com.story.Renting.Repository;

import com.story.Renting.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findBymovieName(String movieName);

    Movie findBymovieId(Long movieId);
}
