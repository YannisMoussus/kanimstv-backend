package kanimstv.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kanimstv.business_logic.MovieLogic;
import kanimstv.dto.MovieDto;

@RestController
@RequestMapping("/movies")
public class MovieRestController {
    
    @Autowired
    private MovieLogic movieLogic;

    @PostMapping
    public MovieDto createMovie(@RequestBody MovieDto movieDto){
        return movieLogic.createMovie(movieDto);
    }

    @GetMapping
    public List<MovieDto> getMovies(){
        return movieLogic.getMovies();
    }

    @GetMapping("/{id}")
    public MovieDto getMovieById(@PathVariable int id){
        return movieLogic.getMovieById(id);
    }

    @PutMapping
    public MovieDto updateMovie(@RequestBody MovieDto movieDto){
        return movieLogic.updateMovie(movieDto);    
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable int id){
        return movieLogic.deleteMovie(id);
    }


}
