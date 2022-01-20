package com.story.Renting.Service;

import com.story.Renting.DTO.MovieDTO;
import com.story.Renting.DTO.MovieDetailDTO;
import com.story.Renting.Entity.Movie;

import java.util.List;

public interface IMovieService {
    List<MovieDetailDTO> getAllMoviesDetail();

    Movie addNewMovie(MovieDTO movieDTO);

    Movie updatePriceOfMovie(Long id, MovieDTO movieDTO);

    String deleteMovie(Long movieId);
}
