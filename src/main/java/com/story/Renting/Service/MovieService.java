package com.story.Renting.Service;

import com.story.Renting.DTO.MovieDTO;
import com.story.Renting.DTO.MovieDetailDTO;
import com.story.Renting.Entity.Movie;
import com.story.Renting.Enum.MovieStatus;
import com.story.Renting.Repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class MovieService implements IMovieService{

    public static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);
    @Autowired
    private MovieRepository movieRepository;


    @Override
    @Transactional
    public List<MovieDetailDTO> getAllMoviesDetail() {
        final List<Movie> movies = movieRepository.findAll();
        final List<MovieDetailDTO> dtos = new ArrayList<>();
        movies.forEach(movie -> {
            final MovieDetailDTO dto = new MovieDetailDTO();
            dto.setMovieName(movie.getMovieName());
            dto.setMovieId(movie.getMovieId());
            dto.setPricePerDay(movie.getPricePerDay());
            dto.setStatus(movie.getStatus());
            dtos.add(dto);
        });
        return dtos;
    }

    @Override
    @Transactional
    public Movie addNewMovie(MovieDTO movieDTO) {
        final Movie movie = movieRepository.findBymovieName(movieDTO.getMovieName());
        if(Objects.nonNull(movie)){
            LOGGER.error("Movie with name: '" + movieDTO.getMovieName() + "' already exists.");
            throw new IllegalStateException("Movie with name: '" + movieDTO.getMovieName() + "' already exists.");
        }
        final Movie newMovie = new Movie();
        newMovie.setMovieName(movieDTO.getMovieName());
        newMovie.setPricePerDay(movieDTO.getPricePerDay());
        newMovie.setStatus(MovieStatus.IN_LIBRARY);
        movieRepository.save(newMovie);
        LOGGER.info("Movie with name: '" + movieDTO.getMovieName() + "' successfully added in library.");
        return newMovie;
    }

    @Override
    @Transactional
    public Movie updatePriceOfMovie(Long movieId, MovieDTO movieDTO) {
        boolean exists = movieRepository.existsById(movieId);
        if(!exists){
            LOGGER.error("Movie with movieId "+ movieId + " does not exists.");
            throw new IllegalStateException("Movie with movieId "+ movieId + " does not exists.");
        }
        final Movie movie = movieRepository.findBymovieId(movieId);
        Integer oldPrice = movie.getPricePerDay();
        movie.setPricePerDay(movieDTO.getPricePerDay());
        movieRepository.save(movie);
        LOGGER.info("Price for movie: '" + movie.getMovieName() + "' is changed from " + oldPrice + " to " + movie.getPricePerDay() + ".");
        return movie;
    }

    @Override
    @Transactional
    public String deleteMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if(!exists){
            LOGGER.error("Movie with movieId "+ movieId + " does not exists.");
            throw new IllegalStateException("Movie with movieId "+ movieId + " does not exists.");
        }
        final Movie movie = movieRepository.findBymovieId(movieId);
        String movieName = movie.getMovieName();
        movieRepository.deleteById(movieId);
        LOGGER.info("Movie with movie_Name: '" + movieName + "' successfully deleted.");
        return "Movie with movie_Name: '" + movieName + "' successfully deleted.";
    }
}
