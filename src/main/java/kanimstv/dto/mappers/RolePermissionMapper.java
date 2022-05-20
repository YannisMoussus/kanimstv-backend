package kanimstv.dto.mappers;
import java.util.List;

import org.mapstruct.Mapper;

import kanimstv.dao.entities.RolePermissionEntity;
import kanimstv.dto.RolePermissionDto;

@Mapper(
    componentModel = "spring"
)
public interface RolePermissionMapper {

    RolePermissionDto mapEntityToDto(RolePermissionEntity rolePermissionEntity);
    List<RolePermissionDto> mapEntityListToDtoList(List<RolePermissionEntity> rolePermissionEntity);
    RolePermissionEntity mapDtoToEntity(RolePermissionDto rolePermissionDto);
    
}
