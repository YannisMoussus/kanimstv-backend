package kanimstv.dto.mappers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import kanimstv.dao.entities.MovieEntity;
import kanimstv.dto.MovieDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-05T14:22:26+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 16.0.1 (AdoptOpenJDK)"
)
@Component
public class MovieMapperImpl implements MovieMapper {

    @Override
    public MovieDto mapEntityToDto(MovieEntity movieEntity) {
        if ( movieEntity == null ) {
            return null;
        }

        MovieDto movieDto = new MovieDto();

        movieDto.setId( movieEntity.getId() );
        movieDto.setName( movieEntity.getName() );
        movieDto.setDescription( movieEntity.getDescription() );
        movieDto.setDuration( movieEntity.getDuration() );
        movieDto.setReleasedDate( movieEntity.getReleasedDate() );
        byte[] bill = movieEntity.getBill();
        if ( bill != null ) {
            movieDto.setBill( Arrays.copyOf( bill, bill.length ) );
        }
        movieDto.setAgeLimit( movieEntity.getAgeLimit() );
        movieDto.setMark( movieEntity.getMark() );

        return movieDto;
    }

    @Override
    public MovieEntity mapDtoToEntity(MovieDto movieDto) {
        if ( movieDto == null ) {
            return null;
        }

        MovieEntity movieEntity = new MovieEntity();

        movieEntity.id( movieDto.getId() );
        movieEntity.name( movieDto.getName() );
        movieEntity.description( movieDto.getDescription() );
        movieEntity.duration( movieDto.getDuration() );
        movieEntity.releasedDate( movieDto.getReleasedDate() );
        byte[] bill = movieDto.getBill();
        if ( bill != null ) {
            movieEntity.bill( Arrays.copyOf( bill, bill.length ) );
        }
        movieEntity.ageLimit( movieDto.getAgeLimit() );
        movieEntity.mark( movieDto.getMark() );

        return movieEntity;
    }

    @Override
    public List<MovieDto> mapEntityListToDtoList(List<MovieEntity> movieEntities) {
        if ( movieEntities == null ) {
            return null;
        }

        List<MovieDto> list = new ArrayList<MovieDto>( movieEntities.size() );
        for ( MovieEntity movieEntity : movieEntities ) {
            list.add( mapEntityToDto( movieEntity ) );
        }

        return list;
    }

    @Override
    public List<MovieEntity> mapDtoListToEntityList(List<MovieDto> movieDtos) {
        if ( movieDtos == null ) {
            return null;
        }

        List<MovieEntity> list = new ArrayList<MovieEntity>( movieDtos.size() );
        for ( MovieDto movieDto : movieDtos ) {
            list.add( mapDtoToEntity( movieDto ) );
        }

        return list;
    }
}
