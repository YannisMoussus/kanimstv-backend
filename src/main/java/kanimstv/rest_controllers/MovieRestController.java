package kanimstv.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

}
