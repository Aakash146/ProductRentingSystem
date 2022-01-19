package com.story.Renting.Service;

import com.story.Renting.DTO.MovieDTO;
import com.story.Renting.DTO.MovieDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService{
    @Override
    public List<MovieDetailDTO> getAllMoviesDetail() {
        return null;
    }

    @Override
    public String addNewMovie(MovieDTO movieDTO) {
        return null;
    }

    @Override
    public String updatePriceOfMovie(Long id) {
        return null;
    }

    @Override
    public String deleteMovie(Long movieId) {
        return null;
    }
}
