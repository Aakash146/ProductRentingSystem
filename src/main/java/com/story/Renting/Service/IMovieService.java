package com.story.Renting.Service;

import com.story.Renting.DTO.MovieDTO;
import com.story.Renting.DTO.MovieDetailDTO;

import java.util.List;

public interface IMovieService {
    List<MovieDetailDTO> getAllMoviesDetail();

    String addNewMovie(MovieDTO movieDTO);

    String updatePriceOfMovie(Long id);

    String deleteMovie(Long movieId);
}
