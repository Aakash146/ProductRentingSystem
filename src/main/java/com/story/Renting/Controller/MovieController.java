package com.story.Renting.Controller;

import com.story.Renting.DTO.MovieDTO;
import com.story.Renting.DTO.MovieDetailDTO;
import com.story.Renting.Entity.Movie;
import com.story.Renting.Service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/movie")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping
    public List<MovieDetailDTO> getAllMoviesDetail(){

        return movieService.getAllMoviesDetail();
    }

    @PostMapping
    public Movie addNewMovie(@RequestBody MovieDTO movieDTO){

        return movieService.addNewMovie(movieDTO);
    }

    @PutMapping(path = "{movieId}")
    public Movie updatePriceOfMovie(@PathVariable("movieId") Long id, @RequestBody MovieDTO movieDTO){

        return movieService.updatePriceOfMovie(id, movieDTO);
    }

    @DeleteMapping(path = "{movieId}")
    public String deleteMovie(@PathVariable("movieId") Long movieId){

        return movieService.deleteMovie(movieId);
    }
}
