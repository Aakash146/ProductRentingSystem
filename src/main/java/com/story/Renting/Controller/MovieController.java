package com.story.Renting.Controller;

import com.story.Renting.DTO.MovieDTO;
import com.story.Renting.DTO.MovieDetailDTO;
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
    public String addNewBook(@RequestBody MovieDTO movieDTO){

        return movieService.addNewMovie(movieDTO);
    }

    @PutMapping(path = "movieId")
    public String updatePriceOfMovie(@PathVariable("movieId") Long id){

        return movieService.updatePriceOfMovie(id);
    }

    @DeleteMapping(path = "movieId")
    public String deleteMovie(@PathVariable("movieId") Long movieId){

        return movieService.deleteMovie(movieId);
    }
}
