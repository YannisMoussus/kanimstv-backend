package kanimstv.dto.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import kanimstv.dao.entities.MovieEntity;
import kanimstv.dto.MovieDto;

@Mapper(
    componentModel = "spring"
)
public interface MovieMapper {
    
    MovieDto mapEntityToDto(MovieEntity movieEntity);
    MovieEntity mapDtoToEntity(MovieDto movieDto);
    List<MovieDto> mapEntityListToDtoList(List<MovieEntity> movieEntities);
    List<MovieEntity> mapDtoListToEntityList(List<MovieDto> movieDtos);

}
