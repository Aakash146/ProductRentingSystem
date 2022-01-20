package com.story.Renting.Service;

import com.story.Renting.DTO.MovieDTO;
import com.story.Renting.DTO.MovieDetailDTO;
import com.story.Renting.Entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService{
    @Override
    public List<MovieDetailDTO> getAllMoviesDetail() {
        return null;
    }

    @Override
    public Movie addNewMovie(MovieDTO movieDTO) {
        return null;
    }

    @Override
    public Movie updatePriceOfMovie(Long id, MovieDTO movieDTO) {
        return null;
    }

    @Override
    public String deleteMovie(Long movieId) {
        return null;
    }
}
