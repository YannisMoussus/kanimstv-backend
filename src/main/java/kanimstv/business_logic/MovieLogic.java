package kanimstv.business_logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kanimstv.dao.entities.MovieEntity;
import kanimstv.dao.repositories.MovieRepository;
import kanimstv.dto.MovieDto;
import kanimstv.dto.mappers.MovieMapper;

@Service
public class MovieLogic {
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private MovieMapper movieMapper;

    public MovieDto createMovie(MovieDto movieDto){
        MovieEntity movieEntity = movieMapper.mapDtoToEntity(movieDto);
        return movieMapper.mapEntityToDto(movieRepository.save(movieEntity));
    }

    public List<MovieDto> getMovies(){
        return movieMapper.mapEntityListToDtoList(movieRepository.findAll());
    }

    public MovieDto getMovieById(int id){
        return movieMapper.mapEntityToDto(movieRepository.findById(id).orElse(null));
    }

    public MovieDto updateMovie(MovieDto movieDto){
        MovieEntity existingMovie = movieRepository.findById(movieDto.getId()).orElse(null);
        existingMovie.setName(movieDto.getName());
        existingMovie.setDescription(movieDto.getDescription());
        existingMovie.setTrailer(movieDto.getTrailer());
        existingMovie.setDuration(movieDto.getDuration());
        existingMovie.setReleasedDate(movieDto.getReleasedDate());
        existingMovie.setBill(movieDto.getBill());
        existingMovie.setAgeLimit(movieDto.getAgeLimit());
        existingMovie.setMark(movieDto.getMark());
        return movieMapper.mapEntityToDto(movieRepository.save(existingMovie));
    }

    public String deleteMovie(int id){
        movieRepository.deleteById(id);
        return "Movie" + id;
    }

}
