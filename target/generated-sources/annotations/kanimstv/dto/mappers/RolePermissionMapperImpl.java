package kanimstv.dto.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kanimstv.dao.entities.RolePermissionEntity;
import kanimstv.dto.RolePermissionDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-05T14:22:26+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 16.0.1 (AdoptOpenJDK)"
)
@Component
public class RolePermissionMapperImpl implements RolePermissionMapper {

    @Override
    public RolePermissionDto mapEntityToDto(RolePermissionEntity rolePermissionEntity) {
        if ( rolePermissionEntity == null ) {
            return null;
        }

        RolePermissionDto rolePermissionDto = new RolePermissionDto();

        rolePermissionDto.setId( rolePermissionEntity.getId() );
        rolePermissionDto.setName( rolePermissionEntity.getName() );

        return rolePermissionDto;
    }

    @Override
    public RolePermissionEntity mapDtoToEntity(RolePermissionDto rolePermissionDto) {
        if ( rolePermissionDto == null ) {
            return null;
        }

        RolePermissionEntity rolePermissionEntity = new RolePermissionEntity();

        rolePermissionEntity.setId( rolePermissionDto.getId() );
        rolePermissionEntity.setName( rolePermissionDto.getName() );

        return rolePermissionEntity;
    }

    @Override
    public List<RolePermissionDto> mapEntityListToDtoList(List<RolePermissionEntity> rolePermissionEntity) {
        if ( rolePermissionEntity == null ) {
            return null;
        }

        List<RolePermissionDto> list = new ArrayList<RolePermissionDto>( rolePermissionEntity.size() );
        for ( RolePermissionEntity rolePermissionEntity1 : rolePermissionEntity ) {
            list.add( mapEntityToDto( rolePermissionEntity1 ) );
        }

        return list;
    }

    @Override
    public List<RolePermissionEntity> mapDtoListToEntityList(List<RolePermissionDto> rolePermissionDto) {
        if ( rolePermissionDto == null ) {
            return null;
        }

        List<RolePermissionEntity> list = new ArrayList<RolePermissionEntity>( rolePermissionDto.size() );
        for ( RolePermissionDto rolePermissionDto1 : rolePermissionDto ) {
            list.add( mapDtoToEntity( rolePermissionDto1 ) );
        }

        return list;
    }
}
